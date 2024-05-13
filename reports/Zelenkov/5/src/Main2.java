interface Pet {
    void setName(String name);
    String getName();
    void play();
    void feed(int foodAmount);
    void setHealth(int health);
    int getHealth();
}

abstract class Animal implements Pet {
    protected String name;
    protected int hunger;
    protected int health;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void feed(int foodAmount) {
        hunger -= foodAmount;
        if (hunger < 0) {
            hunger = 0;
        }
        System.out.println(name + " был накормлен. Уровень голода: " + hunger);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public abstract void play();
}

class Dog extends Animal {
    private final String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.hunger = 50;
        this.health = 100;
    }

    @Override
    public void play() {
        System.out.println("Собака " + name + " играет с игрушечным котом.");
    }

    public String getBreed() {
        return breed;
    }
}

class Cat extends Animal {
    private final String breed;
    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.hunger = 40;
        this.health = 90;
    }

    @Override
    public void play() {
        System.out.println("Кот " + name + " играет с игрушечной мышью.");
    }

    public String getBreed() {
        return breed;
    }
}

class Parrot extends Animal {
    private final String color;

    public Parrot(String name, String color) {
        this.name = name;
        this.color = color;
        this.hunger = 60;
        this.health = 95;
    }

    @Override
    public void play() {
        System.out.println("Попугай " + name + " играет, разговаривая человеческим голосом.");
    }

    public String getColor() {
        return color;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Animal[] pets = new Animal[3];

        pets[0] = new Dog("Чарли", "Кокер-спаниель");
        pets[1] = new Cat("Оскар", "Британец");
        pets[2] = new Parrot("Кеша", "Желто-зеленый");

        for (Animal pet : pets) {
            System.out.println("Имя: " + pet.getName());
            pet.play();
            pet.feed(20);
            System.out.println("Здоровье: " + pet.getHealth());
        }
    }
}
