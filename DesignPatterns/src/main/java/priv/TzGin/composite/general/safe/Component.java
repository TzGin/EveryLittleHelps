package priv.TzGin.composite.general.safe;

//抽象根节点
public abstract class Component {

    private String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();

    public boolean addChild(Component component) {
        throw new UnsupportedOperationException("addChild not supported");
    }

    public boolean removeChild(Component component) {
        throw new UnsupportedOperationException("removeChild not supported");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("getChild not supported");
    }
}