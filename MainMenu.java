import java.util.Scanner;

class mainClass {

    public static void menu(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which operation based on its number:\n 1.Calculator \n 2.Quiz \n 3.Exit");
        String userInput = input.next();
        //if (Integer.valueOf(userInput) == 1 || userInput.toUpperCase()=="CALCULATOR"){
           /*  System.out.println( " Enter option:\n 1.One Step\n 2.Two Step\n 3.Three-Step\n 4.Four step\n 5.Multi-Step");
            String userQuizData = input.next();
            if (userQuizData.toUpperCase()=="ONE STEP" || Integer.valueOf(userQuizData)==1){
                System.out.println(quiz.oneStep());
                String equationStr = quiz.oneStep();
                Equation equation1 = new Equation(equationStr);
                System.out.println(equation1.solve());
                
                
                        }
            else if (userQuizData.toUpperCase()=="TWO STEP" || Integer.valueOf(userQuizData)==2){
                System.out.println(quiz.twoStep());
                String equationStr = quiz.twoStep();
                Equation equation1 = new Equation(equationStr);
                System.out.println(equation1.solve());

            }
            else if (userQuizData.toUpperCase()=="THREE STEP" || Integer.valueOf(userQuizData)==3){
                System.out.println(quiz.threeStep());
                String equationStr = quiz.threeStep();
                Equation equation1 = new Equation(equationStr);
                System.out.println(equation1.solve());

            }
            else if (userQuizData.toUpperCase()=="FOUR STEP" || Integer.valueOf(userQuizData)==4){
                System.out.println(quiz.fourStep());
                String equationStr = quiz.fourStep();
                Equation equation1 = new Equation(equationStr);
                System.out.println(equation1.solve());
            }
            else if (userQuizData.toUpperCase()=="MULTI-STEP" || userQuizData.toUpperCase()=="MULTI STEP"|| Integer.valueOf(userQuizData)==5){
                System.out.println(quiz.multiStep());
                String equationStr = quiz.multiStep();
                Equation equation1 = new Equation(equationStr);
                System.out.println(equation1.solve());
            }
            else {
                System.out.println("Not a option");

            
            }
            
        }*/
         if (Integer.valueOf(userInput)==2 || userInput.toUpperCase()=="QUIZ"){
            System.out.println( " Enter option:\n 1.One Step\n 2.Two Step\n 3.Three-Step\n 4.Four step\n 5.Multi-Step");
            String userQuizData = input.next();
            if (userQuizData.toUpperCase()=="ONE STEP" || Integer.valueOf(userQuizData)==1){
                System.out.println(quiz.oneStep());
                String userMInput = input.next();
                String equationStr = quiz.oneStep();
                Equation equation1 = new Equation(equationStr);

                if(equation1.solve().equals("x = " + userMInput)){
                    System.out.println("Correct!");
                }
                else{
                    System.out.println("Incorrect:(");
                }
                
                        }
            else if (userQuizData.toUpperCase()=="TWO STEP" || Integer.valueOf(userQuizData)==2){
                System.out.println(quiz.twoStep());
                String userMInput = input.next();
                String equationStr = quiz.twoStep();
                Equation equation1 = new Equation(equationStr);

                if(equation1.solve().equals("x = " + userMInput)){
                    System.out.println("Correct!");
                }
                else{
                    System.out.println("Incorrect:(");
                }

            }
            else if (userQuizData.toUpperCase()=="THREE STEP" || Integer.valueOf(userQuizData)==3){
                System.out.println(quiz.threeStep());
                String userMInput = input.next();
                String equationStr = quiz.threeStep();
                Equation equation1 = new Equation(equationStr);

                if(equation1.solve().equals("x = " + userMInput)){
                    System.out.println("Correct!");
                }
                else{
                    System.out.println("Incorrect:(");
                }

            }
            else if (userQuizData.toUpperCase()=="FOUR STEP" || Integer.valueOf(userQuizData)==4){
                System.out.println(quiz.fourStep());
                String userMInput = input.next();
                String equationStr = quiz.fourStep();
                Equation equation1 = new Equation(equationStr);

                if(equation1.solve().equals("x = " + userMInput)){
                    System.out.println("Correct!");
                }
                else{
                    System.out.println("Incorrect:(");
                }


            }
            else if (userQuizData.toUpperCase()=="MULTI-STEP" || userQuizData.toUpperCase()=="MULTI STEP"|| Integer.valueOf(userQuizData)==5){
                System.out.println(quiz.multiStep());
                String userMInput = input.next();
                String equationStr = quiz.multiStep();
                Equation equation1 = new Equation(equationStr);

                if(equation1.solve().equals("x = " + userMInput)){
                    System.out.println("Correct!");
                }
                else{
                    System.out.println("Incorrect:(");
                }

            }
            else {
                System.out.println("Not a option");

            
            }
        }
        else if (Integer.valueOf(userInput)==3 || userInput.toUpperCase()=="EXIT"){
            

        }
        else{
            System.out.println("non applicable");
        }


        
        Scanner input1 = new Scanner(System.in);
            System.out.println( " Enter option:\n 1.One Step\n 2.Two Step\n 3.Three-Step\n 4.Four step\n 5.Multi-Step");
            String userCalculatorData = input.next();
            
            if (userCalculatorData.toUpperCase()=="ONE STEP" || Integer.valueOf(userCalculatorData)==1){

            }
            else if (userCalculatorData.toUpperCase()=="TWO STEP" || Integer.valueOf(userCalculatorData)==2){

            }
            else if (userCalculatorData.toUpperCase()=="THREE STEP" || Integer.valueOf(userCalculatorData)==3){


            }
            else if (userCalculatorData.toUpperCase()=="FOUR STEP" || Integer.valueOf(userCalculatorData)==4){

            }
            else if (userCalculatorData.toUpperCase()=="MULTI-STEP" || userCalculatorData.toUpperCase()=="MULTI STEP"|| Integer.valueOf(userCalculatorData)==5){

            }
            else {
                System.out.println("Not a option");

            
            }

        

}
}

    

