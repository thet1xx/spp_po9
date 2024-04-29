package Task3.Commands;

import Task3.Command;
import Task3.Order;
import Task3.OrderHistory;


public class RepeatOrderCommand implements Command {
    private Order order;
    private OrderHistory orderHistory;
    public RepeatOrderCommand(Order order, OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
        this.order = order;
    }

    public void execute() {
        order.repeatOrder();
        orderHistory.getOrderByID(order.getId()).printOrder();
    }
}
