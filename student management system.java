import java.util.*;

class Student {
    int id, mark;
    String name;

    Student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + mark);
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\\n1.Add  2.View  3.Update  4.Delete  5.Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: add(); break;
                case 2: view(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: System.out.println("Bye!"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }

    static void add() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Mark: ");
        int mark = Integer.parseInt(sc.nextLine());
        students.add(new Student(id, name, mark));
        System.out.println("Student added!");
    }

    static void view() {
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }
        System.out.println("ID | Name | Mark");
        for (Student s : students) s.display();
    }

    static void update() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("New name: ");
                s.name = sc.nextLine();
                System.out.print("New mark: ");
                s.mark = Integer.parseInt(sc.nextLine());
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void delete() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = students.removeIf(s -> s.id == id);
        System.out.println(removed ? "Deleted!" : "Student not found.");
    }
}
