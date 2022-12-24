public class Student {
    private String firstName=" ";
    private String lastName;
    private int year=2022;
    private boolean isArmenian;
    private char gender;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>=1905)
        this.year = year;
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


    public void printInfo(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(year);
        System.out.println(isArmenian? "yes":"no");
        System.out.println(gender=='F'?"Female":"Male");
    }

}
