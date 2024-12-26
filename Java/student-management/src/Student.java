import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1. Add Student");
            System.out.println("\n2. Display Students");
            System.out.println("\n3.Search Student");
            System.out.println("\n4.Exit");
            System.out.print("Enter choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("3. Enter student age: ");
        int age = scanner.nextInt();
    }

    private static void displayStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for(Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search");
        int searchId = scanner.nextInt();

        for(Student student : students) {
            if(student.getId() == searchId) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Grade: " + grade;
    }
}

