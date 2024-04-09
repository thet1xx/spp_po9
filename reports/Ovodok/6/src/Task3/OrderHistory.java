package Task3;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printHistory(){
        for (Order order : orders){
            order.printOrder();
        }
    }
    public Order getOrderByID(int ID){
        for (Order order: orders){
            if(order.getId() == ID){
                return order;
            }
        }
        System.out.println("Нет ID " + ID);
        return null;
    }
}