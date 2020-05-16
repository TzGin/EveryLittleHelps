package priv.TzGin.delegate.simple;

public class Test {
    public static void main(String[] args) {
        new Boss().command("海报", new Leader());
        new Boss().command("爬虫", new Leader());
        new Boss().command("招聘", new Leader());
    }
}
