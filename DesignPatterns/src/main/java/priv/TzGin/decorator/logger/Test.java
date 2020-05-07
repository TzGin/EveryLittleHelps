package priv.TzGin.decorator.logger;

import org.slf4j.Logger;

public class Test {

    private static final Logger logger = JsonLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.error("系统错误"); 
    }
}
