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
        
        if(random <=0.2){
            return String.format("%dx + %d = %d", a, b, c);
            
        }
        else if(random >0.2 && random <=0.4 ){
            return String.format("(x)/%d + %d = %d", a, b, c);
        }
        else if(random >0.4 && random <=0.6){
            return String.format("(x - %d)/%d = %d", randomFraction(), c);
            
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
        
        if(random>=0.33){
            return String.format("(%d)/x + %d = %d", a, b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
            return String.format("%d(x - %d)/%d = %d", a, c);
        }
        return String.format("(%d)/x = %d/%d", a, randomFraction());

    }

    /**Generates a random four step equation
     * @return a random four step equation
     */
    static String fourStep(){
        Fraction fraction1 = randomFraction();
        Fraction fraction2 = randomFraction();
        Fraction fraction3 = randomFraction();
        return String.format("(%dx)/%d + (%d)/%d = (%d)/%d", fraction1.getNum(), fraction1.getDen(), fraction2.getNum(), fraction2.getDen(), fraction3.getNum(), fraction3.getDen());
    }
    
}