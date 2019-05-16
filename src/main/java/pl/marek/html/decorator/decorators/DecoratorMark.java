package pl.marek.html.decorator.decorators;

import pl.marek.html.decorator.AbstractElement;
import pl.marek.html.decorator.PlainTextDecorator;

public class DecoratorMark extends PlainTextDecorator {

    public DecoratorMark(AbstractElement abstractElement) {
        super(abstractElement);
    }

    @Override
    public void write(){
        System.out.print("<mark>");
        super.write();
        System.out.print("</mark>");
    }
}
