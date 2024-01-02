import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Nick", "p12", 2, new int[]{5, 4, 4, 5}));
        students.add(new Student("Adam", "r3", 3, new int[]{1, 2}));
        students.add(new Student("Evan", "p12", 2, new int[]{5, 4, 4}));
        students.add(new Student("Sara", "e2", 4, new int[]{2, 4, 1}));
        students.add(new Student("Nora", "e2", 2, new int[]{5, 5}));
        students.add(new Student("Molly", "r3", 3, new int[]{3, 3, 3}));

        students.forEach(System.out::println);

        Student student = new Student();
        student.deleteStudent(students);

        Student.printStudents(students, 2);
    }
}