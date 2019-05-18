package pl.marek.temperature.units;

import pl.marek.temperature.CurrencyTemperature;
import pl.marek.temperature.Observer;
import pl.marek.temperature.Subject;

public class Fahrenheit implements Observer {
    CurrencyTemperature currencyTemperature;

    public Fahrenheit(CurrencyTemperature currencyTemperature) {
        this.currencyTemperature = currencyTemperature;
    }

    @Override
    public void printTemperature(Subject s) {
        double temperature = currencyTemperature.getTemperature() * 1.8 + 32;
        System.out.println(temperature + " [°F]");
    }
}
