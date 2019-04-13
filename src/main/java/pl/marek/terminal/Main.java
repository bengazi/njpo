package pl.marek.terminal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //###Main catalog###
        Composite root = new Composite("~");

        createSample(root);
        printWelcomeMsg();
        mainLoop(root);
    }

    private static void mainLoop(Composite main) {
        String command, nameOfCatalog, nameOfFile;
        Scanner scanner = new Scanner(System.in);

        main.printPath();
        while (true) {
            command = scanner.nextLine();
            // ### CD ###
            if (command.toLowerCase().startsWith("cd ")) {
                if (command.length() >= 4) {
                    nameOfCatalog = command.substring(3, command.length());
                    if (!nameOfCatalog.toLowerCase().endsWith(".txt"))
                        main = (Composite) findComponent(nameOfCatalog, main);
                    else System.out.println("You can not enter a text file");
                }
            }
            // ### CD.. ###
            else if (command.toLowerCase().startsWith("cd..")) {
                if (main.getParent() != null) {
                    main = main.getParent();
                }
            }
            // ### DIR ###
            else if (command.equalsIgnoreCase("dir")) {
                main.printDir();
            }

            // ### MKDIR ###
            else if (command.toLowerCase().startsWith("mkdir ")) {

                if (command.length() >= 7) {
                    nameOfCatalog = command.substring(6, command.length());
                    if (checkIfEmptyName(nameOfCatalog))
                        createNewCatalog(main, nameOfCatalog);
                    else System.out.println("Catalog name can not be empty");
                }
            }
            // ### MKTXT ###
            else if (command.toLowerCase().startsWith("mktxt ")) {
                if (command.length() >= 7) {
                    nameOfFile = command.substring(6, command.length());
                    if (checkIfEmptyName(nameOfFile)) {
                        createNewTextFile(main, nameOfFile);
                    } else System.out.println("File name can not be empty");
                }
            }
            // ### HELP ###
            else if (command.equalsIgnoreCase("help")) {
                printHelp();
            }

            // ### EXIT ###
            else if (command.equalsIgnoreCase("exit")) System.exit(1);

                // ### ENTER ###
            else if (command.equals("")) {
                main.printPath();
                continue;
            }
            // ### NOT RECOGNIZED COMMAND ###
            else {
                System.out.println("'" + command + "' is not recognized as an internal command.");
            }
            main.printPath();
        }
    }

    private static boolean checkIfEmptyName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') return true;
        }
        return false;
    }

    private static void printHelp() {
        System.out.println("available commands:\n" +
                "cd <Catalog Name>     Changes the current directory.\n" +
                "cd..                  Returns to the previous directory\n" +
                "dir                   Displays a list of files and subdirectories in a directory.\n" +
                "exit                  Quits the program\n" +
                "help                  Provides Help information\n" +
                "mkdir <Catalog Name>  Creates a directory.\n" +
                "mktxt <File Name>     Creates a text file");
    }

    private static void createNewTextFile(Composite main, String nameOfFile) {
        if (!main.getComponents().contains(findComponent(nameOfFile, main))) {
            Leaf leaf = new Leaf(nameOfFile);
            main.getComponents().add(leaf);
        }
    }

    private static void createNewCatalog(Composite main, String nameOfCatalog) {
        if (!main.getComponents().contains(findComponent(nameOfCatalog, main))) {
            Composite composite = new Composite(nameOfCatalog);
            main.add(composite);
        } else System.out.println("A subdirectory or file already exists.");
    }

    private static Component findComponent(String nameOfCatalog, Composite main) {
        for (Component component : main.getComponents()) {
            if (component.getName().equalsIgnoreCase(nameOfCatalog))
                return component;
        }
        return main;
    }

    private static void printWelcomeMsg() {
        System.out.print("Terminal simulator [Version 1.0]\n" +
                "(c) 2019 Marek Hacieja. Wszelkie prawa zastrzeżone.\n");
    }

    private static void createSample(Composite root) {
        Composite f1 = new Composite("f1");
        Composite f2 = new Composite("f2");
        Composite f3 = new Composite("f3");
        Composite f11 = new Composite("f11");
        Composite f12 = new Composite("f12");
        Composite f13 = new Composite("f13");
        Composite f111 = new Composite("f111");
        Composite f112 = new Composite("f112");
        root.add(f1);
        root.add(f2);
        root.add(f3);
        f1.add(f11);
        f1.add(f12);
        f1.add(f13);
        f11.add(f111);
        f11.add(f112);
    }
}
