package priv.TzGin.mediator.rpc;

public class BService implements IService {

    Registry registry;

    public BService() {
        registry.regist("bService", this);
    }
}
