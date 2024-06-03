// Creating Class
class Person {
    // Attributes
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}

public class Day3 {
    public static void main(String[] args) {
        // Creating object
        Person p1 = new Person("nvwns1", 21);
        p1.displayDetails();
        p1.setAge(22);
        p1.setName("Ram");
        p1.displayDetails();
        String personName = p1.getName();
        System.out.println(personName);
        int personAge = p1.getAge();
        System.out.println(personAge);
    }
}
