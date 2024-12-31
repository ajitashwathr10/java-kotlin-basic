import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("To Do List Application (Java)");
        System.out.println("----------------------------");

        while(running) {
            displayMenu();
            int choice = getChoice();
            switch(choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    markTaskComplete();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again");
            }
        }
        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("\nMenu: ");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Task as Complete");
        System.out.println("5.Exit");
        System.out.println("Enter your choice (1 - 5): ");
    }
    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch(Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void addTask() {
        scanner.nextLine();
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully");
    }
    private static void viewTasks() {
        if(tasks.isEmpty()) {
            System.out.println("No tasks in the list!");
            return;
        } 
        System.out.println("\nCurrent Tasks: ");
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void deleteTask() {
        viewTasks();
        if(tasks.isEmpty()) return;
        System.out.print("Enter tsk number to delete: ");
        try {
            int taskNum = scanner.nextInt();
            if(taskNum > 0 && taskNum <= tasks.size()) {
                tasks.remove(taskNum - 1);
                System.out.println("Task deleted successfully");
            } else {
                System.out.println("Invalid task number!");
            }
        } catch(Exception e) {
            System.out.println("Invalid input! Please enter a number: ");
            scanner.nextLine();
        }
    }

    private static void markTaskComplete() {
        viewTasks();
        if(tasks.isEmpty()) return;
        System.out.print("Enter task number to mark as complete: ");
        try {
            int taskNum = scanner.nextInt();
            if(taskNum > 0 && taskNum <= tasks.size()) {
                String task = tasks.get(taskNum - 1);
                tasks.set(taskNum - 1, task + " (Completed)");
                System.out.println("Task marked as complete!");
            } else {
                System.out.println("Invalid task number");
            }
        } catch(Exception e) {
            System.out.println("Invalid input! Please enter a number: ");
            scanner.nextLine();
        }
    }
}