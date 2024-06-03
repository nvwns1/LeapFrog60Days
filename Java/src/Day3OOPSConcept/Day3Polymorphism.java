package Day3OOPSConcept;
// polymorphism means one form different function like +
// + can add two integer and + can also concat two string

class PolyMorphismExample {
    int a, b, c, d;

    public PolyMorphismExample(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void addNumbers(int a, int b) {
        System.out.println("Sum of two number " + a + b);
    }

    public void addNumbers(int a, int b, int c) {
        System.out.println("Sum of three number " + a + b + c);
    }

    public void addNumbers(int a, int b, int c, int d) {
        System.out.println("Sum of four number " + a + b + c + d);
    }

}

public class Day3Polymorphism {
    public static void main(String[] args) {
        PolyMorphismExample p = new PolyMorphismExample(3, 4, 5, 6);
        p.addNumbers(3, 4);
        p.addNumbers(3, 4, 5);
        p.addNumbers(3, 4, 5, 6);
    }
}
