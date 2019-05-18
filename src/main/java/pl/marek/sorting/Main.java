package pl.marek.sorting;

import pl.marek.sorting.algorithms.BubbleSort;
import pl.marek.sorting.algorithms.JavaLib;
import pl.marek.sorting.algorithms.QuickSort;
import pl.marek.sorting.algorithms.SelectSort;

public class Main {
    public static void main(String[] args) {
        CurrencyTableSize table = new CurrencyTableSize(0);
        BubbleSort bubbleSort = new BubbleSort(table);
        QuickSort quickSort = new QuickSort(table);
        SelectSort selectSort = new SelectSort(table);
        JavaLib javaLib = new JavaLib(table);
        table.addObserver(bubbleSort);
        table.addObserver(quickSort);
        table.addObserver(selectSort);
         table.addObserver(javaLib);

        table.setTabSize(100);
        table.setTabSize(1000);
        table.setTabSize(10000);
    }
}
