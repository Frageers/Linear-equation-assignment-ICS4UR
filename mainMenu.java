import java.util.Scanner;
class MainMenu {
    /**Handles the case when the user wants to use the calculator
     * @param sc the scanner object to use for input
     */
    private static void calculator(Scanner sc){
        boolean exitCalculator = false;
        String answer = "";
        while(!exitCalculator){
            boolean validQuestion = false;
            while(!validQuestion){
                System.out.println("Enter the equation you want to solve");
                String equationStr = sc.nextLine();
                try{
                    answer = new Equation(equationStr).solve();
                    validQuestion = true;
                }
                catch(Exception e){
                    System.out.println("Invalid Equation: " + e.getMessage());
                    System.out.println("Please try again");
                }
            }
            
            System.out.println(" " + "_".repeat(answer.length() + 2) + " ");
            System.out.println("| " + answer + " |");
            System.out.println("|" + "_".repeat(answer.length() + 2) + "|");


            boolean validChoice = false;
            int choice = 0;

            while(!validChoice){
                System.out.println("What would you like to do next?");
                System.out.println("1. Solve another equation");
                System.out.println("2. Return to home");
                System.out.println("3. Exit program");

                try{
                    choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 1){
                        validChoice = true;
                    }
                    else if(choice == 2){
                        validChoice = true;
                        exitCalculator = true;
                    }
                    else if(choice == 3){
                        System.exit(0);
                    }
                    else{
                        throw new IllegalArgumentException("Invalid choice. Choice has to be between 1 and 3");
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
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
    private static void quiz(Scanner sc){
        boolean exitQuiz = false;
        while(!exitQuiz){
            int choice = 0;
            boolean validChoice = false;
            while(!validChoice){
                try{
                    System.out.println("How many steps do you want the equation to be");
                    System.out.println("1. One Step \n2. Two Steps \n3. Three Steps \n4. Four steps");

                    choice = sc.nextInt();
                    sc.nextLine();

                    if(choice < 1 || choice > 4){
                        throw new IllegalArgumentException("Choice has to be between 1 and 4");
                    }
                    validChoice = true;
                }
                catch(Exception e){
                    System.out.println("Invalid input. " + e.getMessage());
                }
                
            }
            

            String equationStr = generateEquation(choice);

            System.out.println("Question:");
            System.out.println(equationStr);
            System.out.print("Make sure that the answer is mixed fraction where neccessary \nx = ");
            String userAnswer = sc.nextLine();
            System.out.println(compareAnswers(equationStr, userAnswer));
            boolean validNext = false;
            while(!validNext){
                try{
                    System.out.println("What would you like to do now \n1.Answer another question \n2. Return to home \n3. Exit");
                    int choiceTwo = sc.nextInt();
                    sc.nextLine();
                
                    if(choiceTwo == 1){
                        validNext = true;
                    }
                    else if(choiceTwo == 2){
                        validNext = true;
                        exitQuiz = true;
                    }
                    else if(choiceTwo == 3){
                        System.exit(0);
                    }
                    else{
                        throw new IllegalArgumentException("Invalid input. Choice has to be between 1 and 3");
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            boolean validOption = false;
            while(!validOption){
                System.out.println("What tool would you like to use?");
                System.out.println("1. Calculator");
                System.out.println("2. Quiz");
                System.out.println("3. Exit program");

                try{
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 1){
                        calculator(sc);
                    }
                    else if(choice == 2){
                        quiz(sc);
                    }
                    else if(choice == 3){
                        System.exit(0);
                    }
                    else{
                        throw new IllegalArgumentException("Invalid choice. Choice has to be between 1 and 3");
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
