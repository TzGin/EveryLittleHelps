package priv.TzGin.observer.Community;

import java.util.Observable;
import java.util.Observer;

public class Answerer implements Observer {

    private String name;

    public Answerer(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Community community = (Community) o;
        Question question = (Question) arg;
        System.out.println("===================");
        System.out.println(name + "，您好！您收到了一个来自社区的" + community.getName() + "的提问，希望您解答。问题内容如下:\n" +
                question.getContext() + "\n" +
                "提问者：" + question.getUserName());
    }
}
