//add any test methods here and run it to test methods


public class test {
    //Fractions
    static void testGCD(){
        System.out.println("Testing GCD");
        System.out.println("Expected 2, got " + Fraction.gcd(4, 10)); //2
        System.out.println("Expected 1, got " + Fraction.gcd(7, 13)); //1
        System.out.println("Expected 25, got " + Fraction.gcd(25, 100));
        System.out.println("Expected 3,, got " + Fraction.gcd(-6, 9));
    }

    static void testGetNum(){
        System.out.println("Testing Get Num");
        System.out.println("Expected 1, got " + new Fraction(1, 4).getNum());
        System.out.println("Expected 6, got " + new Fraction(12, 14).getNum());
        System.out.println("Expected -2, got " + new Fraction(-12, 18).getNum());
    }

    static void testGetDen(){
        System.out.println("Testing Get Den");
        System.out.println("Expected 4, got " + new Fraction(1, 4).getDen());
        System.out.println("Expected 7, got " + new Fraction(12, 14).getDen());
        System.out.println("Expected 3, got " + new Fraction(-12, 18).getDen());
    }

    static void testGetWhole(){
        System.out.println("Testing Get whole");
        System.out.println("Expected 0, got " + new Fraction(1, 4, 7).getWhole());
        System.out.println("Expected 0, got " + new Fraction(12, 14, 67).getWhole());
        System.out.println("Expected 0, got " + new Fraction(15, 18, -9).getWhole());
    }

    static void testAddFrac(){
        System.out.println("Testing Add fractions");
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        
        Fraction fraction3 = new Fraction(2, 7);
        Fraction fraction4 = new Fraction(3, 7);

        Fraction fraction5 = new Fraction(1, 4);
        Fraction fraction6 = new Fraction(3, 4);

        Fraction fraction7 = new Fraction(5, 6);
        Fraction fraction8 = new Fraction(3, 4);

        

        System.out.println("Expected 5/6, got " + fraction1.add(fraction2)); //expected 5/6
        System.out.println("Expected 5/7, got " + fraction3.add(fraction4)); //expected 5/7
        System.out.println("Expected 1, got " + fraction5.add(fraction6)); //expected 1
        System.out.println("Expected 1 7/12, got " + fraction7.add(fraction8)); //expected 1 7/12
    }

    static void testSubtractFrac(){
        System.out.println("Testing Subtract fraction");
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);

        Fraction fraction3 = new Fraction(1, 4);
        Fraction fraction4 = new Fraction(3, 4);

        Fraction fraction5 = new Fraction(1, 2);
        Fraction fraction6 = new Fraction(-1, 4);

        Fraction fraction7 = new Fraction(1, 2);
        Fraction fraction8 = new Fraction(1, -4);



        System.out.println("Expected 1/6, got " + fraction1.subtract(fraction2)); //expected 1/6
        System.out.println("Expected -1/2, got " + fraction3.subtract(fraction4)); //expected -1/2
        System.out.println("Expected 3/4, got " + fraction5.subtract(fraction6)); //expected 3/4
        System.out.println("Expected 3/4, got " + fraction7.subtract(fraction8)); //expected 3/4
    }

    static void testMultiplyFrac() {
        System.out.println("Testing Multiply fraction");
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);

        Fraction fraction3 = new Fraction(-1, 4);
        Fraction fraction4 = new Fraction(3, 5);

        Fraction fraction5 = new Fraction(0, 7);
        Fraction fraction6 = new Fraction(5, 9);

        Fraction fraction7 = new Fraction(3, 4);
        Fraction fraction8 = new Fraction(4, 3);

        System.out.println("Expected 1/3, got " + fraction1.multiply(fraction2)); //expected 1/3
        System.out.println("Expected -3/20, got " + fraction3.multiply(fraction4)); //expected -3/20
        System.out.println("Expected 0, got " + fraction5.multiply(fraction6)); //expected 0
        System.out.println("Expected 1, got " + fraction7.multiply(fraction8)); //expected 1
    }

    static void testDivideFrac() {
        System.out.println("Testing Divide fractions");
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);

        Fraction fraction3 = new Fraction(-3, 4);
        Fraction fraction4 = new Fraction(1, 2);

        Fraction fraction5 = new Fraction(5, 6);
        Fraction fraction6 = new Fraction(5, 6);

        Fraction fraction7 = new Fraction(7, 8);
        Fraction fraction8 = new Fraction(-7, 4);

        System.out.println("Expected 3/4, got " + fraction1.divide(fraction2)); //expected 3/4
        System.out.println("Expected -1 1/2, got " + fraction3.divide(fraction4)); //expected -1 1/2
        System.out.println("Expected 1, got " + fraction5.divide(fraction6)); //expected 1
        System.out.println("Expected -1/2, got " + fraction7.divide(fraction8)); //expected -1/2
    }

    static void testValueOfFrac(){
        System.out.println("Testing Value of Fraction");
        String fraction1 = "5/10";
        String fraction2 = "2 1/4";
        String fraction3 = "-5/15";

        
        System.out.println("Expected 1/2, got " + Fraction.valueOf(fraction1));
        System.out.println("Expected 2 1/4, got " + Fraction.valueOf(fraction2));
        System.out.println("Expected -1/3, got " + Fraction.valueOf(fraction3));
    }
    
    static void testAllFractionMethods(){
        System.out.println("Testing the fraction class");
        testGCD();
        System.out.println("\n");
        testGetNum();
        System.out.println("\n");
        testGetDen();
        System.out.println("\n");
        testGetWhole();
        System.out.println("\n");
        testAddFrac();
        System.out.println("\n");
        testSubtractFrac();
        System.out.println("\n");
        testMultiplyFrac();
        System.out.println("\n");
        testDivideFrac();
        System.out.println("\n");
        testValueOfFrac();
        System.out.println("\n\n");
    }

    //Terms

    static void testGetCoefficient(){
        System.out.println("Testing Get coefficient of term");
        System.out.println("Expected 1/3, got " + new Term(new Fraction(5, 15), false).getCoefficient());
        System.out.println("Expected -5, got " + new Term(new Fraction(-5, 1), false).getCoefficient());
        System.out.println("Expected 5, got " + new Term(new Fraction(-5, -1), false).getCoefficient());

    }

    static void testHasVariable(){
        System.out.println("Testing term has variable");
        System.out.println("Expected false, got " + new Term(new Fraction(5, 15), false).hasVariable());
        System.out.println("Expected true, got " + new Term(new Fraction(-5, -1), true).hasVariable());

    }
    
    static void testValueOfTerm(){
        System.out.println("Testing get value of term");
        String term1 = "3/7x";
        String term2 = "-5/4x";

        System.out.println(Term.valueOf(term1));
        System.out.println(Term.valueOf(term2));
        System.out.println(Term.valueOf(term1).add(Term.valueOf(term2)));
    }

    static void testAddTerms(){
        System.out.println("Testing add terms");
        Term term1 = new Term(new Fraction(3, 4), true);
        Term term2 = new Term(new Fraction(8, 11), true);

        Term term3 = new Term(new Fraction(3,4), false);
        Term term4 = new Term(new Fraction(-1, 4), false);

        
        System.out.println("Expected 1 21/44x, got " + term1.add(term2));
        System.out.println("Expected 1/2, got "  + term3.add(term4));
    }

    static void testSubtractTerms(){
        System.out.println("Testing Subtract terms");
        Term term1 = new Term(new Fraction(7, 14), false);
        Term term2 = new Term(new Fraction(14, 16), false);

        Term term3 = new Term(new Fraction(3,4), true);
        Term term4 = new Term(new Fraction(-1, 4), true);
        
        System.out.println("Expected -3/8, got " + term1.subtract(term2));    
        System.out.println("Expected 1x, got " + term3.subtract(term4));
    }
    
    static void testAllTermMethods(){
    System.out.println("Testing Term class");
        testGetCoefficient();
        System.out.println("\n");
        testHasVariable();
        System.out.println("\n");
        testValueOfTerm();
        System.out.println("\n");
        testAddTerms();
        System.out.println("\n");
        testSubtractTerms();
        System.out.println("\n\n");
    }
   
    //Expressions

    static void testGetVarTerm(){
        System.out.println("Testing getting the variable term");
        Term term1 = new Term(new Fraction(5, 1), true);
        Term term2 = new Term(new Fraction(5, 13), false);
        
        Term term3 = new Term(new Fraction(-10, 3), true);
        Term term4 = new Term(new Fraction(4, 7), false);
        
        Term term5 = new Term(new Fraction(100, 25), true);
        Term term6 = new Term(new Fraction(-3, 4), false);


        System.out.println("Expected 5x, got " + new Expression(term1, term2).getVariableTerm());
        System.out.println("Expected -3 1/3x, got " + new Expression(term3, term4).getVariableTerm());
        System.out.println("Expected 4x, got " + new Expression(term5, term6).getVariableTerm());
    }

    static void testGetConstantTerm(){
        System.out.println("Testing getting the constant term");
        Term term1 = new Term(new Fraction(5, 1), true);
        Term term2 = new Term(new Fraction(5, 13), false);
        
        Term term3 = new Term(new Fraction(-10, 3), true);
        Term term4 = new Term(new Fraction(4, 7), false);
        
        Term term5 = new Term(new Fraction(100, 25), true);
        Term term6 = new Term(new Fraction(-3, 4), false);


        System.out.println("Expected 5/13, got " + new Expression(term1, term2).getConstantTerm());
        System.out.println("Expected 4/7, got " + new Expression(term3, term4).getConstantTerm());
        System.out.println("Expected -3/4, got " + new Expression(term5, term6).getConstantTerm());
    }

    static void testSimplify(){
        System.out.println("Testing simplifying expressions");
        System.out.println("Expected 3x, got " + Expression.simplify("x+x+x")); //3x
        System.out.println("Expected 14, got " + Expression.simplify("5+7+2")); //14
        System.out.println("Expected -1x + 3, got " + Expression.simplify("-x+3")); //-1x+3
        System.out.println("Expected -10x + 5, got " + Expression.simplify("5-10x")); //-10x + 5
        System.out.println("Expected -23/28x, got " + Expression.simplify("3/7x - 5/4x")); //-23/28x
    }
    
    static void testAllExpressionMethods(){
        System.out.println("Testing the Expression class");
        testGetVarTerm();
        System.out.println("\n");
        testGetConstantTerm();
        System.out.println("\n");
        testSimplify();
        System.out.println("\n\n");
    }
    
    //Equations
    static void testSolve(){
        System.out.println("Testing Equation class");
        Equation equation1 = new Equation("2x + 34/5x - 15 = -3x + 21/2x");
        Equation equation2 = new Equation("-7/2p + 6/5 = 9/4");
        
        System.out.println("Expected x = 11 7/13, got " + equation1.solve());
        System.out.println("Expected p = -3/10, got " + equation2.solve());
    }
    public static void main(String[] args) {
        testAllFractionMethods();
        testAllTermMethods();
        testAllExpressionMethods();
        testSolve();
    }


    
}
