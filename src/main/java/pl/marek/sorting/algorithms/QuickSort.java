package pl.marek.sorting.algorithms;

import pl.marek.sorting.CurrencyTableSize;
import pl.marek.sorting.Observer;
import pl.marek.sorting.Subject;

import java.util.Random;

public class QuickSort implements Observer {

    private CurrencyTableSize currencyTableSize;
    int tabSize;
    long time;
    public QuickSort(CurrencyTableSize currencyTableSize) {
        this.currencyTableSize = currencyTableSize;
    }

    @Override
    public void printSortingTime(Subject s) {
        this.tabSize = currencyTableSize.getTabSize();
        int arr[] = new int[tabSize];
        long start;
        for(int i = 0 ; i<10 ; i++){
            fillRandomTab(arr);
            start = System.nanoTime();
            quickSort(arr, 0 , tabSize-1);
            time =+ System.nanoTime()-start;
        }
        System.out.println("Quick Sort: " + time / 1_000 * 10 + "µs");
    }

    private void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    private void fillRandomTab(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < tabSize; i++) {
            arr[i] = r.nextInt(tabSize);
        }
    }

}
