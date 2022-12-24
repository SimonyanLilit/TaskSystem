package model;

public class Human {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public void printInfo(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(age);

    }

}
