package priv.TzGin.iterator.general;

public class Test {
    public static void main(String[] args) {
        //创建一个容器
        IAggregate<String> aggregate = new ConcreteAggregate<String>();
        //往容器添加元素
        aggregate.add("one");
        aggregate.add("two");
        aggregate.add("three");
        //获取容器对象迭代器
        Iterator<String> iterator = aggregate.iterator();
        //遍历
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
