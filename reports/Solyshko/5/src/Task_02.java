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
        System.out.println(name + " has been fed. Hunger level: " + hunger);
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
        System.out.println("The dog " + name + "is playing with a toy bone");
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
        System.out.println("Cat " + name + " is playing with a toy mouse.");
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
        System.out.println("Parrot " + name + " is mimicking human speech.");
    }

    public String getColor() {
        return color;
    }
}

public class Task_02 {
    public static void main(String[] args) {
        Animal[] pets = new Animal[3];

        pets[0] = new Dog("Sharik", "Pomeranian spitz");
        pets[1] = new Cat("Barsik", "no breed");
        pets[2] = new Parrot("kesha", "Green");

        for (Animal pet : pets) {
            System.out.println("Name: " + pet.getName());
            pet.play();
            pet.feed(20);
            System.out.println("Health: " + pet.getHealth());
        }
    }
}
