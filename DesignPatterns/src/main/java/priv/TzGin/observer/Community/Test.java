package priv.TzGin.observer.Community;

public class Test {
    public static void main(String[] args) {
        Community community = Community.getInstance();

        Answerer teacherA = new Answerer("Mr.A");
        Answerer teacherB = new Answerer("Miss.B");

        community.addObserver(teacherA);
        community.addObserver(teacherB);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContext("观察者模式适用于哪些场景");

        community.publishQuestion(question);
    }
}
