package Task1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private float budget;
    private List<Product> inventory;

    public Customer(String name, float budget) {
        this.name = name;
        this.budget = budget;
        inventory = new ArrayList<>(List.of());
    }

    public String getName() {
        return name;
    }

    public float getBudget() {
        return budget;
    }

    public void buyProduct(Product product) {
        if (isProductObtainable(product)){
            budget -= product.getPrice();
            inventory.add(new Product(product));
        }
    }

    public boolean isProductObtainable(Product product) {
        return budget >= product.getPrice();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", inventory=" + inventory +
                '}';
    }
}