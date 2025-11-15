class Term {
    private Fraction coefficient;
    private boolean hasVariable;

    /**creates a term class when we are just given a coefficient
     * @param coefficient the value of the constant term
     * @param example Term(5);
     * @return the created term
     */
    Term(Fraction coefficient){
        this.coefficient = coefficient;
        this.hasVariable = false;
    }

    /**Creates a term, possible with a variable
     * @param coefficient the value of the coefficient
     * @param hasVariable wether the term has a variable or not
     * @param example Term(56, true);
     * @return the created term
     */
    Term(Fraction coefficient, boolean hasVariable){
        this.coefficient = coefficient;
        this.hasVariable = hasVariable;
    }
    
    //tested
    /**returns the coefficient of a term 
     * @param example term1.getCoefficient
     * @return coefficient of the term
    */
    public Fraction getCoefficient(){
        return coefficient;
    }

    //tested
    /** returns if the term has a variable
     * @param example term1.hasVariable();
     * @return if the term has a variable
    */
    public boolean hasVariable(){
        return hasVariable;
    }

    //tested
    /** adds two terms
     * @param t the term you want to add to the first term
     * @param example term1.add(term2);
     * @return the sum of the 2 terms
     */
    public Term add(Term t) throws IllegalArgumentException{
        if((this.hasVariable != t.hasVariable)){
            throw new IllegalArgumentException("Can't be added because they aren't like terms");
        }
        Fraction newCoefficient = this.coefficient.add(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }
  
    //tested
    /**Subtracts two terms 
     * @param t the term to be subtracted from the first term
     * @param example term1.subtract(term2);
     * @return the difference of the 2 terms
    */
    public Term subtract(Term t) throws IllegalArgumentException{
        if(this.hasVariable != t.hasVariable){
            throw new IllegalArgumentException();
        }
        Fraction newCoefficient = this.coefficient.subtract(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

    /**Multiplies two terms
     * @param t the term you want multiplied with the first term
     * @param example term1.multiply(term2);
     * @return the product of the 2 terms
     */
    public Term multiply(Term t){
        Fraction newCoefficient = this.coefficient.multiply(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }
    
    /**Divides two terms
     * @param t the term you want to divide the first term by
     * @param example term1.divide(term2)
     * @return the quotient of the 2 terms
     */
    public Term divide(Term t){
        Fraction newCoefficient = this.coefficient.divide(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }
    /**converts from term to String */
    public String toString(){
        if(hasVariable){
            return coefficient.toString() + "x";
        }
        return coefficient.toString();
    }
    
    //tested
    /**Converts from string to term 
     * @param token a string representation of the term
     * @param example Term.valueOf("56x");
     * @return the converted term
    */
    public static Term valueOf(String token){

        // Strip parentheses only if they wrap a pure number/fraction
        if(token.startsWith("(") && token.endsWith(")")){
            String inner = token.substring(1, token.length()-1);
            if(inner.matches("[+-]?\\d+(/\\d+)?")){
                token = inner; // only unwrap if it's a simple number or fraction
            }
        }
        if(token.startsWith("+") && token.length() > 1 && Character.isLetter(token.charAt(1))){
            token = token.substring(1);
        }
        boolean hasVar = false;
        String coefficientString = token;

        for(int i = 0; i < token.length(); i++){
            if(Character.isLetter(token.charAt(i))){
                hasVar = true;
                coefficientString = token.substring(0, i);
                String remainder = token.substring(i+1);
                if(remainder.startsWith("/")){
                    if(coefficientString.equals("") || coefficientString.equals("+")){
                        coefficientString = "1";
                    }
                    else if(coefficientString.equals("-")){
                        coefficientString = "-1";
                    }
                    coefficientString += remainder;
                }
                break;
            }
        }
        if(coefficientString.equals("")|| coefficientString.equals("+")){
                coefficientString = "1";
            }
        else if(coefficientString.equals("-")){ 
            coefficientString = "-1";

        }
        
        Fraction coefficient = Fraction.valueOf(coefficientString);
        return new Term(coefficient, hasVar);

    }
}
