package pl.marek.terminal;

public class Leaf implements Component {
    String name;
    private Composite parent;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void setParent(Composite parent) {
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }
}
