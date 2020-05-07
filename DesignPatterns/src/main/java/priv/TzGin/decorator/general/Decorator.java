package priv.TzGin.decorator.general;

public abstract class Decorator extends Component{

    /**
     * 持有组件对象
     */
    private Component component;

    /**
     * 构造方法，传入组件对象
     * @param component 组件对象
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
