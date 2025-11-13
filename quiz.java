import java.util.Scanner;
class quiz {

    


    static Fraction randomFraction(){
        int num = (int)(Math.random() * (50 - -50)) + -50;
        int den = (int) (Math.random() * (50 - -50)) + -50;
        return new Fraction(num, den);
    }




        static int randomnumber(int max, int min){
        return (int)(Math.random() * (max - min)) + min;
    }
    

    static String oneStep(){
        double random = Math.random() ;
        randomFraction();
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        Fraction aFract = randomFraction();
        
        if(random <=0.33){
            return String.format("x + %d = %d", b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
            return String.format("%dx = %d", a, c);
        }
        return String.format("(%d)/x = %d", aFract.getNum(), c);

    }

    static String twoStep(){
        double random = Math.random() ;
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        Fraction aFract = randomFraction();
        
        if(random <=0.2){
            return String.format("%dx + %d = %d", a, b, c);   
        }
        else if(random >0.2 && random <=0.4 ){

            return String.format("(x)/%d + %d = %d", aFract.getDen(), b, c);
        }
        else if(random >0.4 && random <=0.6){
            return String.format("(x - %d)/%d = %d", aFract.getNum(), aFract.getDen(), c);
            
        }
        else if(random >0.6 && random <=0.8 ){
            return String.format("%d(x + %d) = %d", a, b, c);
        }
        return String.format("(%d)/x = %d", aFract.getNum(), c);
        
        
    }
    
    static String threeStep(){
        double random = Math.random() ;
        
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        Fraction aFract = randomFraction();
        Fraction cFract = randomFraction();
        
        if(random>=0.33){
            return String.format("(%d)/x + %d = %d", aFract.getNum(), b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
        
            return String.format("%d(x - %d)/%d = %d", a, aFract.getNum(), aFract.getDen(),c);
        }
        return String.format("(%d)/x = %d/%d", aFract.getNum(), cFract.getNum(), cFract.getDen());

    }

    static String fourStep(){
        Fraction aFract = randomFraction();
        Fraction bFract = randomFraction();
        Fraction cFract = randomFraction();
        return String.format("(%dx)/%d + (%d)/%d = (%d)/%d", aFract.getNum(), aFract.getDen(), bFract.getNum(), bFract.getDen(), cFract.getNum(), cFract.getDen());
    }
    static String multiStep(){
        double random = Math.random();
        int a = randomnumber(-50, 50);
        int b = randomnumber(-50, 50);
        int c = randomnumber(-50, 50);
        int d = randomnumber(-50, 50);
        int e = randomnumber(-50, 50);
        if(random >=0.5){
            return String.format("%dx - %d = %dx + %d", a, b, c, d);
        }
        else{
            return String.format("%dx + %d - %d = %d + %dx", a, b, c, d, e);
        }

    }
    
}
