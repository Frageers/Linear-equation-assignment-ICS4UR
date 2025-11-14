class Quiz {
    /**returns a random fraction
     * @return a random fraction
     */
    static Fraction randomFraction(){
        int num = (int)(Math.random() * (50 - -50)) + -50;
        int den = (int) (Math.random() * (50 - -50)) + -50;
        return new Fraction(num, den);
    }

    /**returns a random number
     * @param max the larger number
     * @param min the smaller number
     */
    static int randomnumber(int max, int min){
        return (int)(Math.random() * (max - min)) + min;
    }
    
    /**generates a random one step equation
     * @return a one step equation
     */
    static String oneStep(){
        double random = Math.random() ;
        randomFraction();
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        
        if(random <=0.33){
            if(b<0){
                return String.format("x - %d = %d", -b, c);
            }
            return String.format("x + %d = %d", b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
            return String.format("%dx = %d", a, c);
        }
        return String.format("(%d)/x = %d", a, c);

    }

    /**generates a random two step equation
     * @return a two step equation
     */
    static String twoStep(){
        double random = Math.random() ;
        randomFraction();
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        Fraction aFract = randomFraction();
        
        if(random <=0.2){
            if(b<0){
                return String.format("%dx - %d = %d", a, -b, c);
            }


            return String.format("%dx + %d = %d", a, b, c);
            
        }
        else if(random >0.2 && random <=0.4 ){
            if(b<0){
                return String.format("(x)/%d - %d = %d", a, -b, c);
            }
            return String.format("(x)/%d + %d = %d", a, b, c);
        }
        else if(random >0.4 && random <=0.6){
             if(aFract.isNegative()){
                return String.format("(x + %d)/%d = %d", aFract.absoluteValue(),aFract.getDen(), c);
            }
            return String.format("(x - %d)/%d = %d", aFract.getNum(),aFract.getDen(), c);
            
        }
        else if(random >0.6 && random <=0.8 ){
            return String.format("%d(x + %d) = %d", a, b, c);
        }
        return String.format("(%d)/x = %d", a, c);
        
        
    }
    
    /**generates a random three step equation
     * @return a random three step equation
     */
    static String threeStep(){
        double random = Math.random() ;
        randomFraction();
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        Fraction cFract = randomFraction();
        
        if(random>=0.33){
            if (b<0){
                return String.format("(%d)/x - %d = %d", a, -b, c);
            }
            return String.format("(%d)/x + %d = %d", a, b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
            return String.format("%d(x - %d)/%d = %d", a, c);
        }
        return String.format("(%d)/x = %d/%d", a, cFract.getNum(), cFract.getDen());

    }

    /**Generates a random four step equation
     * @return a random four step equation
     */
    static String fourStep(){
        Fraction aFract = randomFraction();
        Fraction bFract = randomFraction();
        Fraction cFract = randomFraction();
        if(bFract.isNegative()){
            return String.format("(%dx)/%d - (%d)/%d = (%d)/%d", aFract.absoluteValue(), aFract.getDen(), bFract.getNum(), bFract.getDen(), cFract.getNum(), cFract.getDen());
        }
        return String.format("(%dx)/%d + (%d)/%d = (%d)/%d", aFract.getNum(), aFract.getDen(), bFract.getNum(), bFract.getDen(), cFract.getNum(), cFract.getDen());
    }
    
}