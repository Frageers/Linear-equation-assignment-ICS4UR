import java.util.Scanner;

class Expression {
    Term variableTerm;
    Term constantTerm;

    Expression(){
        this.variableTerm = new Term(new Fraction(0, 1), true);
        this.constantTerm = new Term(new Fraction(0, 1), false);
    }
   /**Gets the variable term */ 
    public Term getVariableTerm(){
        return variableTerm;
    }
    /**Gets the constant term */
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

    /**Simplifies the expression
     * @param expression the expression to be simplified
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

    public static void main(String[] args){
        System.out.println(simplify("-2x - 5 - x + 7"));
    }
}
