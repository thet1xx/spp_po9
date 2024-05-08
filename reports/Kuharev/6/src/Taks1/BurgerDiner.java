import Burger.*;
import Drink.*;
import Pack.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurgerDiner {
    static public class BurgerDinerBuilder {
        private Pack pack;
        private List<Burger> burgers;
        private List<Drink> drinks;

        public BurgerDinerBuilder() {
            burgers = new ArrayList<>();
            drinks = new ArrayList<>();
        }

        public BurgerDinerBuilder setPack(Pack pack) {
            this.pack = pack;
            return this;
        }

        public BurgerDinerBuilder addBurger(Burger burger) {
            burgers.add(burger);
            return this;
        }

        public BurgerDinerBuilder addDrink(Drink drink) {
            drinks.add(drink);
            return this;
        }

        public BurgerDiner build() {
            return new BurgerDiner(pack, burgers, drinks);
        }
    }
    static int order_number = 0;

    Pack pack;
    List<Burger> burgers;
    List<Drink> drinks;
    public BurgerDiner(Pack pack, List<Burger> burgers, List<Drink> drinks) {
        this.pack = pack;
        this.burgers = burgers;
        this.drinks = drinks;
    }
    void getOrder(){
        ++order_number;
        System.out.println("Your order №00" + order_number + ":");
        System.out.println("\nTotal price: $" + ((double)showBurgers() + (double) showDrinks() + (double)pack.choosePackage()));
    }
    public double showBurgers(){
        double totalPrice = 0;
        System.out.println("Burgers: ");
        for(Burger burger : burgers){
            //burger.showInfo();
            totalPrice += burger.buy();
        }
        System.out.println();
        return totalPrice;
    }

    public double showDrinks(){
        double totalPrice = 0;
        System.out.println("Drinks: ");
        for(Drink drink : drinks){
            //drink.showInfo();
            totalPrice += drink.selectDrink();
        }
        System.out.println();
        return totalPrice;
    }
    public static Burger[] fillBurgerList(){
        ChickenBurger chickenBurger = new ChickenBurger();
        CheeseBurger cheeseBurger = new CheeseBurger();
        HamBurger hamBurger = new HamBurger();
        VeganBurger veganBurger = new VeganBurger();

        List<Burger> add = Arrays.asList(chickenBurger, cheeseBurger, hamBurger, veganBurger);
        return add.toArray(new Burger[0]);
    }
    public static Drink[] fillColdDrinkList(){
        Pepsi pepsi = new Pepsi();
        CocaCola cocaCola = new CocaCola();
        DrPepper drPepper = new DrPepper();
        Sprite sprite = new Sprite();

        List<Drink> add = Arrays.asList(pepsi, cocaCola, drPepper, sprite);
        return add.toArray(new Drink[0]);
    }
    public static Drink[] fillHotDrinkList(){
        Tea tea = new Tea();
        GreenTea greenTea = new GreenTea();
        Coffee coffee = new Coffee();
        Chocolate chocolate = new Chocolate();

        List<Drink> add = Arrays.asList(tea, greenTea, coffee, chocolate);
        return add.toArray(new Drink[0]);
    }
}
