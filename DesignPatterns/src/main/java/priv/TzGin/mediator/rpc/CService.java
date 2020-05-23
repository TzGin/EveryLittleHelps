package priv.TzGin.mediator.rpc;

public class CService implements IService {

    Registry registry;

    public CService() {
        registry.regist("cService", this);
    }
}
