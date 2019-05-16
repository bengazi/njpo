package pl.marek.html.decorator.decorators;

import pl.marek.html.decorator.AbstractElement;
import pl.marek.html.decorator.PlainTextDecorator;

public class DecoratorEm extends PlainTextDecorator {

    public DecoratorEm(AbstractElement abstractElement) {
        super(abstractElement);
    }

    @Override
    public void write(){
        System.out.print("<em>");
        super.write();
        System.out.print("</em>");
    }
}
