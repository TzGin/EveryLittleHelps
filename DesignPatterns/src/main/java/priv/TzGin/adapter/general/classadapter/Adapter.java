package priv.TzGin.adapter.general.classadapter;

public class Adapter extends Adaptee implements Target{

    @Override
    public int request() {
        return super.specificRequest() / 10;
    }
}
