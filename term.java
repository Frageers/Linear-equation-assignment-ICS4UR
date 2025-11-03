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
    /**returns the coefficient of a term */
    public Fraction getCoefficient(){
        return coefficient;
    }

    /** returns if the term has a variable*/
    public boolean hasVariable(){
        return hasVariable;
    }


    /** adds two terms
     * @param t the term you want to add to the first term
     */
    public Term add(Term t){
        Fraction newCoefficient = this.coefficient.add(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

    public Term subtract(Term t){
        Fraction newCoefficient = this.coefficient.subtract(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

    public Term multiply(Term t){
        Fraction newCoefficient = this.coefficient.multiply(t.coefficient);
        return new Term(newCoefficient, this.hasVariable());
    }

    public Term divide(Term t){
        Fraction newCoefficient = this.coefficient.divide(t.coefficient);
        return new Term(newCoefficient, this.hasVariable);
    }

    public String toString(){
        if(hasVariable){
            return coefficient.toString() + "x";
        }
        return coefficient.toString();
    }
}
