public class Day1 {
    // Single line comment
    /*
     * Multi Line Comment in Java
     * */
    //main method
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        //

        // Primitive Data Type
        boolean dataTypeBool = true; // 1 bit
        char dataTypeChar = 'a'; // 2 byte

        byte dataTypeByte = 127; // 1 byte
        short dataTypeShort = 'b'; // 2 byte
        int dataTypeInteger = 0; // 4 byte
        long dataTypeLong = 500; // 8 byte

        float dataTypeFloat = 3.14f; // 4 byte
        double dataTypeDouble = 5.678; // 8 byte

        System.out.println("Boolean DataType: " + dataTypeBool);
        System.out.println("Char DataType: " + dataTypeChar);
        System.out.println("Byte DataType: " + dataTypeByte);
        System.out.println("Short DataType: " + dataTypeShort);
        System.out.println("Integer DataType: " + dataTypeInteger);
        System.out.println("Long DataType: " + dataTypeLong);
        System.out.println("Float DataType: " + dataTypeFloat);
        System.out.println("Double DataType: " + dataTypeDouble);
        System.out.println("");

        //Operator Types
        int a = 10, b = 20;
        //unary Operator
        System.out.println("Unary Operator");
        System.out.println("Implementing postfix Unary Operator: " + a++);
        System.out.println("Implementing prefix Unary Operator: " + --a);
        System.out.println("");
        System.out.println("Arithmetic Operator");
        System.out.println("Implementing Arithmetic (+) Operator: " + a+b);
        System.out.println("Implementing Arithmetic (-) Operator: " + (a-b));
        System.out.println("Implementing Arithmetic (*) Operator: " + (a*b));
        System.out.println("Implementing Arithmetic (/) Operator: " + (b/a));
        System.out.println("Implementing Arithmetic (%) Operator: " + (a%b));
        System.out.println("");
        System.out.println("Shift Operator");
        System.out.println("Implementing Shift (<<) Operator: " + (a<<b));
        System.out.println("Implementing Shift (>>) Operator: " + (a>>b));
        System.out.println("Implementing Shift (>>>) Operator: " + (a>>>b));
        System.out.println("");
        System.out.println("Relational Operator");
        System.out.println("Implementing Relational (<) Operator: " + (a<b));
        System.out.println("Implementing Relational (>) Operator: " + (a>b));
        System.out.println("Implementing Relational (<=) Operator: " + (a<=b));
        System.out.println("Implementing Relational (>=) Operator: " + (a>=b));
        System.out.println("Implementing Relational (==) Operator: " + (a==b));
        System.out.println("Implementing Relational (!=) Operator: " + (a!=b));
        System.out.println("");
        System.out.println("Assignment Operator");
        System.out.println("Implementing Relational (+=) Operator: " + (a+=b));
        System.out.println("Implementing Relational (-=) Operator: " + (a-=b));
        System.out.println("Implementing Relational (*=) Operator: " + (a*=b));
        System.out.println("Implementing Relational (/=) Operator: " + (a/=b));
    }
}