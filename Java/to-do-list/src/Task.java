import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean completed() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }
}

public class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();

        public void addTask(String description) {
            tasks.add(new Task(description));
        }
        public void viewTasks() {
            if(tasks.isEmpty()) {
                System.out.println("No tasks found!");
            } else {
                for(int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }
        }

        public void markTaskAsCompleted(int index) {
            if(index >= 0 && index < tasks.size()) {
                tasks.get(index).markAsCompleted();
            } else {
                System.out.println("Invalid task number.");
            }
        }

        public void deleteTask(int index) {
            if(index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            } else {
                System.out.println("Invalid task number.");
            }
        }

        public void saveTasksToFile(String filename) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(tasks);
                System.out.println("Tasks saved to " + filename);
            } catch(IOException e) {
                System.out.println("Error saving tasks: " + e.getMessage());
            }
        }

        public void loadTasksFromFile(String filename) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                tasks = (List<Task>) ois.readObject();
                System.out.println("Tasks loaded from " + filename);
            } catch(IOException | ClassNotFoundException e) {
                System.out.println("Error loading tasks: " + e.getMessage());
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        String filename = "tasks.ser";

        while(true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Save Tasks to File");
            System.out.println("6. Load Tasks from File");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    toDoList.markTaskAsCompleted(taskNumber - 1);
                    break;
                case 4:
                    System.out.print("Enter task number to delete: ");
                    taskNumber = scanner.nextInt();
                    toDoList.deleteTask(taskNumber - 1);
                    break;
                case 5:
                    toDoList.saveTasksToFile(filename);
                    break;
                case 6:
                    toDoList.loadTasksFromFile(filename);
                    break;
                case 7:
                    System.out.println("Exiting");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid option. Please try again. ");
            }
        }
    }
}
