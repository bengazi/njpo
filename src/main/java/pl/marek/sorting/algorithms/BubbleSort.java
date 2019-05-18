package pl.marek.sorting;

public class BubbleSort implements Observer{

    private CurrencyTableSize currencyTableSize = null;

    public BubbleSort(CurrencyTableSize currencyTableSize) {
        this.currencyTableSize = currencyTableSize;
    }

    @Override
    public void update(Subject s) {
        System.out.println("bubble sort tab: " + currencyTableSize.getTabSize());
    }

    @Override
    public void printResult() {

    }
}
