package Task3.Commands;

import Task3.Command;
import Task3.Order;
import Task3.OrderHistory;

import java.io.IOException;
import java.util.List;

// Конкретная команда для добавления позиции в заказ
public class CreateOrderCommand implements Command {
    private Order order;
    private OrderHistory orderHistory;

    public CreateOrderCommand(Order order, OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
        this.order = order;
    }

    public void execute() {
        try {
            order.createOrder();
            orderHistory.addOrder(order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
