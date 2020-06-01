package priv.TzGin.v2.demo.service.impl;

import priv.TzGin.v1.mvcframework.annotation.MyService;
import priv.TzGin.v2.demo.service.IDemoService;

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
