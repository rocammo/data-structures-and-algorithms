/**
 *  QuickSort.java
 *
 *  @author: Rodrigo Casamayor <alu.89657@usj.es>
 *  @date:   08 ene. 2019
*/

package estructuras;

import biblioteca.Libro;

public class QuickSort {
    public static void quickSort(Libro arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Ordena recursivamente los elementos de los 2 sub-arreglos
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(Libro arr[], int begin, int end) {
        int pivot = arr[end].getTitulo().charAt(0);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getTitulo().charAt(0) <= pivot) {
                i++;

                Libro swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Libro swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}