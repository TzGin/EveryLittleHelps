package priv.TzGin.composite.general.safe;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private List<Component> components;

    public Composite(String name) {
        super(name);
        components = new ArrayList<Component>();
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder(this.name);
        for (Component component : components) {
            stringBuilder.append("\n");
            stringBuilder.append(component.operation());
        }
        return stringBuilder.toString();
    }

    public boolean addChild(Component component) {
        return components.add(component);
    }

    public boolean removeChild(Component component) {
        return components.remove(component);
    }

    public Component getChild(int index) {
        return components.get(index);
    }
}
