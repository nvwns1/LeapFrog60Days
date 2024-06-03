package Day3OOPSConcept;
// Encapsulation
// It is the mechanism of restricting access to some of an object's
// components and protecting the object's internal state
// from unauthorized modification.
// It is achieved using access modifiers, getters and setters


class Person {
    // Private is Access Modifiers
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        if (age > 0) { // Validate age to ensure it is a positive number
            this.age = age;
        } else {
            System.out.println("Please enter a valid age.");
        }
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Day3Encapsulation {
    public static void main(String[] args) {
        Person person = new Person("John Smith", 30);
        person.displayDetails();

        // Attempt to set an invalid age
        person.setAge(-5);
    }
}
