class Term {
    private Fraction coefficient;
    private boolean hasVariable;

    Term(Fraction coefficient){
        this.coefficient = coefficient;
        this.hasVariable = false;
    }

    Term(Fraction coefficient, boolean hasVariable){
        this.coefficient = coefficient;
        this.hasVariable = hasVariable;
    }
    
    //tested
    /**returns the coefficient of a term 
     * @return coefficient of the term
    */
    public Fraction getCoefficient(){
        return coefficient;
    }

    //tested
    /** returns if the term has a variable
     * @return if the term has a variable
    */
    public boolean hasVariable(){
        return hasVariable;
    }

    //tested
    /** adds two terms
     * @param t the term you want to add to the first term
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
     * @return the difference of the 2 terms
    */
    public Term subtract(Term t) throws IllegalArgumentException{
        if(this.hasVariable != t.hasVariable){
            throw new IllegalArgumentException();
        }
        Fraction newCoefficient = this.coefficient.subtract(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

    public Term multiply(Term t){
        Fraction newCoefficient = this.coefficient.multiply(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

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
     * @return the converted term
    */
    public static Term valueOf(String token){
        System.out.println("DEBUG: token = \"" + token + "\"");  // <--- Add this
        boolean hasVar = false;
        String coefficientString = token;

        for(int i = 0; i < token.length(); i++){
            if(Character.isLetter(token.charAt(i))){
                hasVar = true;
                coefficientString = token.substring(0, i);
                String remainder = token.substring(i+1);
                if(remainder.startsWith("/")){
                    if(coefficientString.equals("")){
                        coefficientString = "1";
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
