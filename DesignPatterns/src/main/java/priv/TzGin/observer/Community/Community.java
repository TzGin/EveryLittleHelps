package priv.TzGin.observer.Community;

import java.util.Observable;

public class Community extends Observable {

    private String name = "博客";
    private static final Community community = new Community();

    private Community() {

    }

    public String getName() {
        return name;
    }

    public static Community getInstance() {
        return community;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + name + "上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
