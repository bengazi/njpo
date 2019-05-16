package pl.marek.factoryhtml.factory.tags;

import pl.marek.factoryhtml.factory.AbstractTag;

public class TagEm implements AbstractTag {

    @Override
    public void write(String text) {
        if(text!=null)
        System.out.printf("<em> %s </em>\n", text);
        else
            System.out.print("THE TEXT IS EMPTY!");
    }
}
