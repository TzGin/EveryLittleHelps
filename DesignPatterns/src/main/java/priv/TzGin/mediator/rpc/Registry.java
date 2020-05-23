package priv.TzGin.mediator.rpc;

//RPC   Remote Procedure Call   远程过程调用
public class Registry {

    //通过中介者缩短调用链
    //又叫服务治理
    public boolean regist(String serviceName, IService service) {
        return true;
    }

    public IService get(String serviceName) {
        return null;
    }
}
