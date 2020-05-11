package priv.TzGin.composite.general.transparent;

public class Composite extends Component {
    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {

    }

    @Override
    public boolean addChild(Component component) {
        return super.addChild(component);
    }

    @Override
    public boolean removeChild(Component component) {
        return super.removeChild(component);
    }

    @Override
    public Component getChild(int index) {
        return super.getChild(index);
    }
}
