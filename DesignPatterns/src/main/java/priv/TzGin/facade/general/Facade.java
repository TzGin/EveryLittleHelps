package priv.TzGin.facade.general;

public class Facade {

    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    public void doA(){
        a.doA();
    }

    public void doB(){
        b.doB();
    }

    public void doC(){
        c.doC();
    }
}
