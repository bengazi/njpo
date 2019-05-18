package pl.marek.sorting;

import java.util.ArrayList;

public class Subject {
    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    public void deleteObservers() {
        observers.clear();
    }

    protected ArrayList<Observer> observers = new ArrayList<>();

    public void notifyObservers() {
        for (Observer o : observers) {
            o.printSortingTime(this);
        }
    }
}
