package priv.TzGin.proxy.staticproxy;

import priv.TzGin.proxy.IPerson;

public class ZhangLaosan implements IPerson {

    private Zhangsan zhangsan;

    public ZhangLaosan(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    public void findLove() {
        System.out.println("张老三开始物色");
        zhangsan.findLove();
        System.out.println("张三开始谈恋爱");
    }
}
