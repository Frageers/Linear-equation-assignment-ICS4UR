//add any test methods here and run it to test methods


public class test {
    static void testToString(){
        fraction fraction1 = new fraction(11, 12);
        fraction fraction2 = new fraction(1, 4, 2);
        fraction fraction3 = new fraction(6, 3);
        fraction fraction4 = new fraction(0, 5);

        System.out.println(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction3);
        System.out.println(fraction4);
    }

    public static void main(String[] args) {
        testToString();
    }
}
