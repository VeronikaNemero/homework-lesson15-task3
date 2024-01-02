import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Student {

    private String name;

    private String group;

    private int course;

    public int[] grades;

    public Student() {
    }

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Arrays.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, group, course);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }

    @Override
    public String toString() {
        return "Student " + name +
                ", from group " + group +
                " and course " + course +
                ", have grades: " + Arrays.toString(grades);
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public int[] getGrades() {
        return grades;
    }

    public double averageScore(List<Student> students){
        int sum = 0;
        for (Student st : students) {
            for (int j = 0; j < st.grades.length; j++) {
                sum += st.getGrades()[j];
            }
        }
        return (double) sum / students.size();
    }

//    public void deleteStudent(List<Student> students){
//        Iterator<Student> studentIterator = students.iterator();
//        while(studentIterator.hasNext()) {
//            Student nextStudent = studentIterator.next();
//            if (nextStudent.averageScore(students) < 3) {
//                studentIterator.remove();
//            }
//        }
//    }

    public void deleteStudent(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.averageScore(students);

            if (averageGrade < 3.0) {
                iterator.remove();
            } else {
                int currentCourse = student.getCourse();
                student = new Student(student.getName(), student.getGroup(), currentCourse + 1, student.getGrades());
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Students on course " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
