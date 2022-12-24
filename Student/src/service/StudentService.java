package service;

import model.Student;

import java.util.Scanner;

public class StudentService {
    public Student createStudent() {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();

        System.out.println("Input info of student  ");
        System.out.println("Enter firstname:");
        student.setFirstName(scanner.next());
        System.out.println("Enter lastname:");
        student.setLastName(scanner.next());
        System.out.println("Enter age:");
        student.setAge(scanner.nextInt());
        System.out.println("Enter nationality:");
        student.setArmenian(scanner.next().equals("yes"));
        System.out.println("Enter gender:");
        student.setGender(scanner.next().charAt(0));
        System.out.println("Enter mark:");
        student.setMark(scanner.nextDouble());
        System.out.println();
        return student;

    }

    public void oldestStudent(Student[] students) {
        Student oldest = students[0];

        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i];

            }

        }
        oldest.printInfo();
    }


    public void youngestStudent(Student[] students) {
        Student youngest = students[0];

        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() < youngest.getAge()) {
                youngest = students[i];

            }

        }
        youngest.printInfo();
    }

    public void youngestFemaleStudent(Student[] students) {
      /*  boolean isFemale = false;
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            isFemale = students[i].getGender() == 'F';
            if (isFemale) {
                index = i;
                break;
            }
        }

        if (isFemale) {
            int youngest = students[index].getAge();
            for (int i = index + 1; i < students.length; i++) {
                if (students[i].getGender() == 'F' && students[i].getAge() < youngest) {
                    youngest = students[i].getAge();
                    index = i;
                }


            }
            students[index].printInfo();
        } else System.out.println("No  female students");*/


        Student youngest = null;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGender() == 'F' && (youngest == null || students[i].getAge() < youngest.getAge()))
                youngest = students[i];
        }
        if (youngest == null)
            System.out.println("No  female students");
        else youngest.printInfo();

    }

}

//for classes service classes             super is human