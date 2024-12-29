package Java.to-do-list.src;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

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