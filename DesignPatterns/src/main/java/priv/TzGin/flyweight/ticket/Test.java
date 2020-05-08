package priv.TzGin.flyweight.ticket;

public class Test {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("上海虹桥", "南京南");
        ticket.showInfo("硬座");
        ticket = TicketFactory.queryTicket("上海虹桥", "南京南");
        ticket.showInfo("软座");
        ticket = TicketFactory.queryTicket("上海虹桥", "南京");
        ticket.showInfo("硬卧");
    }
}
