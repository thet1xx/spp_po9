import Burger.*;
import Drink.*;
import Pack.*;

import java.util.Scanner;

public class Main {
    public static Burger[] burgers;
    public static Drink[] coldDrinks;
    public static Drink[] hotDrinks;
    public static BurgerDiner.BurgerDinerBuilder builder;
    public static BurgerDiner order;
    public static void main(String[] args) {
        burgers = BurgerDiner.fillBurgerList();
        coldDrinks = BurgerDiner.fillColdDrinkList();
        hotDrinks = BurgerDiner.fillHotDrinkList();

        formOrder();
    }
    public static void formOrder(){
        System.out.print("Choose package type:\n   (1) - To go\n   (2) - On Site\n: ");
        Scanner read = new Scanner(System.in);
        builder = new BurgerDiner.BurgerDinerBuilder();
        Pack pack;

        switch (read.nextInt()){
            case 1:
                pack = new ToGo();
                builder.setPack(pack);
                break;
            case 2:
                pack = new OnSite();
                builder.setPack(pack);
                break;
            default:
                System.out.println("No such option, do you want to try again? (Y/n): ");
                makeAgain();
                break;
        }
        while (addPositions()){
        }
        order = builder.build();
        order.getOrder();

        makeAgain();
    }
    public static boolean addPositions(){
        Scanner read = new Scanner(System.in);
        System.out.print("Choose option:\n   (1) - Add burger\n   (2) - Add drink\n   (0) - End forming\n: ");
        switch (read.nextInt()){
            case 0:
                return false;
            case 1:
                addBurger();
                return true;
            case 2:
                addDrink();
                return true;
            default:
                System.out.println("No such option!");
                return true;
        }
    }
    public static void addBurger(){
        String action;
        Scanner read = new Scanner(System.in);
        showBurgerList();
        System.out.print("Select burger number: ");
        action = read.next();

        int action_num = 0;
        try{
            action_num = Integer.parseInt(action)-1;
        }catch(Exception ex){
            System.out.println("Please enter correct number");
            addBurger();
        }
        if(action_num >= burgers.length){
            System.out.println("There's no " + action + "th burger");
            addBurger();
        }else{
            builder.addBurger(burgers[action_num]);
        }
    }
    public static void addDrink(){
        Drink[] drinks;
        Scanner read = new Scanner(System.in);
        int action_num = 0;
        String action;
        System.out.println("Do you want to order hot drink? (N/y)");
        action = read.next();
        if(action.toLowerCase().equals("y")){
            drinks = hotDrinks;
            showHotDrinkList();
        }else{
            drinks = coldDrinks;
            showColdDrinkList();
        }

        System.out.print("Select drink number: ");
        action = read.next();
        try{
            action_num = Integer.parseInt(action)-1;
        }catch(Exception ex){
            System.out.println("Please enter correct number");
            addDrink();
        }
        if(action_num >= drinks.length){
            System.out.println("There's no " + action + "th drink");
            addDrink();
        }else{
            builder.addDrink(drinks[action_num]);
        }
    }
    public static void makeAgain(){
        Scanner read = new Scanner(System.in);
        if(read.nextLine().toLowerCase().equals("y")){
            formOrder();
        }else {
            System.exit(0);
        }
    }

    public static void showBurgerList(){
        System.out.println("Burgers list:");
        for(int i = 0; i < burgers.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            burgers[i].showInfo();
        }
        System.out.println();
    }
    public static void showColdDrinkList(){
        System.out.println("Cold drinks list:");
        for(int i = 0; i < coldDrinks.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            coldDrinks[i].showInfo();
        }
        System.out.println();
    }
    public static void showHotDrinkList(){
        System.out.println("Hot drinks list:");
        for(int i = 0; i < hotDrinks.length; ++i){
            System.out.print("  " + (i+1) + ". ");
            hotDrinks[i].showInfo();
        }
        System.out.println();
    }
}