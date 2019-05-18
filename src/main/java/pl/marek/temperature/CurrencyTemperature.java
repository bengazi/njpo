package pl.marek.temperature;

public class CurrencyTemperature extends Subject{
    private double temperature;

    public CurrencyTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

}
