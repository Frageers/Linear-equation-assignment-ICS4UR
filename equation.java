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

        leftSide = Expression.simplify(leftString);
        rightSide = Expression.simplify(rightString);
        this.variable = variable;
    }
    /**Finds the variable used in an equation and makes sure there is only 1
     * @param equation the equation to search through for the variable
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
    /**Solves the equation and returns it in a properly formatted way */
    public String solve(){
        Term xPart = leftSide.getVariableTerm().subtract(rightSide.getVariableTerm());
        Term constantPart = leftSide.getConstantTerm().subtract(rightSide.getConstantTerm());

        Fraction variableValue = constantPart.getCoefficient().multiply(new Fraction(-1, 1)).divide(xPart.getCoefficient());
        Term answer = new Term(variableValue, false);
        return variable + " = " + answer;
    }


    public static void main(String[] args) {
        Equation equation1 = new Equation("2x + 34/5x - 15 = -3x + 21/2x");
        Equation equation2 = new Equation("-7/2p + 6/5 = 9/4");


        System.out.println(equation1.solve());
        System.out.println(equation2.solve());
    }
}
