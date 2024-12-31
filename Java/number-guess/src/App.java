import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Number Guessing Game");
        System.out.println("Think a number between 1 and 100");
        while(!hasWon && attempts < 10) {
            System.out.println("Enter your no.: ");
            try {
                int guess = scanner.nextInt();
                attempts++;
                if(guess == numberToGuess) {
                    hasWon = true;
                    System.out.println("You guessed it in " + attempts + " attempts");
                } else if(guess < numberToGuess) {
                    System.out.println("Too low! Try again");
                } else {
                    System.out.println("Too high! Try again");
                }
            } catch(Exception e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
        if(!hasWon) {
            System.out.println("Game over! The number was: " + numberToGuess);
        }
        scanner.close();
    }
}