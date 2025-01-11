import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nTemperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            if(choice == 3) break;
            System.out.print("Enter temperature: ");
            double temp = scanner.nextDouble();
            if(choice == 1) {
                double fahrenheit = (temp * 1.8) + 32;
                System.out.printf("%.1f* C = %.1f*F%n", temp, fahrenheit);
            } else if(choice == 2) {
                double celsius = (temp - 32) * 5 / 9;
                System.out.printf("%.1f* F = %.1f* C%n", temp, celsius);
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}