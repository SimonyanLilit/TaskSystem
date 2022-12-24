package model;

public class Teacher extends Human {

    private  double experience;

    public Teacher(String firstName, String lastName, int age, double experience) {
        super(firstName, lastName, age);
        this.experience=experience;

    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(experience);
    }
}
