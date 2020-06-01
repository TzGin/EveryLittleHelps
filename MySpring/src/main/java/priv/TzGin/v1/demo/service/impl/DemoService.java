package priv.TzGin.v1.demo.service.impl;

import priv.TzGin.v1.demo.service.IDemoService;
import priv.TzGin.v1.mvcframework.annotation.MyService;

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
