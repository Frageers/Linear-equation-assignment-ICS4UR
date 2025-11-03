//add any test methods here and run it to test methods


public class test {
    //fraction class method testing
    static void testToStringFrac(){
        fraction fraction1 = new fraction(11, 12);
        fraction fraction2 = new fraction(1, 4, 2);
        fraction fraction3 = new fraction(6, 3);
        fraction fraction4 = new fraction(0, 5);

        System.out.println(fraction1.toString()); //expected 11/12
        System.out.println(fraction2.toString()); //expected 2 1/4
        System.out.println(fraction3.toString()); //expected 2
        System.out.println(fraction4.toString()); //expected 0
    }

    static void testAddFrac(){
        fraction fraction1 = new fraction(1, 2);
        fraction fraction2 = new fraction(1, 3);
        
        fraction fraction3 = new fraction(2, 7);
        fraction fraction4 = new fraction(3, 7);

        fraction fraction5 = new fraction(1, 4);
        fraction fraction6 = new fraction(3, 4);

        fraction fraction7 = new fraction(5, 6);
        fraction fraction8 = new fraction(3, 4);

        

        System.out.println(fraction1.add(fraction2)); //expected 5/6
        System.out.println(fraction3.add(fraction4)); //expected 5/7
        System.out.println(fraction5.add(fraction6)); //expected 1
        System.out.println(fraction7.add(fraction8)); //expected 1 7/12
    }

    static void testSubtractFrac(){
        fraction fraction1 = new fraction(1, 2);
        fraction fraction2 = new fraction(1, 3);

        fraction fraction3 = new fraction(1, 4);
        fraction fraction4 = new fraction(3, 4);

        fraction fraction5 = new fraction(1, 2);
        fraction fraction6 = new fraction(-1, 4);

        fraction fraction7 = new fraction(1, 2);
        fraction fraction8 = new fraction(1, -4);



        System.out.println(fraction1.subtract(fraction2)); //expected 1/6
        System.out.println(fraction3.subtract(fraction4)); //expected -1/2
        System.out.println(fraction5.subtract(fraction6)); //expected 3/4
        System.out.println(fraction7.subtract(fraction8)); //expected 3/4
    }

    static void testMultiplyFrac() {
        fraction fraction1 = new fraction(1, 2);
        fraction fraction2 = new fraction(2, 3);

        fraction fraction3 = new fraction(-1, 4);
        fraction fraction4 = new fraction(3, 5);

        fraction fraction5 = new fraction(0, 7);
        fraction fraction6 = new fraction(5, 9);

        fraction fraction7 = new fraction(3, 4);
        fraction fraction8 = new fraction(4, 3);

        System.out.println(fraction1.multiply(fraction2)); //expected 1/3
        System.out.println(fraction3.multiply(fraction4)); //expected -3/20
        System.out.println(fraction5.multiply(fraction6)); //expected 0
        System.out.println(fraction7.multiply(fraction8)); //expected 1
    }

    static void testDivideFrac() {
        fraction fraction1 = new fraction(1, 2);
        fraction fraction2 = new fraction(2, 3);

        fraction fraction3 = new fraction(-3, 4);
        fraction fraction4 = new fraction(1, 2);

        fraction fraction5 = new fraction(5, 6);
        fraction fraction6 = new fraction(5, 6);

        fraction fraction7 = new fraction(7, 8);
        fraction fraction8 = new fraction(-7, 4);

        System.out.println(fraction1.divide(fraction2)); //expected 3/4
        System.out.println(fraction3.divide(fraction4)); //expected -1 1/2
        System.out.println(fraction5.divide(fraction6)); //expected 1
        System.out.println(fraction7.divide(fraction8)); //expected -1/2
    }

    static void testAllFractionMethods(){
        System.out.println("To String fraction:");
        testToStringFrac();
        System.out.println("Add fraction:");
        testAddFrac();
        System.out.println("Subtract fraction:");
        testSubtractFrac();
        System.out.println("Multiply fraction:");
        testMultiplyFrac();
        System.out.println("Divide fraction");
        testDivideFrac();
    }

    //term class method testing
    static void testTermClass(){
        term term1 = new term(new fraction(7, 1), false);
        System.out.println(term1);

        term term2 = new term(new fraction(5, 1), true);
        System.out.println(term2);

        term term3 = new term(new fraction(3, 5), true);
        System.out.println(term3);

        term term4 = new term(new fraction(-1, 1), true);
        System.out.println(term4);

        term term5 = new term(new fraction(-4, 12), false);
        System.out.println(term5);

    }
    
    public static void main(String[] args) {
        // testAllFractionMethods();
        testTermClass();


    }
}
