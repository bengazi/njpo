package pl.marek.html.decorator;

public class PlainText implements AbstractElement{
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public void write() {
        System.out.print(text);
    }
}
