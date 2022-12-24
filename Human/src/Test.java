import model.Student;
import model.Teacher;

public class Test {
    public static void main(String[] args) {
        Student student=new Student("Lilit","Simonyan",20,100);
        Teacher teacher=new Teacher("Marine","Chilingaryan",57,40);
        student.printInfo();
        System.out.println("-----------------------");
        teacher.printInfo();

    }


}
