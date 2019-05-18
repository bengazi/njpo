package pl.marek.sorting.algorithms;

import pl.marek.sorting.CurrencyTableSize;
import pl.marek.sorting.Observer;
import pl.marek.sorting.Subject;

import java.util.Random;

public class SelectSort implements Observer {
    private CurrencyTableSize currencyTableSize;
    int tabSize;
    long time;

    public SelectSort(CurrencyTableSize currencyTableSize) {
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
            quickSort(arr);
            time =+ System.nanoTime()-start;
        }

        System.out.println("Select Sort: " + time / 1_000 * 10 + "µs");
    }

    private void quickSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    private void fillRandomTab(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < tabSize; i++) {
            arr[i] = r.nextInt(tabSize);
        }
    }
}
