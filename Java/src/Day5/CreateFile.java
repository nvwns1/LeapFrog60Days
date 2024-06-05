package Day5;

import java.io.IOException;

public class File {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }
}
