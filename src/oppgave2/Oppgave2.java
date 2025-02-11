package oppgave2;

import java.util.Arrays;

public class Oppgave2 {
    
    // Innsettingssortering (Insertion Sort)
    public static void insertionSort(Integer[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }
    
    // Utvalgssortering (Selection Sort)
    public static void selectionSort(Integer[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        Integer[] array1 = {5, 2, 9, 1, 5, 6};
        Integer[] array2 = Arrays.copyOf(array1, array1.length);

        System.out.println("Før sortering: " + Arrays.toString(array1));
        insertionSort(array1);
        System.out.println("Etter Insertion Sort: " + Arrays.toString(array1));
        
        System.out.println("Før sortering: " + Arrays.toString(array2));
        selectionSort(array2);
        System.out.println("Etter Selection Sort: " + Arrays.toString(array2));
    }
}

