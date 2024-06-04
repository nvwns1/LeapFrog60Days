package Day4;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Volvo");
        cars.add("BMW");
        System.out.println(cars);
        System.out.println(cars.contains("Volvo"));
    }
}
