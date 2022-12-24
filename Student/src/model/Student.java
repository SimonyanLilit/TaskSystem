package model;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isArmenian;
    private char gender;
    private double mark;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public boolean isArmenian() {

        return isArmenian;
    }

    public void setArmenian(boolean armenian) {
        isArmenian = armenian;
    }

    public char getGender() {

        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=15&&age<=100)
        this.age = age;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void printInfo(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(age);
        System.out.println(isArmenian? "yes":"no");
        System.out.println(gender=='F'?"Female":"Male");
        System.out.println(mark);
    }

}


