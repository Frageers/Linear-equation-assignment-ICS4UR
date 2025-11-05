class Equation {
    private Expression leftSide;
    private Expression rightSide;

    public Equation(String equation){
        equation = equation.replace(" ", "");

        int equalsIndex = equation.indexOf('=');
        String leftString = equation.substring(0, equalsIndex);
        String rightString = equation.substring(equalsIndex + 1);

        leftSide = Expression.simplify(leftString);
        rightSide = Expression.simplify(rightString);
    }

    public Term solve(){
        Term xPart = leftSide.getVariableTerm().subtract(rightSide.getVariableTerm());
        Term constantPart = leftSide.getConstantTerm().subtract(rightSide.getConstantTerm());

        Fraction variableValue = constantPart.getCoefficient().multiply(new Fraction(-1, 1)).divide(xPart.getCoefficient());
        return new Term(variableValue, false);
    }

    public static void main(String[] args) {
        Equation equation = new Equation("2x + 34/5x - 15 = -3x + 21/2x");
        Equation equation1 = new Equation("5p = 15");
        System.out.println(equation1.solve());
    }
}
