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
    public void operation() {

        
    }
}
