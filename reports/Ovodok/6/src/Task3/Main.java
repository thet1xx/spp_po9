package Task3;
import Task3.Commands.CreateOrderCommand;
import Task3.Commands.CancelOrderCommand;
import Task3.Commands.RepeatOrderCommand;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Order order1 = new Order();
        OrderHistory orderHistory = new OrderHistory();

        CreateOrderCommand createOrderCommand = new CreateOrderCommand(order, orderHistory);
        RepeatOrderCommand repeatOrderCommand = new RepeatOrderCommand(order, orderHistory);
        CancelOrderCommand cancelOrderCommand = new CancelOrderCommand(order);

        CreateOrderCommand createOrder1Command = new CreateOrderCommand(order1, orderHistory);
        RepeatOrderCommand repeatOrder1Command = new RepeatOrderCommand(order1, orderHistory);
        CancelOrderCommand cancelOrder1Command = new CancelOrderCommand(order1);

        Waiter waiter = new Waiter();

        waiter.setCommand(createOrderCommand);
        waiter.pressButton();

        waiter.setCommand(createOrder1Command);
        waiter.pressButton();

        waiter.setCommand(cancelOrderCommand);
        waiter.pressButton();

        waiter.setCommand(repeatOrderCommand);
        waiter.pressButton();

    }
}