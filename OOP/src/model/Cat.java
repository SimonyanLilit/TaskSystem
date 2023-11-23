package model;

public class Cat {
    private String breed;
    private String color;
    private double weight;
    private boolean isPet;
    private int age;
    private char gender;

    public Cat(String breed, String color, double weight, boolean isPet, int age, char gender) {
        this.breed = breed;
        this.color = color;
        this.weight = weight;
        this.isPet = isPet;
        this.age = age;
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isPet() {
        return isPet;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public void printInfo() {
        System.out.println(breed);
        System.out.println(color);
        System.out.println(weight);
        System.out.println(isPet ? "yes" : "no");
        System.out.println(age);
        System.out.println(gender == 'Q' ? "Queen" : "Tom");
    }
}