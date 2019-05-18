package pl.marek.sorting.algorithms;

import pl.marek.sorting.CurrencyTableSize;
import pl.marek.sorting.Observer;
import pl.marek.sorting.Subject;

import java.util.Random;

public class BubbleSort implements Observer {

    private CurrencyTableSize currencyTableSize;
    int tabSize;
    long time;

    public BubbleSort(CurrencyTableSize currencyTableSize) {
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
            bubbleSort(arr);
            time =+ System.nanoTime()-start;
        }
        System.out.println("Bubble Sort: " + time / 1_000 * 10 + "µs");
    }

    private void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    private void fillRandomTab(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < tabSize; i++) {
            arr[i] = r.nextInt(tabSize);
        }
    }

}
