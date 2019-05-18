package pl.marek.sorting;

public class CurrencyTableSize extends Subject {
    private int tabSize;

    public CurrencyTableSize(int tabSize) {
        this.tabSize = tabSize;
    }

    public int getTabSize() {
        return tabSize;
    }

    public void setTabSize(int tabSize) {
        System.out.println("\n### Measurements for " + tabSize+" ###");
        this.tabSize = tabSize;
        notifyObservers();
    }
}
