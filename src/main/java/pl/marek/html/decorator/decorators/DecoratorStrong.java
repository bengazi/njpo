package pl.marek.html.decorator.decorators;

import pl.marek.html.decorator.AbstractElement;
import pl.marek.html.decorator.PlainTextDecorator;

public class DecoratorStrong extends PlainTextDecorator {

    public DecoratorStrong(AbstractElement abstractElement) {
        super(abstractElement);
    }

    @Override
    public void write(){
        System.out.print("<strong>");
        super.write();
        System.out.print("</strong>");
    }
}
