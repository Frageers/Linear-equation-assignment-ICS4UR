//add any test methods here and run it to test methods


public class test {
    //fraction class method testing
    static void testToStringFrac(){
        Fraction fraction1 = new Fraction(11, 12);
        Fraction fraction2 = new Fraction(1, 4, 2);
        Fraction fraction3 = new Fraction(6, 3);
        Fraction fraction4 = new Fraction(0, 5);

        System.out.println(fraction1.toString()); //expected 11/12
        System.out.println(fraction2.toString()); //expected 2 1/4
        System.out.println(fraction3.toString()); //expected 2
        System.out.println(fraction4.toString()); //expected 0
    }

    static void testAddFrac(){
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        
        Fraction fraction3 = new Fraction(2, 7);
        Fraction fraction4 = new Fraction(3, 7);

        Fraction fraction5 = new Fraction(1, 4);
        Fraction fraction6 = new Fraction(3, 4);

        Fraction fraction7 = new Fraction(5, 6);
        Fraction fraction8 = new Fraction(3, 4);

        

        System.out.println(fraction1.add(fraction2)); //expected 5/6
        System.out.println(fraction3.add(fraction4)); //expected 5/7
        System.out.println(fraction5.add(fraction6)); //expected 1
        System.out.println(fraction7.add(fraction8)); //expected 1 7/12
    }

    static void testSubtractFrac(){
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);

        Fraction fraction3 = new Fraction(1, 4);
        Fraction fraction4 = new Fraction(3, 4);

        Fraction fraction5 = new Fraction(1, 2);
        Fraction fraction6 = new Fraction(-1, 4);

        Fraction fraction7 = new Fraction(1, 2);
        Fraction fraction8 = new Fraction(1, -4);



        System.out.println(fraction1.subtract(fraction2)); //expected 1/6
        System.out.println(fraction3.subtract(fraction4)); //expected -1/2
        System.out.println(fraction5.subtract(fraction6)); //expected 3/4
        System.out.println(fraction7.subtract(fraction8)); //expected 3/4
    }

    static void testMultiplyFrac() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);

        Fraction fraction3 = new Fraction(-1, 4);
        Fraction fraction4 = new Fraction(3, 5);

        Fraction fraction5 = new Fraction(0, 7);
        Fraction fraction6 = new Fraction(5, 9);

        Fraction fraction7 = new Fraction(3, 4);
        Fraction fraction8 = new Fraction(4, 3);

        System.out.println(fraction1.multiply(fraction2)); //expected 1/3
        System.out.println(fraction3.multiply(fraction4)); //expected -3/20
        System.out.println(fraction5.multiply(fraction6)); //expected 0
        System.out.println(fraction7.multiply(fraction8)); //expected 1
    }

    static void testDivideFrac() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);

        Fraction fraction3 = new Fraction(-3, 4);
        Fraction fraction4 = new Fraction(1, 2);

        Fraction fraction5 = new Fraction(5, 6);
        Fraction fraction6 = new Fraction(5, 6);

        Fraction fraction7 = new Fraction(7, 8);
        Fraction fraction8 = new Fraction(-7, 4);

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
        Term term1 = new Term(new Fraction(7, 1), false);
        System.out.println(term1);

        Term term2 = new Term(new Fraction(5, 1), true);
        System.out.println(term2);

        Term term3 = new Term(new Fraction(3, 5), true);
        System.out.println(term3);

        Term term4 = new Term(new Fraction(-1, 1), true);
        System.out.println(term4);

        Term term5 = new Term(new Fraction(-4, 12), false);
        System.out.println(term5);

    }
    
    static void testAddTerms(){
        Term term1 = new Term(new Fraction(3, 4), true);
        
        Term term2 = new Term(new Fraction(8, 11), true);

        System.out.println(term1.add(term2));

        Term term3 = new Term(new Fraction(3,4), true);
        
        Term term4 = new Term(new Fraction(-1, 4), false);  
        
        System.out.println(term3.add(term4));

    }
    

    static void testSubtractTerms(){
        Term term1 = new Term(new Fraction(7, 14), false);
        
        Term term2 = new Term(new Fraction(14, 16), false);

        System.out.println(term1.subtract(term2));

        Term term3 = new Term(new Fraction(3,4), true);
        
        Term term4 = new Term(new Fraction(-1, 4), false);  
        System.out.println(term3.subtract(term4));
    }

    static void testMultiplyTerms(){
        Term term1 = new Term(new Fraction(3, 4), true);
        
        Term term2 = new Term(new Fraction(8, 11), true);

        System.out.println(term1.multiply(term2));

        Term term3 = new Term(new Fraction(3,4), true);
        
        Term term4 = new Term(new Fraction(-1, 4), false);  
        
        System.out.println(term3.multiply(term4));

    }

    static void testDivideTerms(){
        Term term1 = new Term(new Fraction(3, 4), true);
        
        Term term2 = new Term(new Fraction(8, 11), true);

        System.out.println(term1.divide(term2));

        Term term3 = new Term(new Fraction(3,4), true);
        
        Term term4 = new Term(new Fraction(-1, 4), false);  
        
        System.out.println(term3.divide(term4));

    }
    
    public static void testAllTerms(String[] args) {
        // testAllFractionMethods();
        // testTermClass();
        //testAddTerms();
        //testSubtractTerms();
        testDivideTerms();


    }


    
}
