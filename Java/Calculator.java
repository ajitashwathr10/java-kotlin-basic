import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char ope;

        System.out.println("Simple Calculator");
        System.out.println("-----------------");

        while(true) {
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            ope = scanner.next().charAt(0);

            switch(ope) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    if(num2 == 0) {
                        System.out.println("Error: Division by zero!");
                    }
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println("Invalid operator");
                    continue;
            }
            System.out.print("Calculate again? (y/n): ");
            char choice = scanner.next().charAt(0);
            if(choice != 'y' && choice != 'Y') {
                break;
            }
        }
        scanner.close();
    }
}
