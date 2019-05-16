package pl.marek.html.decorator.decorators;

import pl.marek.html.decorator.AbstractElement;
import pl.marek.html.decorator.PlainTextDecorator;

public class DecoratorParagraph extends PlainTextDecorator {

    public DecoratorParagraph(AbstractElement abstractElement) {
        super(abstractElement);
    }

    @Override
    public void write(){
        System.out.print("<p>");
        super.write();
        System.out.print("</p>");
    }
}
