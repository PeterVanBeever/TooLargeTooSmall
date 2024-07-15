import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// The Main class contains the logic for the guessing game
public class Main {
    // Declare an integer to store the mystery number
    private int mysteryNumber;
    // Declare a set to store the guessed numbers, ensuring unique guesses
    private Set<Integer> guessedNumbers;

    // Constructor to initialize the game
    public Main(int range) {
        Random random = new Random(); // Create a Random object to generate random numbers
        this.mysteryNumber = random.nextInt(range) + 1; // Generate a random number between 1 and range
        this.guessedNumbers = new HashSet<>(); // Initialize the guessedNumbers set to store unique guesses
    }

    // Method to start the game
    public void start() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        int guess; // Declare an integer to store the user's guess
        boolean correct = false; // Initialize a boolean to track if the correct number has been guessed

        // Print welcome messages
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Guess the mystery number between 1 and 100");

        // Loop until the correct number is guessed
        while (!correct) {
            System.out.print("Enter your guess: "); // Prompt the user to enter a guess
            guess = scanner.nextInt(); // Read the user's guess

            // Check if the guess has not been guessed consecutively
            if (!guessedNumbers.contains(guess)) {
                guessedNumbers.add(guess); // Add the guess to the set of guessed numbers
                correct = checkGuess(guess); // Check if the guess is correct and update the correct flag
            } else {
                System.out.println("You already guessed that number. Try again."); // Notify the user of a repeated guess
            }
        }

        // Print congratulations message and the number of unique guesses
        System.out.println("Congratulations! You've guessed the correct number.");
        System.out.println("Number of guesses: " + guessedNumbers.size());
        scanner.close(); // Close the scanner
    }

    // Method to check the guess and provide feedback
    private boolean checkGuess(int guess) {
        if (guess < mysteryNumber) { // If the guess is less than the mystery number
            System.out.println("Too small!"); // Print "Too small!"
            return false; // Return false indicating the guess was incorrect
        } else if (guess > mysteryNumber) { // If the guess is greater than the mystery number
            System.out.println("Too large!"); // Print "Too large!"
            return false; // Return false indicating the guess was incorrect
        } else { // If the guess is equal to the mystery number
            System.out.println("Correct guess!"); // Print "Correct guess!"
            return true; // Return true indicating the guess was correct
        }
    }

    // Main method to run the game
    public static void main(String[] args) {
        int range = 100; // Define the range for the mystery number
        Main game = new Main(range); // Create a new instance of the Main class, initializing the game
        game.start(); // Start the game
    }
}
