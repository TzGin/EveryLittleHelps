package priv.TzGin.builder.general;

public class ConcreteBuilder implements IBuilder {

    private Product product = new Product();

    public Product build() {
        return product;
    }
}
