package priv.TzGin.demo;

import priv.TzGin.mvcframework.annotation.MyAutowired;
import priv.TzGin.mvcframework.annotation.MyController;
import priv.TzGin.mvcframework.annotation.MyRequestMapping;

@MyController
@MyRequestMapping("/demo")
public class DemoAction {

    @MyAutowired
    private IDemoService demoService;

    private IDemoService demoService2;
}
