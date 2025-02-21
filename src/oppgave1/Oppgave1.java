package oppgave1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Oppgave1 {
    public static void main(String[] args) {
        Random tilfeldig = new Random(12345); 
        int n = 32000;
        int antal = 10;
        Integer[][] a = new Integer[antal][n];

        
        for (int i = 0; i < antal; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }

        // Start tidsmåling
        Instant start = Instant.now();
        for (int i = 0; i < antal; i++) {
            sorter(a[i]); // Sorter hver rad
        }
        // Slutt tidsmåling
        Instant slutt = Instant.now();
        Duration tid = Duration.between(start, slutt);
        System.out.println("Sortering tok " + tid.toMillis() + " ms");
    }

    public static void sorter(Integer[] a) {
        int n = a.length;

        // Flytt minste element til indeks 0
        for (int i = n - 1; i > 0; i--) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                Integer temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }

        // Sett inn to elementer om gangen
        for (int i = 1; i < n - 1; i += 2) {
            Integer min, max;
            if (a[i].compareTo(a[i + 1]) < 0) {
                min = a[i];
                max = a[i + 1];
            } else {
                min = a[i + 1];
                max = a[i];
            }

            int j = i;
            while (j > 0 && a[j - 1].compareTo(max) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = max;

            j = i;
            while (j > 0 && a[j - 1].compareTo(min) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = min;
        }

        // Håndter siste element hvis n er odde
        if (n % 2 != 0) {
            Integer temp = a[n - 1];
            int j = n - 1;
            while (j > 0 && a[j - 1].compareTo(temp) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
}

