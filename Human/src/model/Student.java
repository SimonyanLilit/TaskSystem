package model;

public class Student extends Human{
    private int mark;

    public Student(String firstName, String lastName, int age, int mark) {
        super(firstName, lastName, age);
        this.mark = mark;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(mark);
    }
}
