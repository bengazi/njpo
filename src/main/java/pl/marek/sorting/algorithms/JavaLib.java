package pl.marek.sorting.algorithms;

import pl.marek.sorting.CurrencyTableSize;
import pl.marek.sorting.Observer;
import pl.marek.sorting.Subject;

public class GuavaSort implements Observer {
    CurrencyTableSize currencyTableSize;

    public GuavaSort(CurrencyTableSize currencyTableSize) {
        this.currencyTableSize = currencyTableSize;
        Arrays.sort(array);
    }

    @Override
    public void printSortingTime(Subject s) {
        System.out.println("Guova sort tab: " + currencyTableSize.getTabSize());
    }

    
}
