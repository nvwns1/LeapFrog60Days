package Day5;

// To handle runtime errors so that the normal flow of the application can be maintained.
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            int a = 1, b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally Block Executed");
        }
        try {
            String n = null;
            System.out.println(n.length());
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException catched");
        }
        try {
            int a[] = new int[5];
            a[10] = 50;
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException catched");
        }
    }
}
