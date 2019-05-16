package pl.marek.html;


enum Options {
    EXIT(0, "Exit"),
    CREATE_TEXT(1, "Create new text"),
    ADD_PARAGRAPH(2, "Add paragraph"),
    ADD_STRONG(3, "Add strong"),
    ADD_MARK(4, "Add mark"),
    ADD_EM(5, "Add em"),
    DISPLAY_TEXT(6, "Display text");

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
