import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private int numberToGuess;
    private int numberOfAttempts;

    public NumberGuessingGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        numberOfAttempts = 0;
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ":");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            numberOfAttempts++;

            if (playerGuess < LOWER_BOUND || playerGuess > UPPER_BOUND) {
                System.out.println("Please guess a number within the range.");
            } else if (playerGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
    }
}
