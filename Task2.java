import java.util.Scanner;
import java.util.Random;

// Khushal Upadhayay :)
// Task-2 -- Guess The Number

public class Task2 {
    int system_Input;
    int user_Input;
    int noOfGuesses = 0;

    Task2() {
        // Generating Random number and storing it in "systemInput"
        Random random = new Random();
        this.system_Input = random.nextInt(100) + 1;
    }

    // Now we will take User Input
    public boolean takeUserInput() {
        if (noOfGuesses < 10) {
            System.out.print("Guess the Number : ");
            this.user_Input = GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        } else {
            System.out.println("Number of attempts finished :(....Better Luck Next Time :)\n");
            return true;
        }
    }

    //Checking the user guess status
    public boolean isCorrectGuess() {

        if (system_Input == user_Input) {
            System.out.println("Congratulations, you guess the number " + system_Input +
                    " in " + noOfGuesses + " guesses");
            switch(noOfGuesses) {
                case 1:
                    System.out.println("Your score - 100");
                    break;
                case 2:
                    System.out.println("Your score - 90");
                    break;
                case 3:
                    System.out.println("Your score - 80");
                    break;
                case 4:
                    System.out.println("Your score - 70");
                    break;
                case 5:
                    System.out.println("Your score - 60");
                    break;
                case 6:
                    System.out.println("Your score - 50");
                    break;
                case 7:
                    System.out.println("Your score - 40");
                    break;
                case 8:
                    System.out.println("Your score - 30");
                    break;
                case 9:
                    System.out.println("Your score - 20");
                    break;
                case 10:
                    System.out.println("Your score - 10");
                    break;
            }
            System.out.println();
            return true;
        } else if (noOfGuesses < 10 && user_Input > system_Input) {
            if (user_Input - system_Input > 10) {
                System.out.println("Too High");
            } else {
                System.out.println("Little High");
            }
        } else if (noOfGuesses < 10 && user_Input < system_Input) {
            if (system_Input - user_Input > 10) {
                System.out.println("Too low");
            } else {
                System.out.println("Little low");
            }
        }
        return false;
    }


    // main class
    public class GuessTheNumber {

        // static method to take integer input without any limit and exception error
        // exception handling and input limit handling
        public static int takeIntegerInput(int limit) {
            int input = 0;
            boolean flag = false;

            while (!flag) {
                try {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    flag = true;

                    if (flag && input > limit || input < 1) {
                        System.out.println("Choose the number between 1 to " + limit);
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("Enter only integer value");
                    flag = false;
                }
            }
            ;
            return input;
        }
    }
    // Main Method
    public static void main(String[] args) {
        // input for start the game
        System.out.println("Press 1 if you want to start the Game \nPress 2 to Exit");
        System.out.print("Enter your choice : ");
        int choice = GuessTheNumber.takeIntegerInput(2);
        int next_Round = 1;
        int noOfRound = 0;

        if (choice == 1) {

            // to check next round is there or not
            while (next_Round == 1) {
                // creating object of Game class
                Task2 Game = new Task2();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println();
                System.out.println("Round " + ++noOfRound + " starts...");

                // to check correct guess and limit cross
                while (!isMatched && !isLimitCross) {
                    isLimitCross = Game.takeUserInput();
                    isMatched = Game.isCorrectGuess();
                }
                // Next Round :)
                System.out.println("Press 1 for Next Round \nPress 2 to Exit");
                System.out.println("Enter your choice : ");
                next_Round = GuessTheNumber.takeIntegerInput(2);
                if (next_Round != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
