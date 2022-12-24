package model;

public class Plane {
   private String model;
   private String country;
   private int year;
   private int hours;
   private boolean isMilitary;
   private double weight;
   private int wingspan;
   private int topSpeed;
   private int seats;
   private double coast;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>=1903&&year<=2021)
        this.year = year;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {
        isMilitary = military;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight>=10000&&weight<=160000)
        this.weight = weight;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        if (wingspan>=10&&wingspan<=45)
        this.wingspan = wingspan;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if(topSpeed>=0)
        this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats>=0)
        this.seats = seats;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public double getHours() {

        return hours;
    }

    public void setHours(int hours) {
        if(hours>=0&&hours<=10000)
        this.hours = hours;
    }

}
