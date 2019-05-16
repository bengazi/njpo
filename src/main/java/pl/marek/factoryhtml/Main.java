package pl.marek.factoryhtml;

import pl.marek.factoryhtml.factory.AbstractTag;
import pl.marek.factoryhtml.factory.ConfigTag;
import pl.marek.factoryhtml.factory.TagFactory;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String text;
    static Scanner scanner = new Scanner(System.in);
    //tmp
    static ConfigTag configTag = new ConfigTag("");

    static TagFactory tagFactory = new TagFactory();
    static AbstractTag abstractTag = (t) -> {};

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
            System.out.println("Choose an option: ");

            int optionId = -2;
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
                //abstractTag = (text) -> System.out.print(text);
                text = scanner.nextLine();
                break;
            case SET_PARAGRAPH:
                configTag.setTag("paragraph");
                createTag();
                break;
            case SET_EM:
                configTag.setTag("em");
                createTag();
                break;
            case SET_MARK:
                configTag.setTag("mark");
                createTag();
                break;
            case SET_STRONG:
                configTag.setTag("strong");
                createTag();
                break;
        }
    }

    private static void createTag() {
        abstractTag = tagFactory.createTag(configTag);
        abstractTag.write(text);
        scanner.nextLine();
    }

    static private void closeApp() {
        System.out.print("Closing app...");
        scanner.close();
    }
}
