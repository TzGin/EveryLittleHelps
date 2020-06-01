package priv.TzGin.v2.spring.framework.beans.support;

import priv.TzGin.v1.mvcframework.annotation.MyService;
import priv.TzGin.v2.spring.framework.beans.config.MyBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyBeanDefinitionReader {

    private Properties contextConfig = new Properties();

    //保存扫描的结果
    private List<String> registryBeanClasses = new ArrayList<String>();

    public MyBeanDefinitionReader(String... configLocations) {
        doLoadConfig(configLocations[0]);

        //扫描配置文件中配置的相关类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public List<MyBeanDefinition> loadBeanDefinitions() {
        List<MyBeanDefinition> result = new ArrayList<MyBeanDefinition>();

        try {
            for (String className : registryBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                //保存类对应的ClassName(全类名)
                //还有beanName
                //1、默认是类名首字母小写
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));
                //2、自定义
                MyService service = beanClass.getAnnotation(MyService.class);
                if (!"".equals(service.value())) {
                    result.add(doCreateBeanDefinition(service.value(), beanClass.getName()));
                }
                //3、接口注入
                for (Class<?> i : beanClass.getInterfaces()) {
                    result.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private MyBeanDefinition doCreateBeanDefinition(String beanName, String beanClassName) {
        MyBeanDefinition beanDefinition = new MyBeanDefinition();
        beanDefinition.setFactoryBeanName(beanName);
        beanDefinition.setBeanClassName(beanClassName);
        return null;
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation.replaceAll("classpath:", ""));
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //扫描出相关的类
    private void doScanner(String scanPackage) {
        //jar、war、zip、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));

        //scanPackage = priv.TzGin.v1.demo 存储的是包路径
        //转换为文件路径，把.替换为/
        //classpath下不仅有.class文件，还有.xml文件，.properties文件
        File classPath = new File(url.getFile());
        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                //如果是文件夹调用自身迭代
                doScanner(scanPackage + "." + file.getName());
            } else {
                //变成包名.类名
                //为Class.forName(className);做准备
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = scanPackage + "." + file.getName().replace(".class", "");
                registryBeanClasses.add(className);
            }
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        //大小写字母的ASCII码相差32
        //大写字母的ASCII码要小于小写字母的ASCII码
        //在java中，对char做算术运算实际上就是对ASCII码做算术运算
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
