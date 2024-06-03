public class Day2 {

    public static void main(String[] args) {
        // Conditional Statements
        int number = 10;

        if (number > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is non-positive");
        }

        // switch statement
        int dayOfWeek = 3;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        // Loop Statements
        // for loop
        System.out.println("For loop:");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // while loop
        System.out.println("While loop:");
        int count = 0;
        while (count < 5) {
            System.out.println(count);
            count++;
        }

        // do-while loop
        System.out.println("Do-while loop:");
        count = 0;
        do {
            System.out.println(count);
            count++;
        } while (count < 5);

        // Branching Statements
        // break and continue
        System.out.println("Break and Continue:");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // exit the loop
            }
            if (i == 3) {
                continue; // skip the current iteration
            }
            System.out.println(i);
        }

        // return statement
        int result = add(5, 3);
        System.out.println("Sum: " + result);

        // try-catch-finally statement
        try {
            int[] array = new int[5];
            System.out.println(array[10]); // this will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } finally {
            System.out.println("This will always be executed.");
        }
    }

    // Method to demonstrate return statement
    public static int add(int a, int b) {
        return a + b;
    }
}
