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
        
        if(random <=0.33){
            return String.format("x + %d = %d", b, c);
            
        }
        else if(random >0.33 && random <=0.66 ){
            return String.format("%dx = %d", a, c);
        }
        return String.format("(%d)/x = %d", a, c);

    }

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

    static String fourStep(){
        randomFraction();

        return String.format("(%dx)/%d + (%d)/%d = (%d)/%d", randomFraction(), randomFraction(), randomFraction());
    }
    


    public static void main(String[] args) {
        double random = Math.random() ;
        Scanner input = new Scanner(System.in);
        /*if(random<=0.2){
        System.out.println("Equation : " + oneStep());
        }
        else if(random>0.2 && random<=0.4){
            System.out.println("Equation : " + twoStep());
        }   
        else if(random>0.4 && random<=0.6){
            System.out.println("Equation : " + threeStep());
        }
        else if(random>0.6 && random<=0.8){*/
            System.out.println("Equation : " + fourStep());
        //}
        

    }
    
}
