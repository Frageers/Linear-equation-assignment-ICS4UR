class Fraction {
    private int num;
    private int den;
    private int whole = 0;
    
    //constructors
    /**creates a fraction object when we are given the numerator and denominator
     * @param num numerator
     * @param den denominator
     * @param example Fraction(5, 6);
     */
    Fraction(int num, int den){

        if(den == 0){
            throw new ArithmeticException("Denominator can not be 0");
        }

        int g = gcd(num, den);
        this.num = num / g;
        this.den = den / g;

        if(this.den < 0){
            this.num *= -1;
            this.den *= -1;
        }
    }

    /**creates a fraction object when we are given the numerator, denominator, and whole number
     * @param num numerator
     * @param den denominator
     * @param whole whole number
     * @param example Fraction(5, 6, 12);
     */
    Fraction(int num, int den, int whole){

        if(den == 0){
            throw new ArithmeticException("Denominator can not be 0");
        }

        int g = gcd(num, den);
        num /= g;
        den /= g;


        //convert mixed to improper
        this.num = whole * den + num;
        this.den = den;
        this.whole = 0;

        if(this.den < 0){
            this.num *= -1;
            this.den *= -1;
        }
    }
   
    //tested
    /**retuns the gcd of 2 terms
     * @param a the first / lower number
     * @param b the second / higher number
     * @param example gcd(6, 54);
     * @return the gcd of the 2 numbers
     */
    static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

 
    //tested   
    /**returns the numerator 
     * @param example Fraction.getNum();
     * @return the numerator
    */
    int getNum(){
        return num;
    }
    
    //tested
    /**returns the denominator
     * @param example Fraction.getDen(); 
     * @return the denominator
    */
    int getDen(){
        return den;
    }

    //tested
    /**retuns the whole number 
     * @param example fraction.getWhole();
     * @return the whole number
    */
    int getWhole(){
         return whole;
    }

    //setters
    /**Sets the numerator 
     * @param num the numerator to set to
     * @param example fraction.setNum(11);
    */
    void setNum(int num){
        this.num = num;
    }
    /**Sets denominator 
     * @param den the denominator to set to
     * @param example fraction.setDen(11);
    */
    void setDen(int den){
        this.den = den;
    }
    /**Sets whole number 
     * @param whole the whole number to set to
     * @param example fraction.setWhole(11);
    */
    void setWhole(int whole){
        this.whole = whole;
    }

    //tested
    /**gives the Fraction formatted in a proper way
     * @return formatted string representation of the given Fraction
     * 
     */
    public String toString(){
        int wholePart = num / den;
        int remainder = Math.abs(num % den);

        if(remainder == 0){
            return String.valueOf(wholePart);
        }

        if (wholePart == 0){
            return String.format("%d/%d", num, den);
        }
        return String.format("%d %d/%d", wholePart, remainder, Math.abs(den));
    }
    
    //tested
    /**converts from String to Fraction 
     * @param term the string representation of the fraction
     * @param example Fraction.valueOf("1 5/6");
     * @return the string converted to a fraction
     *
    */
    public static Fraction valueOf(String term){
        term = term.trim();
        int space = term.indexOf(' ');
        if(space != -1){
            int whole = Integer.valueOf(term.substring(0, space));
            String fraction = term.substring(space + 1);
            int slash = fraction.indexOf('/');
            int num = Integer.valueOf(fraction.substring(0, slash));
            int den = Integer.valueOf(fraction.substring(slash+1));

            return new Fraction(num, den, whole);
        }
        int slash = term.indexOf('/');
        if(slash != -1){
            int num = Integer.valueOf(term.substring(0, slash));
            int den = Integer.valueOf(term.substring(slash + 1));
            return new Fraction(num, den);
        }
        return new Fraction(Integer.valueOf(term), 1);
    }

    //tested
    /**adds 2 Fractions
     * 
     * @param another the Fraction to be added to the first Fraction
     * @param example fraction1.add(fraction2)
     *@return the sum of the 2 fractions
     */
    public Fraction add(Fraction another){
        int newNum = this.num * another.den + another.num * this.den;
        int newDen = this.den * another.den;
        return new Fraction(newNum, newDen);
    }

    //tested
    /**subtracts 2 Fractions
     * @param another the Fraction to be subtracted from the first Fraction
     * @param example fraction1.subtract(fraction2);
     * @return the difference of the 2 fractions
     */
    public Fraction subtract(Fraction another){

        int newNum = this.num * another.den - another.num * this.den;
        int newDen = this.den * another.den;
        return new Fraction(newNum, newDen);
    }

    //tested
    /**multiplies 2 Fractions
     * @param another the Fraction to be multiplied with the first Fraction
     * @param example fraction1.multiply(fraction2);
     * @return the product of the 2 fractions
     */
    public Fraction multiply(Fraction another){
        int newNum = this.num * another.num;
        int newDen = this.den * another.den;
        return new Fraction(newNum, newDen);
    }

    //tested
    /** divides 2 Fractions 
     * @param another the Fraction to be divided with Fraction 1
     * @param example fraction1.divide(fraction2);
     * @return the quotient of the 2 fractions
     */
    public Fraction divide(Fraction another){
        return new Fraction((this.num * another.den), (this.den * another.num));
    }

    //tested
    /**checks if a fraction is negative
     * @param example fraction1.isNegative();
     * @return if the fraction is negative
     */
    public boolean isNegative(){
        return num * den <0;     
    }

    //tested
    /**gives the absolute value of a fraction
     * @param example fraction1.absoluteValue();
     * @return the absolute value of a fraction
     */
    public Fraction absoluteValue(){
        return new Fraction(Math.abs(num), Math.abs(den));
    }
}
