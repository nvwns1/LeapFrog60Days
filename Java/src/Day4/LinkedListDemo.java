package Day4;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("BMW");
        cars.add("BMW");
        cars.add("Mercedes");

        System.out.println(cars);
        System.out.println(cars.getFirst());
    }
}
