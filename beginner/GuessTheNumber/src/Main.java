import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isValid = false;
        int guessedNumber;
        int rndmNumber = (int)(Math.random() * 30) + 1;
        int numOfAttempts = 0;


        System.out.println("Let's play a game! I'm thinking of a number between 1 and 30. Try to guess it:");


        Scanner scanner = new Scanner(System.in);

        while (!isValid) {


            if (scanner.hasNextInt()) {
                guessedNumber = scanner.nextInt();
                numOfAttempts ++;
                if (guessedNumber < 1 || guessedNumber > 30){
                    System.out.println("You should guess a number between 1 and 30");
                }
                else{
                    if (guessedNumber == rndmNumber){
                        System.out.println("Congratulations! You guessed the right number in " + numOfAttempts + " tries!");
                        isValid = true;
                    } else if (guessedNumber < rndmNumber) {
                        System.out.println("The number is higher. Try Again");
                        System.out.printf("Your guess: %d \n", guessedNumber);


                    } else {
                        System.out.println("The number is lower. Try Again");
                        System.out.printf("Your guess: %d \n", guessedNumber);


                    }
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }


        scanner.close();
    }
}