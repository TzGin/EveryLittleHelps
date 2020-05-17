package priv.TzGin.template.general;

public abstract class AbstractClass {

    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    protected void step3() {
        System.out.println("AbstractClass:step3");
    }

    protected void step2() {
        System.out.println("AbstractClass:step2");
    }

    protected void step1() {
        System.out.println("AbstractClass:step1");
    }


}
