package pl.marek.html.decorator;

public class PlainTextDecorator implements AbstractElement{

    private AbstractElement abstractElement;
    public PlainTextDecorator(AbstractElement abstractElement) {
        this.abstractElement = abstractElement;
    }

    @Override
    public void write() {
        abstractElement.write();
    }
}
