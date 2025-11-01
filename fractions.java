class fraction {
    private int num;
    private int den;
    private int whole = 0;
    
    //constructors
    fraction(int num, int den){
        int g = gcd(num, den);
        this.num = num / g;
        this.den = den / g;

        if(this.den < 0){
            this.num *= -1;
            this.den *= -1;
        }
    }

    fraction(int num, int den, int whole){
        int g = gcd(num, den);
        num /= g;
        den /= g;


        //convert mixed to improper
        this.num = whole * den + num;
        this.den = den;
        this.whole = 0;

        if(this.den < 0){
            this.num *= -1;
            this.den *= -1;
        }
    }

    static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) return a;
        return gcd(b, a % b);
    }

    //getters
    int getNum(){
        return num;
    }
    int getDen(){
        return den;
    }
    int getWhole(){
         return whole;
    }

    //setters
    void setNum(int num){
        this.num = num;
    }

    void setDen(int den){
        this.den = den;
    }

    public String toString(){
        int wholePart = num / den;
        int remainder = Math.abs(num % den);

        if(remainder == 0){
            return String.valueOf(wholePart);
        }

        if (wholePart == 0){
            return String.format("%d/%d", num, den);
        }
        return String.format("%d %d/%d", wholePart, remainder, Math.abs(den));
    }


}
