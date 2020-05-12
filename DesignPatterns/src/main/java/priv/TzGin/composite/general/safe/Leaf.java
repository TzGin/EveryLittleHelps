package priv.TzGin.composite.general.safe;

public class Leaf extends Component{

    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return this.name;
    }
}
