package pl.marek.terminal;

import java.util.ArrayList;

public class Composite implements Component {

    private String name;
    private Composite parent = null;
    protected static StringBuffer indent = new StringBuffer();

    public Composite(String name) {
        this.name = name;
    }

    public ArrayList<Component> components = new ArrayList<>();

    public void add(Component component) {
        component.setParent(this);
        components.add(component);
    }

    public void printDir() {
        indent.append("    ");
        for (Component component : components)
            System.out.println(indent + component.getName());
        indent.setLength(indent.length() - 4);
    }

    public void printPath() {
        if (parent != null) {
            parent.printPath();
        }
        System.out.print(name + "\\");
    }

    public Composite getParent() {
        return parent;
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
