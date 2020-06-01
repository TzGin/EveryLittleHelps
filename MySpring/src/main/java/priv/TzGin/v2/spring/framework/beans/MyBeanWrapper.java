package priv.TzGin.v2.spring.framework.beans;

public class MyBeanWrapper {

    private Object wrapperInstance;
    private Class<?> wrappedClass;

    public MyBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrappedClass = getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public Class<?> getWrappedClass() {
        return wrappedClass;
    }
}
