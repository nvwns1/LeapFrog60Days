package Day4;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Ford");
        System.out.println(cars);
        cars.add(2, "Tesla");
        System.out.println(cars.get(2));
        cars.set(0, "Mercedes");
        cars.remove(3);
        System.out.println(cars);
    }
}
