import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        Student[] students=new Student[3];
        StudentService service=new StudentService();
        for (int i = 0; i < students.length; i++) {
            students[i]= service.createStudent();

        }
        System.out.println( "----------------------------");
        service.oldestStudent(students);
        System.out.println( "----------------------------");
        service.youngestStudent(students);
        System.out.println( "----------------------------");
        service.youngestFemaleStudent(students);
    }
}
