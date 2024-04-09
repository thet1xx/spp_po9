package Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;

public class Order {
    private int id;
    private List<Pizza> pizzaList = new ArrayList<>();
    private boolean isCancelled;

    public void createOrder() throws IOException {
        System.out.println("Формирование заказа");
        setId();
        addPizza();
        isCancelled = false;
    }

    public void cancelOrder() {
        isCancelled = true;
        System.out.println("Отмена заказа номер " + getId());
    }

    public void repeatOrder() {

        System.out.println("Повторный заказ");
    }

    public void addPizza() throws IOException {
        System.out.println("Сколько пицц хотите?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        for (int i = 0; i < number; i++){
            String pizzaName = reader.readLine();
            pizzaList.add(new Pizza(pizzaName));
        }
    }

    public void printOrder(){
        System.out.println("ID - " + this.id);
        System.out.println("Pizza list:");
        for (Pizza pizza : pizzaList){
            System.out.println(pizza.getName());
        }
        if (isCancelled){
            System.out.println("is cancelled");
        }
    }

    public int getId() {
        return id;
    }

    public void setId() throws IOException {
        System.out.println("Id -");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.id = Integer.parseInt(reader.readLine());
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
