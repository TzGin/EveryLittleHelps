package priv.TzGin.memento.general;

public class Caretaker {

    //备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void storeMemento(Memento memento) {
        this.memento = memento;
    }
}
