class Equation {
    private Expression leftSide;
    private Expression rightSide;
    private char variable;

    /**Creates an equation object from the given equation as a string
     * @param equation the string to be made into an equation
     * @param example Equation("5x = 15");
     * @return the created equation object
     */
    public Equation(String equation){
        equation = equation.replace(" ", "");
        char variable = findVariable(equation);

        int equalsIndex = equation.indexOf('=');
        if(equalsIndex == -1){
            throw new IllegalArgumentException("No '=' sign so not a valid equation");
        }
        String leftString = equation.substring(0, equalsIndex);
        String rightString = equation.substring(equalsIndex + 1);

        if(leftString.matches("[-+]?\\(?\\d+\\)?/" + variable)) {
            int slashIndex = leftString.indexOf("/");
            String numerator = leftString.substring(0, slashIndex);
            leftSide = new Expression(new Term(new Fraction(1,1), true), new Term(new Fraction(0,1), false));
            rightSide = Expression.handleWholeDivide(numerator + "/" + rightString);
            this.variable = variable;
            return;
        }

            if(rightString.matches("[-+]?\\(?\\d+\\)?/" + variable)) {
            int slashIndex = rightString.indexOf("/");
            String numerator = rightString.substring(0, slashIndex);
            rightSide = new Expression(new Term(new Fraction(1,1), true), new Term(new Fraction(0,1), false));
            leftSide = Expression.handleWholeDivide(numerator + "/" + leftString);
            this.variable = variable;
            return;
        }

        leftSide = Expression.handleWholeDivide(leftString);
        rightSide = Expression.handleWholeDivide(rightString);
        this.variable = variable;
    }
    /**gives the left side of the equation
     * @param example equation1.getLifeSide();
     * @return everything before the =
     */
    public Expression getLeftSide(){
        return leftSide;
    }
    /**gives the right side of the equation
     * @param example equation1.getRightSide(); 
     * @return everything after the =
    */
    public Expression getRightSide(){
        return rightSide;
    }
    /**Finds the variable used in an equation and makes sure there is only 1
     * 
     * @param equation the equation to search through for the variable
     * @param example findVariable(equation1);
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
     * @param example equation1.solve()
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
