package Day3OOPSConcept;
// Abstraction

// hiding the complex implementation details of a system
// exposing essential features only

abstract class Animal {
    // Abstract methods (no implementation)
    public abstract void makeSound();

    public abstract void eat();

    // Non-abstract method
    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Eating...");
    }
}

public class Day3Abstraction {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
        myDog.eat();
        myDog.sleep();
    }
}
