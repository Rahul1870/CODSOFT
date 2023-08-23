    //TASK 1 NUMBER GAME
    //CODSOFT

import java.util.Scanner;
import java.util.Random;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Specify the minimum range
        int maxRange = 100; // Specify the maximum range
        int attempts = 5; // Number of attempts allowed per round
        int rounds = 0; // Number of rounds played
        int score = 0; // Score to track rounds won

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int remainingAttempts = attempts;

            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (remainingAttempts > 0) {
                System.out.println("Attempts left: " + remainingAttempts);
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                remainingAttempts--;
            }

            if (remainingAttempts == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Your score: " + score + " out of " + rounds + " rounds.");
        scanner.close();
    }
}
