package oppgave1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Oppgave1 {
	public static void main(String[] args) {
		Random tilfeldig = new Random(12345); // Fast seed for reproduserbarhet
		int n = 32000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];

		// Sett inn tilfeldige heltall i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}

		// Start tidsmåling
		Instant start = Instant.now();
		for (int i = 0; i < antal; i++) {
			sorter(a[i]); // Kaller den modifiserte sorteringsmetoden
		}
		// Slutt tidsmåling
		Instant slutt = Instant.now();
		Duration tid = Duration.between(start, slutt);
		System.out.println("Sortering tok " + tid.toMillis() + " ms");
	}

	public static void sorter(Integer[] a) {
		int n = a.length;

		// Trinn 1: Flytt minste element til indeks 0
		for (int i = n - 1; i > 0; i--) {
			if (a[i].compareTo(a[i - 1]) < 0) {
				int temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;
			}
		}

		// Trinn 2: Sett inn to elementer om gangen
		for (int i = 1; i < n - 1; i += 2) {
			int min, max;
			if (a[i].compareTo(a[i + 1]) < 0) {
				min = a[i];
				max = a[i + 1];
			} else {
				min = a[i + 1];
				max = a[i];
			}

			int j = i;
			while (a[j - 1].compareTo(max) > 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = max;

			j = i;
			while (a[j - 1].compareTo(min) > 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = min;
		}

		// Håndter siste element hvis n er odde
		if (n % 2 != 0) {
			int temp = a[n - 1];
			int j = n - 1;
			while (a[j - 1].compareTo(temp) > 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}

}
