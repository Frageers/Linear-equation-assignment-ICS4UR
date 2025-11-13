import java.util.Scanner;

class Expression {
    private Term variableTerm = new Term(new Fraction(0, 1), true);
    private Term constantTerm = new Term(new Fraction(0, 1), false);

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
        StringBuilder result = new StringBuilder();
        if(variableTerm.getCoefficient().getNum() != 0){
            result.append(variableTerm.toString());
        }
        int constNum = constantTerm.getCoefficient().getNum();
        int constDen = constantTerm.getCoefficient().getDen();

        if(constNum != 0){
            if(result.length() > 0){
                if(constNum > 0){
                    result.append(" + ").append(constantTerm.toString());
                }
                else{
                    result.append(" - ").append(new Fraction(-constNum, constDen));
                }
            }
            else{
                result.append(constantTerm.toString());
            }
        }

        return result.toString();
    }
    
    /**Handles distribution for cases like 2(x+3)
     * @param expression the expression that needs to be expanded
     * @return the expanded form of the equation
     */
    public static Expression handleBracket(String expression) throws IllegalArgumentException{
        expression = expression.replace(" ", "");

        int open = expression.indexOf("(");
        int close = expression.indexOf(")");
        if(open == -1) return simplify(expression);
        if(close == -1) throw new IllegalArgumentException("Invalid equation, bracket never closed");

        String stringCoefficientBracket = expression.substring(0, open);
        String stringExpressionInBracket = expression.substring(open+1,close);
        String stringRestExpression = expression.substring(close+1);

        if(stringCoefficientBracket.equals("") || stringCoefficientBracket.equals("+")){
            stringCoefficientBracket = "1";
        }
        else if(stringCoefficientBracket.equals("-")){
            stringCoefficientBracket = "-1";
        }

        Term multiplier = Term.valueOf(stringCoefficientBracket);

        Term newVarTerm = simplify(stringExpressionInBracket).getVariableTerm().multiply(multiplier);
        Term newConstantTerm = simplify(stringExpressionInBracket).getConstantTerm().multiply(multiplier);


        Expression expanded = new Expression(newVarTerm, newConstantTerm);
            Expression rest;
            if (stringRestExpression.equals("") || stringRestExpression.equals("+") || stringRestExpression.equals("-")) {
                rest = new Expression(); // 0
            } 
            else {
                rest = simplify(stringRestExpression);
            }

        return new Expression((expanded.getVariableTerm().add(rest.getVariableTerm())), (expanded.getConstantTerm().add(rest.getConstantTerm())));
    }

    /**Handles whole division for cases like (x+3)/5
     * @param expression the expression with the whole divide
     * @return the simplified version of the given expression
     */
    public static Expression handleWholeDivide(String expression) throws IllegalArgumentException{
        expression = expression.replace(" ", "");
        int locationWholeDivide = expression.indexOf(")/");
        if(locationWholeDivide == -1){
            return handleBracket(expression);
        }
        String insideBracket = expression.substring(0, locationWholeDivide+1);
        String divisorStr = expression.substring(locationWholeDivide+2);
        Term divisor = simplify(divisorStr).getConstantTerm();
        Expression bracketSimplified = handleBracket(insideBracket);
        Term newVarTerm = bracketSimplified.getVariableTerm().divide(divisor);
        Term newConstantTerm = bracketSimplified.getConstantTerm().divide(divisor);
        return new Expression(newVarTerm, newConstantTerm);

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
