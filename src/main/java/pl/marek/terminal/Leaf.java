package pl.marek.terminal;

public class Leaf implements Component {
    private String name;
    private String content;
    private Composite parent;

    public Leaf(String name) {
        this.name = name;
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void printContent(){
        System.out.println(content);
    }

    @Override
    public void setParent(Composite parent) {
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name + ".txt";
    }


}