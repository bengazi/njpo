package pl.marek.terminal;

import java.util.Scanner;

public class Main {
    //###Main catalog###
    static private Composite root = new Composite("~");

    public static void main(String[] args) {
        createSample();
        printWelcomeMsg();
        mainLoop();
    }

    private static void mainLoop() {
        Scanner scanner = new Scanner(System.in);

        root.printPath();
        while (true) {
            String command = scanner.nextLine();
            // ### CD ###
            if (command.toLowerCase().startsWith("cd ")) {
                if (command.length() >= 4) {
                    String nameOfCatalog = command.substring(3, command.length());
                    if (!nameOfCatalog.toLowerCase().endsWith(".txt"))
                        root = (Composite) findComponent(nameOfCatalog);
                    else System.out.println("You can not enter a text file");
                }
            }
            // ### CD.. ###
            else if (command.toLowerCase().startsWith("cd..")) {
                if (root.getParent() != null) {
                    root = root.getParent();
                }
            }
            // ### DIR ###
            else if (command.equalsIgnoreCase("dir")) {
                root.printDir();
            }

            // ### MKDIR ###
            else if (command.toLowerCase().startsWith("mkdir ")) {

                if (command.length() >= 7) {
                    String nameOfCatalog = command.substring(6, command.length());
                    if (checkIfEmptyName(nameOfCatalog))
                        createNewCatalog(nameOfCatalog);
                    else System.out.println("Catalog name can not be empty");
                }
            }
            // ### MKTXT ###
            else if (command.toLowerCase().startsWith("mktxt ")) {
                if (command.length() >= 7) {
                    String nameOfFile = command.substring(6, command.length());
                    if (checkIfEmptyName(nameOfFile)) {
                        createNewTextFile(nameOfFile);
                    } else System.out.println("File name can not be empty");
                }
            }
            // ### OPEN ###
            else if(command.toLowerCase().startsWith("open ")){
                if(command.length() >= 6){
                    String nameOfFile = command.substring(5, command.length());
                    if (checkIfEmptyName(nameOfFile)) {
                       if (findComponent(nameOfFile) instanceof Leaf){
                           Leaf leaf =(Leaf) findComponent(nameOfFile);
                           leaf.printContent();
                       }
                    }
                }
            }
            // ### TXTEDIT ###
            else if(command.toLowerCase().startsWith("txtedit ")){
                if(command.length() >= 9){
                    String nameOfFile = command.substring(8, command.length());
                    if(checkIfEmptyName(nameOfFile)){
                        if (findComponent(nameOfFile) instanceof Leaf){
                            System.out.println("Enter the new content:");
                            String content = scanner.nextLine();
                            ((Leaf) findComponent(nameOfFile)).setContent(content);
                        }
                    }
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
                root.printPath();
                continue;
            }
            // ### NOT RECOGNIZED COMMAND ###
            else {
                System.out.println("'" + command + "' is not recognized as an internal command.");
            }
            root.printPath();
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
                "mktxt <File Name>     Creates a text file.\n" +
                "open <File Name>      Displays the file's content.\n" +
                "txtedit <File Name>   Sets the file's content.");
    }

    private static void createNewTextFile(String nameOfFile) {
        if (!root.getComponents().contains(findComponent(nameOfFile))) {
            Leaf leaf = new Leaf(nameOfFile);
            root.getComponents().add(leaf);
        } else System.out.println("Text file already exists.");
    }

    private static void createNewCatalog(String nameOfCatalog) {
        if (!root.getComponents().contains(findComponent(nameOfCatalog))) {
            Composite composite = new Composite(nameOfCatalog);
            root.add(composite);
        } else System.out.println("A subdirectory already exists.");
    }

    private static Component findComponent(String nameOfCatalog) {
        for (Component component : root.getComponents()) {
            if (component.getName().equalsIgnoreCase(nameOfCatalog))
                return component;
        }
        return root;
    }


    private static void printWelcomeMsg() {
        System.out.print("Terminal simulator [Version 1.0]\n" +
                "(c) 2019 Marek Hacieja. Wszelkie prawa zastrzeżone.\n");
    }

    private static void createSample() {
        Composite f1 = new Composite("folder1");
        Composite f2 = new Composite("folder12");
        Composite f3 = new Composite("folder13");
        Composite f11 = new Composite("folder111");
        Composite f12 = new Composite("folder112");
        Composite f13 = new Composite("folder113");
        Composite f111 = new Composite("folder1111");
        Composite f112 = new Composite("folder1112");
        Leaf l1 = new Leaf("text");
        root.add(f1);
        root.add(f2);
        root.add(f3);
        root.add(l1);
        f1.add(f11);
        f1.add(f12);
        f1.add(f13);
        f11.add(f111);
        f11.add(f112);
    }
}
