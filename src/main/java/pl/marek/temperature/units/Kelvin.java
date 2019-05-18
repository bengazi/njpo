package pl.marek.temperature.units;

import pl.marek.temperature.CurrencyTemperature;
import pl.marek.temperature.Observer;
import pl.marek.temperature.Subject;

public class Kelvin implements Observer {
    CurrencyTemperature currencyTemperature;

    public Kelvin(CurrencyTemperature currencyTemperature) {
        this.currencyTemperature = currencyTemperature;
    }

    @Override
    public void printTemperature(Subject s) {
        double temperature = currencyTemperature.getTemperature() + 273.15;
        System.out.println(temperature + " [K]");
    }
}
