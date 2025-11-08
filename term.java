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
    /** returns if the term has a variable*/
    public boolean hasVariable(){
        return hasVariable;
    }

    //tested
    /** adds two terms
     * @param t the term you want to add to the first term
     */
    public Term add(Term t) throws IllegalArgumentException{
        if((this.hasVariable != t.hasVariable)){
            throw new IllegalArgumentException("Can't be added because they aren't like terms");
        }
        Fraction newCoefficient = this.coefficient.add(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }
  
    //tested
    /**Subtracts two terms */
    public Term subtract(Term t) throws IllegalArgumentException{
        if(this.hasVariable != t.hasVariable){
            throw new IllegalArgumentException();
        }
        Fraction newCoefficient = this.coefficient.subtract(t.coefficient);
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
    /**Converts from string to term */
    public static Term valueOf(String token){
        boolean hasVar = false;
        char charAtEnd = token.charAt(token.length()-1);
        if((charAtEnd >= 'a' && charAtEnd <= 'z') || (charAtEnd >= 'A' && charAtEnd <= 'Z')){
            hasVar = true;
            token = token.substring(0, token.length()-1);
        }
        if(token.equals("")|| token.equals("+")){
            token = "1";
        }
        else if(token.equals("-")){ 
            token = "-1";

        }
        Fraction coefficient = Fraction.valueOf(token);
        return new Term(coefficient, hasVar);

    }
}
