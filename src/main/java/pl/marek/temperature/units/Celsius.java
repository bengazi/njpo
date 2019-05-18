package pl.marek.temperature.units;


import pl.marek.temperature.CurrencyTemperature;
import pl.marek.temperature.Observer;
import pl.marek.temperature.Subject;

public class Celsius implements Observer {
    CurrencyTemperature currencyTemperature;

    public Celsius(CurrencyTemperature currencyTemperature) {
        this.currencyTemperature = currencyTemperature;
    }

    @Override
    public void printTemperature(Subject s) {
        System.out.println( currencyTemperature.getTemperature() + " [°C]");
    }
}
