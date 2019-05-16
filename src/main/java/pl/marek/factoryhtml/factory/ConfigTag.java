package pl.marek.factoryhtml.factory;

public class ConfigTag {
    private String tag;

    public ConfigTag(String tag) {
        this.tag = tag;
    }

    public String getDataBaseType() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
