package pl.marek.html;

import pl.marek.html.decorator.AbstractElement;
import pl.marek.html.decorator.decorators.DecoratorEm;
import pl.marek.html.decorator.decorators.DecoratorMark;
import pl.marek.html.decorator.decorators.DecoratorParagraph;
import pl.marek.html.decorator.decorators.DecoratorStrong;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String text;
    static Scanner scanner = new Scanner(System.in);
    static AbstractElement abstractElement = ()-> {
        if(text!=null) System.out.print(text);
        else System.out.println("THE TEXT IS EMPTY!!!");
    };


    public static void main(String[] args) {
        Options option;
        do {
            printOptions();
            option = readOption();
            executeOption(option);
        } while (option != Options.EXIT);
    }

    static private void printOptions() {
        System.out.println("Menu:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }

    static private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while (!correctOptionSelected) {
            System.out.println("Choose an option:");

            int optionId = -1;
            optionId = getOptionId(optionId);
            scanner.nextLine();
            try {
                option = Options.chooseOption(optionId);
                correctOptionSelected = true;
            } catch (InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private static int getOptionId(int optionId) {
        try {
            optionId = scanner.nextInt();
        } catch (InputMismatchException ex) {
        }
        return optionId;
    }

    static private void executeOption(Options option) {
        switch (option) {
            case EXIT:
                closeApp();
                break;
            case CREATE_TEXT:
                System.out.println(">Entry text:");
                abstractElement = ()->System.out.print(text);
                text = scanner.nextLine();
                break;
            case ADD_PARAGRAPH:
                abstractElement = new DecoratorParagraph(abstractElement);
                break;
            case ADD_EM:
                abstractElement = new DecoratorEm(abstractElement);
                break;
            case ADD_MARK:
                abstractElement = new DecoratorMark(abstractElement);
                break;
            case ADD_STRONG:
                abstractElement = new DecoratorStrong(abstractElement);
                break;
            case DISPLAY_TEXT:
                abstractElement.write();
                scanner.nextLine();
                break;
        }
    }

    static private void closeApp() {
        System.out.print("Closing app...");
        scanner.close();
    }
}
