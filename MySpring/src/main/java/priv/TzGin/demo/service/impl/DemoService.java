package priv.TzGin.demo.service.impl;

import priv.TzGin.demo.service.IDemoService;
import priv.TzGin.mvcframework.annotation.MyService;

/**
 * 核心业务逻辑
 * 业务实现类
 */
@MyService
public class DemoService implements IDemoService {

    public String get(String name) {
        return "My name is " + name;
    }
}
