package pl.marek.factoryhtml.factory;

import pl.marek.factoryhtml.factory.tags.TagEm;
import pl.marek.factoryhtml.factory.tags.TagMark;
import pl.marek.factoryhtml.factory.tags.TagParagraph;
import pl.marek.factoryhtml.factory.tags.TagStrong;

public class TagFactory {
    public AbstractTag createTag(ConfigTag config) {
        String tagType = config.getDataBaseType();
        switch (tagType) {
            case "paragraph":
                return new TagParagraph();
            case "strong":
                return new TagStrong();
            case "mark":
                return new TagMark();
            case "em":
                return new TagEm();
        }
        return null;
    }

}
