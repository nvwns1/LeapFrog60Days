package Day5;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try{
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("This is new Text");
            myWriter.close();
        }catch (IOException e){
            System.out.println("An Error Occured");
        }
    }
}
