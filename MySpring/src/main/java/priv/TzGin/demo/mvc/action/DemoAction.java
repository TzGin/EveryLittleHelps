package priv.TzGin.demo.mvc.action;

import priv.TzGin.demo.service.IDemoService;
import priv.TzGin.mvcframework.annotation.MyAutowired;
import priv.TzGin.mvcframework.annotation.MyController;
import priv.TzGin.mvcframework.annotation.MyRequestMapping;
import priv.TzGin.mvcframework.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求入口类
 */
@MyController
@MyRequestMapping("/demo")
public class DemoAction {

    @MyAutowired
    private IDemoService demoService;

    private IDemoService demoService2;

    @MyRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("name") String name, @MyRequestParam("id") String id) {
//        String result = "My name is " + name + ", id = " + id;
        String result = demoService.get(name);
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("a") String a, @MyRequestParam("b") String b) {
        try {
            resp.getWriter().write(a + " + " + b + " = " + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/remove")
    public void remove(HttpServletRequest req, HttpServletResponse resp,
                    @MyRequestParam("id") Integer id) {

    }
}
