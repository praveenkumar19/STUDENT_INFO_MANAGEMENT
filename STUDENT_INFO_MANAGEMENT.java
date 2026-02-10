import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void displayInfo() {
        System.out.println("----------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("----------------------------");
    }
}

class StudentManager {
    ArrayList<Student> students;

    StudentManager() {
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayInfo();
        }
    }

    void searchStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student found:");
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }

    void deleteStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }
}

public class StudentInfoManager {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = s.nextInt();
                    s.nextLine();

                    System.out.print("Enter Name: ");
                    String name = s.nextLine();

                    System.out.print("Enter Age: ");
                    int age = s.nextInt();
                    s.nextLine();

                    System.out.print("Enter Course: ");
                    String course = s.nextLine();

                    Student st = new Student(id, name, age, course);
                    manager.addStudent(st);
                    break;

                case 2:
                    manager.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = s.nextInt();
                    manager.searchStudentById(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = s.nextInt();
                    manager.deleteStudentById(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
