package pl.marek.terminal;

public interface Component {
    void printPath();

    String getName();
    Composite getParent();
    void setParent(Composite parent);
}