package pl.marek.factoryhtml.factory.tags;

import pl.marek.factoryhtml.factory.AbstractTag;

public class TagMark implements AbstractTag {

    @Override
    public void write(String text) {
        if(text!=null)
            System.out.printf("<mark> %s </mark>\n", text);
        else
            System.out.print("THE TEXT IS EMPTY!");
    }
}