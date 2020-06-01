package priv.TzGin.v2.spring.framework.context;

import priv.TzGin.v1.mvcframework.annotation.MyAutowired;
import priv.TzGin.v1.mvcframework.annotation.MyController;
import priv.TzGin.v1.mvcframework.annotation.MyService;
import priv.TzGin.v2.spring.framework.beans.MyBeanWrapper;
import priv.TzGin.v2.spring.framework.beans.config.MyBeanDefinition;
import priv.TzGin.v2.spring.framework.beans.support.MyBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职责：完成Bean的创建和DI
 */
public class MyApplicationContext {

    private final MyBeanDefinitionReader reader;

    private final Map<String, MyBeanDefinition> beanDefinitionMap = new HashMap<String, MyBeanDefinition>();

    private final Map<String, MyBeanWrapper> factoryBeanInstanceCache = new HashMap<String, MyBeanWrapper>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<String, Object>();

    public MyApplicationContext(String... configLocations) {

        //1、加载配置文件
        reader = new MyBeanDefinitionReader(configLocations);

        try {
            //2、解析配置文件，封装成BeanDefinition
            List<MyBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();
            //3、把BeanDefinition缓存起来
            doRegistryBeanDefinition(beanDefinitions);

            doAutowired();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAutowired() {
        //调用getBean()触发
        //这一步，所有的Bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, MyBeanDefinition> beanDefinitionEntry : beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            getBean(beanName);
        }
    }

    private void doRegistryBeanDefinition(List<MyBeanDefinition> beanDefinitions) throws Exception {
        for (MyBeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);
        }
    }

    /**
     * Bean的实例化，DI是从这个方法开始的
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        //1、先拿到BeanDefinition配置信息
        MyBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        //2、反射实例化
        Object instance = instantiateBean(beanName, beanDefinition);
        //3、封装成BeanWrapper
        MyBeanWrapper beanWrapper = new MyBeanWrapper(instance);
        //保存到IoC容器
        factoryBeanInstanceCache.put(beanName, beanWrapper);
        //执行依赖注入
        populateBean(beanName, beanDefinition, beanWrapper);

        return beanWrapper.getWrapperInstance();
    }

    private void populateBean(String beanName, MyBeanDefinition beanDefinition, MyBeanWrapper beanWrapper) {
        //可能涉及到循环依赖
        //A{B b}
        //B{A a}
        //用两个缓存，循环两次
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值
        Object instance = beanWrapper.getWrapperInstance();

        Class<?> clazz = beanWrapper.getWrappedClass();

        //在Spring中是@Component
        if (!clazz.isAnnotationPresent(MyController.class) || clazz.isAnnotationPresent(MyService.class)) {
            return;
        }

        //拿到实例的所有的字段
        //Declared 所有的，包括private/protected/default/public 修饰的字段都取出来
        //正常来说，只能拿到public修饰的
        for (Field field : clazz.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(MyAutowired.class)) {
                return;
            }

            MyAutowired autowired = field.getAnnotation(MyAutowired.class);
            //如果用户没有自定义beanName，默认就根据类型注入
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                autowiredBeanName = field.getType().getName();
            }

            //如果是public以外的修饰符，只要加了@Autowired注解，都要强制赋值
            //暴力访问
            field.setAccessible(true);

            try {
                if (factoryBeanInstanceCache.get(autowiredBeanName) == null) {
                    continue;
                }
                //ioc.get(beanName) 相当于通过接口的全名拿到接口的实现的实例
                field.set(instance, factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
        }
    }


    /**
     * 创建真正的实例对象
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object instantiateBean(String beanName, MyBeanDefinition beanDefinition) {

        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            Class<?> clazz = Class.forName(className);
            instance = clazz.newInstance();
            factoryBeanObjectCache.put(beanName, instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Object getBean(Class<?> beanClass) {
        return getBean(beanClass.getName());
    }
}
