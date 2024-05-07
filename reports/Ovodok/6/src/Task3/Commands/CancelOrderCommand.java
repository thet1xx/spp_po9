package Task3.Commands;

import Task3.Command;
import Task3.Order;

import java.util.List;

// Конкретная команда для отмены заказа
public class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    public void execute() {
        order.cancelOrder();
    }
}
