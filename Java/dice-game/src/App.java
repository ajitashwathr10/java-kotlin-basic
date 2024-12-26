import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userScore = 0;
        int computerScore = 0;

        System.out.println("Dice Game");
        while(true) {
            System.out.print("\nPress Enter to roll the dice or 'q' to quit: ");
            String input = scanner.nextLine();
            System.out.print("Enter your roll (1-6): ");
            int userRoll = scanner.nextInt();
            if(input.equalsIgnoreCase("q")) {
                break;
            }
            int computerRoll = random.nextInt(6) + 1;

            System.out.println("You rolled: " + userRoll);
            System.out.println("Computer rolled: " + computerRoll);

            if(userRoll > computerRoll) {
                userScore++;
                System.out.println("You win!");
            } else if(computerRoll > userRoll) {
                computerScore++;
                System.out.println("Computer wins!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Score - You: " + userScore + " Computer: " + computerScore);
        }
        System.out.println("\nGame Over!");
        System.out.println("Final Score - You: " + userScore + "Computer: " + computerScore);
        if(userScore > computerScore) {
            System.out.println("Congratulations! You win!");
        } else if(userScore < computerScore) {
            System.out.println("Better luck next time!"); 
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();
    }
}