package org.example;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Product> products;

    public Payment() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    public double getTotalAmount(){
        double totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
        return  totalAmount;
    }

    public void showBill() {
        System.out.println("Products in the payment:");
        for (Product product : products) {
            System.out.println(product.getName() + "\t" + product.getPrice());
        }
    }

    public class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

    }
}
