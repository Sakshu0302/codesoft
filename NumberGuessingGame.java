import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            for (int attempt = 1; attempt <= attemptsLimit; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempts.");
                    score += attemptsLimit - attempt + 1;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == attemptsLimit) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Your total score: " + score);
                break;
            }
        }

        scanner.close();
    }
}
