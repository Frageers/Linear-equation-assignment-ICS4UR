public class term {
    private fraction coefficient;
    private boolean hasVariable;

    term(fraction coefficient){
        this.coefficient = coefficient;
        this.hasVariable = false;
    }

    term(fraction coefficient, boolean hasVariable){
        this.coefficient = coefficient;
        this.hasVariable = hasVariable;
    }

    public fraction getCoefficient(){
        return coefficient;
    }

    public boolean hasVariable(){
        return hasVariable;
    }

    public String toString(){
        if(hasVariable){
            return coefficient.toString() + "x";
        }
        return coefficient.toString();
    }
}
