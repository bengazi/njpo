package pl.marek.temperature;

import pl.marek.temperature.units.Celsius;
import pl.marek.temperature.units.Fahrenheit;
import pl.marek.temperature.units.Kelvin;
import pl.marek.temperature.units.Rankine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyTemperature currencyTemperature = new CurrencyTemperature(0);
        Celsius celsius = new Celsius(currencyTemperature);
        Fahrenheit fahrenheit = new Fahrenheit(currencyTemperature);
        Kelvin kelvin = new Kelvin(currencyTemperature);
        Rankine rankine = new Rankine(currencyTemperature);
        currencyTemperature.addObserver(celsius);
        currencyTemperature.addObserver(fahrenheit);
        currencyTemperature.addObserver(kelvin);
        currencyTemperature.addObserver(rankine);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Entry temperature in Celsius scale: ");
            double temperature = scanner.nextDouble();
            currencyTemperature.setTemperature(temperature);
        }
    }
}
