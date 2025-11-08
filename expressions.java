import java.util.Scanner;

class Expression {
    Term variableTerm = new Term(new Fraction(0, 1), true);
    Term constantTerm = new Term(new Fraction(0, 1), false);

    Expression(Term variableTerm, Term constantTerm){
        this.variableTerm = variableTerm;
        this.constantTerm = constantTerm;
    }
    Expression(){}

    //tested
   /**Gets the variable term
    *@return the variable term from the expression 
    */ 
    public Term getVariableTerm(){
        return variableTerm;
    }

    //tested
    /**Gets the constant term 
     * @return the constant term from the expression
    */
    public Term getConstantTerm(){
        return constantTerm;
    }
    /**Converts from expression to string */
    public String toString(){
        String result = "";
        if(variableTerm.getCoefficient().getNum() != 0){
            result += variableTerm.toString();
        }

        if (constantTerm.getCoefficient().getNum() != 0) {
            if (!result.equals("")) { // if there’s already a variable term
                result += " + "; // simple separator
            }
            result += constantTerm.toString();
        }

        return result;
    }

    //tested
    /**Simplifies the expression
     * 
     * @param expression the expression to be simplified
     * @return the simplified expression
     */
    public static Expression simplify(String expression){
        Expression e = new Expression();
        expression = expression.replace(" ", "");
        expression = expression.replace("+", " +");
        expression = expression.replace("-", " -");

        Scanner sc = new Scanner(expression);
        while (sc.hasNext()){
            String term = sc.next();
            if(term.equals("")){
                continue;
            }
            Term current = Term.valueOf(term);
            if(current.hasVariable()){
                e.variableTerm = e.variableTerm.add(current);
            }
            else{
                e.constantTerm = e.constantTerm.add(current);
            }


        }
        sc.close();
        return e;
    }
}
