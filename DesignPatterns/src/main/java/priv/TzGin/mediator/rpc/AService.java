package priv.TzGin.mediator.rpc;

public class AService implements IService {

    Registry registry;

    public AService() {
        registry.regist("aService", this);
    }

    public void a() {
        registry.get("bService");
    }
}
