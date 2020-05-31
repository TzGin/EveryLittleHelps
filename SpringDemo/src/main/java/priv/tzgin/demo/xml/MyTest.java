package priv.tzgin.demo.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Object object = app.getBean("person");
        System.out.println(object);
    }
}
