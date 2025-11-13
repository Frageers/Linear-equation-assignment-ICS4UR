class Equation {
    private Expression leftSide;
    private Expression rightSide;
    private char variable;

    public Equation(String equation){
        equation = equation.replace(" ", "");
        char variable = findVariable(equation);

        int equalsIndex = equation.indexOf('=');
        String leftString = equation.substring(0, equalsIndex);
        String rightString = equation.substring(equalsIndex + 1);

        leftSide = Expression.handleWholeDivide(leftString);
        rightSide = Expression.handleWholeDivide(rightString);
        this.variable = variable;
    }
    /**gives the left side of the equation
     * @return everything before the =
     */
    public Expression getLeftSide(){
        return leftSide;
    }
    /**gives the right side of the equation 
     * @return everything after the =
    */
    public Expression getRightSide(){
        return rightSide;
    }
    /**Finds the variable used in an equation and makes sure there is only 1
     * 
     * @param equation the equation to search through for the variable
     * @return the name of the variable
     */
    private static char findVariable(String equation) throws IllegalArgumentException{
        char variable = '\0';
        for(int i = 0; i < equation.length(); i++){
            char c = equation.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                if(variable == '\0'){
                    variable = c;
                }
                else if(variable != c){
                    throw new IllegalArgumentException("More than one variable found in equation.");
                }
            }

        }
        if(variable == '\0'){
            throw new IllegalArgumentException("No variable found in equation");
        }
        return variable;
    }

    //tested
    /**Solves the equation and returns it in a properly formatted way
     * @return the answer formatted properly
    */
    public String solve(){
        Term xPart = leftSide.getVariableTerm().subtract(rightSide.getVariableTerm());
        Term constantPart = leftSide.getConstantTerm().subtract(rightSide.getConstantTerm());

        Fraction variableValue = constantPart.getCoefficient().multiply(new Fraction(-1, 1)).divide(xPart.getCoefficient());
        Term answer = new Term(variableValue, false);
        return variable + " = " + answer;
    }
}
