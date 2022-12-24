import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[3 ];
        for (int i = 0; i < students.length; i++) {
            students[i]=new Student();
            System.out.println("Input info of student number " + (i+1) );
            System.out.println("Enter firstname:");
            students[i].setFirstName(scanner.next());
            System.out.println("Enter lastname:");
            students[i].setLastName(scanner.next());
            System.out.println("Enter year:");
            students[i].setYear(scanner.nextInt());
            System.out.println("Enter isArmenian:");
            students[i].setArmenian(scanner.nextBoolean());
            System.out.println("Enter gender:");
            students[i].setGender(scanner.next().charAt(0));
            System.out.println();


        }
      for (int i = 0; i < students.length; i++) {
            students[i].printInfo();
            System.out.println("*************************");
        }
    }//3st
  //  task 1 oldest st info
    //2  youngest female st array of students f(st array)
    //case 1 if youngest male
           // case 2 no female

    //task 3 the youngest
}//in service f func pub void f
