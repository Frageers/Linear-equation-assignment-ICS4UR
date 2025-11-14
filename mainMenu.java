import java.util.Scanner;
class MainMenu {
    /**Handles the case when the user wants to use the calculator
     * @param sc the scanner object to use for input
     */
    static void calculator(Scanner sc){
        boolean exitCalculator = false;
        while(!exitCalculator){
            System.out.println("Enter the equation you want to solve");
            String equationStr = sc.nextLine();
            String answer = new Equation(equationStr).solve();
            System.out.println(" " + "_".repeat(answer.length() + 2) + " ");
            System.out.println("| " + answer + " |");
            System.out.println("|" + "_".repeat(answer.length() + 2) + "|");

            System.out.println("What would you like to do next?");
            System.out.println("1. Solve another equation");
            System.out.println("2. Return to home");
            System.out.println("3. Exit program");

            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
             continue;   
            }
            else if(choice == 2){
                exitCalculator = true;
            }
            else{
                System.exit(0);
            }
        }
    }


    /**Generates a random equation depending on the users choice
     * @param choice the option of how many steps the want
     * @return equation for that many steps
     */
    private static String generateEquation(int choice){
        String equationStr = "";
        if(choice == 1){
            equationStr = Quiz.oneStep();
        }
        else if(choice == 2){
            equationStr = Quiz.twoStep();
        }
        else if(choice == 3){
            equationStr = Quiz.threeStep();
        }
        else if(choice == 4){ 
            equationStr = Quiz.fourStep();
        }
        return equationStr;
    }

    /**Compares the user's answer with the calculated answer
     * @param equation the original equation to be solved
     * @param userAnswer what the user inputted the answer to be
     * @return String feedback on if the user inputted the answer correctly
     */
    private static String compareAnswers(String equation, String userAnswer){
        String actualAnswer = new Equation(equation).solve();
        String finalAnswer = "x = " + userAnswer;

        if(actualAnswer.equals(finalAnswer)){
            return "Your Answer is correct!";
        }
        return "Your answer is wrong";

    }

    /**Handles the case when the user wants to use the quiz 
     * @param sc the scanner object to use for input
    */
    static void quiz(Scanner sc){
        boolean exitQuiz = false;
        while(!exitQuiz){
            System.out.println("How many steps do you want the equation to be");
            System.out.println("1. One Step \n2. Two Steps \n3. Three Steps \n4. Four steps");

            int choice = sc.nextInt();
            sc.nextLine();

            String equationStr = generateEquation(choice);

            System.out.println("Question:");
            System.out.println(equationStr);
            System.out.print("Make sure that the answer is mixed fraction where neccessary \nx = ");
            String userAnswer = sc.nextLine();
            System.out.println(compareAnswers(equationStr, userAnswer));
            System.out.println("What would you like to do now \n1.Answer another question \n2. Return to home \n3. Exit");
            int choiceTwo = sc.nextInt();
            sc.nextLine();

            if(choiceTwo == 1){
                continue;
            }
            else if(choiceTwo == 2){
                exitQuiz = true;
            }
            else{
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("What tool would you like to use?");
            System.out.println("1. Calculator");
            System.out.println("2. Quiz");
            System.out.println("3. Exit program");

            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                calculator(sc);
            }
            else if(choice == 2){
                quiz(sc);
            }
            else{
                System.exit(0);
            }
        }
    }
}
