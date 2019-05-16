package pl.marek.factoryhtml;

enum Options {
    EXIT(0, "Exit"),
    CREATE_TEXT(1, "Create new text"),
    SET_PARAGRAPH(2, "Add paragraph"),
    SET_STRONG(3, "Add strong"),
    SET_MARK(4, "Add mark"),
    SET_EM(5, "Add em");

    private int number;
    private String name;

    Options(int number, String name) {
        this.number = number;
        this.name = name;
    }
    @Override
    public String toString() {
        return number + ". " + name;
    }

    static Options chooseOption(int number) {
        if(number < 0 || number > values().length-1)
            throw new InvalidOptionException();
        return values()[number];
    }
}
