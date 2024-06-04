package Day4;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        capitalCities.put("Nepal", "Kathmandu");
        capitalCities.put("India", "Delhi");
        capitalCities.put("England", "London");

        System.out.println(capitalCities);

        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

    }
}
