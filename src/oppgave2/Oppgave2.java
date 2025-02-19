package oppgave2;

import java.util.Random;

public class Oppgave2 {

    // Innsettingssortering
    public static void innsettingsSortering(Integer[] tabell) {
        for (int i = 1; i < tabell.length; i++) {
            int nøkkel = tabell[i];
            int j = i - 1;
            while (j >= 0 && tabell[j] > nøkkel) {
                tabell[j + 1] = tabell[j];
                j--;
            }
            tabell[j + 1] = nøkkel;
        }
    }

    // Utvalgssortering
    public static void utvalgssortering(Integer[] tabell) {
        for (int i = 0; i < tabell.length - 1; i++) {
            int minIndeks = i;
            for (int j = i + 1; j < tabell.length; j++) {
                if (tabell[j] < tabell[minIndeks]) {
                    minIndeks = j;
                }
            }
            int temp = tabell[minIndeks];
            tabell[minIndeks] = tabell[i];
            tabell[i] = temp;
        }
    }

    // Kvikksortering
    public static void kvikksortering(Integer[] tabell, int venstre, int høyre) {
        if (venstre < høyre) {
            int pivotIndeks = partisjon(tabell, venstre, høyre);
            kvikksortering(tabell, venstre, pivotIndeks - 1);
            kvikksortering(tabell, pivotIndeks + 1, høyre);
        }
    }

    private static int partisjon(Integer[] tabell, int venstre, int høyre) {
        int pivot = tabell[høyre];
        int i = venstre - 1;
        for (int j = venstre; j < høyre; j++) {
            if (tabell[j] < pivot) {
                i++;
                int temp = tabell[i];
                tabell[i] = tabell[j];
                tabell[j] = temp;
            }
        }
        int temp = tabell[i + 1];
        tabell[i + 1] = tabell[høyre];
        tabell[høyre] = temp;
        return i + 1;
    }

    // Flettesortering
    public static void flettesortering(Integer[] tabell, int venstre, int høyre) {
        if (venstre < høyre) {
            int midten = venstre + (høyre - venstre) / 2;
            flettesortering(tabell, venstre, midten);
            flettesortering(tabell, midten + 1, høyre);
            flette(tabell, venstre, midten, høyre);
        }
    }

    private static void flette(Integer[] tabell, int venstre, int midten, int høyre) {
        int n1 = midten - venstre + 1;
        int n2 = høyre - midten;

        int[] venstreDel = new int[n1];
        int[] høyreDel = new int[n2];

        for (int i = 0; i < n1; i++) {
            venstreDel[i] = tabell[venstre + i];
        }
        for (int j = 0; j < n2; j++) {
            høyreDel[j] = tabell[midten + 1 + j];
        }

        int i = 0, j = 0, k = venstre;
        while (i < n1 && j < n2) {
            if (venstreDel[i] <= høyreDel[j]) {
                tabell[k] = venstreDel[i];
                i++;
            } else {
                tabell[k] = høyreDel[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            tabell[k] = venstreDel[i];
            i++;
            k++;
        }

        while (j < n2) {
            tabell[k] = høyreDel[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nVerdier = {32000, 64000, 128000};
        int antallMålinger = 10;

        for (int n : nVerdier) {
            long totalTid = 0;
            for (int i = 0; i < antallMålinger; i++) {
                Integer[] tabell = genererTilfeldigTabell(n);
                long startTid = System.nanoTime();
                kvikksortering(tabell, 0, tabell.length -1); 
                // Endrer metode her for kjøring , 0, tabell.length - 1
                long sluttTid = System.nanoTime();
                totalTid += (sluttTid - startTid);
            }
            double gjennomsnittTid = (totalTid / (double) antallMålinger) / 1_000_000.0;
            System.out.println("n = " + n + ", Gjennomsnittlig tid: " + gjennomsnittTid + " ms");
        }
        
        //oppgave b)
        Integer[] likTabell = new Integer[100000];
        for (int i = 0; i < likTabell.length; i++) {
            likTabell[i] = 42; // Alle elementene er like
        }

        long startTid = System.nanoTime();
        kvikksortering(likTabell, 0, likTabell.length - 1);
        long sluttTid = System.nanoTime();

        double tidMs = (sluttTid - startTid) / 1_000_000.0;
        System.out.println("Tid for Quicksort med like elementer: " + tidMs + " ms");

    }

    private static Integer[] genererTilfeldigTabell(int n) {
        Random tilfeldig = new Random();
        Integer[] tabell = new Integer[n];
        for (int i = 0; i < n; i++) {
            tabell[i] = tilfeldig.nextInt();
        }
        return tabell;
    }
}



