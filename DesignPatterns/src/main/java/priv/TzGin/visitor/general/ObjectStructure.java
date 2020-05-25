package priv.TzGin.visitor.general;

import java.util.ArrayList;
import java.util.List;

//结构对象
public class ObjectStructure {

    private List<IElement> list = new ArrayList<IElement>();

    {
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());
    }

    public void accept(IVisitor visitor) {
        for (IElement element : list) {
            element.accept(visitor);
        }
    }
}
