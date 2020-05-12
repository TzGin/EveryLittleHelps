package priv.TzGin.composite.general.transparent;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return name;
    }
}
