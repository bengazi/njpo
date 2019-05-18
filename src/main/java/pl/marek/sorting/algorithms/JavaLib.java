package pl.marek.sorting.algorithms;

import pl.marek.sorting.CurrencyTableSize;
import pl.marek.sorting.Observer;
import pl.marek.sorting.Subject;

import java.util.Arrays;
import java.util.Random;

public class JavaLib implements Observer {
    CurrencyTableSize currencyTableSize;
    int tabSize;
    long time;

    public JavaLib(CurrencyTableSize currencyTableSize) {
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
            Arrays.sort(arr);
            time =+ System.nanoTime()-start;
        }
        System.out.println("JavaLib Sort: " + time / 1_000 * 10 + "µs");
    }

    private void fillRandomTab(int arr[]) {
        Random r = new Random();
        for (int i = 0; i < tabSize; i++) {
            arr[i] = r.nextInt(tabSize);
        }
    }
}
