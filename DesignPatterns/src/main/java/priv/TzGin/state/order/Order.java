package priv.TzGin.state.order;

public class Order {

    private int id;
    private OrderStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "订单号=" + id +
                ", 订单状态=" + status +
                '}';
    }
}
