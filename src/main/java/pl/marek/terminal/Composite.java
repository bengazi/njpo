package pl.marek.terminal;

import java.util.HashSet;
import java.util.Set;

public class Composite implements Component {

    private String name;
    private Composite parent = null;

    public Composite(String name) {
        this.name = name;
    }

    public Set<Component> components = new HashSet<>();

    public void add(Component component){
        component.setParent(this);
        components.add(component);
    }

    public void printDir(){
        for(Component component : components )
            System.out.println("    " + component.getName());
    }

    @Override
    public void printPath(){
        if(parent!=null) {
            parent.printPath();
        }
        System.out.print( name + "\\" );
    }

    @Override
    public Composite getParent() {
        return parent;
    }
    @Override
    public void setParent(Composite parent){
        this.parent = parent;
    }
    @Override
    public String getName() {
        return name;
    }
}
