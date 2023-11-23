package service;

import model.Cat;

import java.util.Scanner;

public class CatService {
    public Cat CreateCat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter breed");
        String breed = scanner.next();
        System.out.println("enter color");
        String color = scanner.next();
        System.out.println("enter weight");
        double weight = scanner.nextDouble();
        System.out.println("is Pet?");
        boolean isPet = scanner.next().equals("yes");
        System.out.println("enter age");
        int age = scanner.nextInt();
        System.out.println("enter gender Queen/Tom");
        char gender = scanner.next().charAt(0);


        return new Cat(breed, color, weight, isPet, age, gender);
    }

    public void oldestCat(Cat[] cats) {
        Cat oldest = cats[0];

        for (int i = 1; i < cats.length; i++) {
            if (cats[i].getAge() > oldest.getAge()) {
                oldest = cats[i];
            }

        }
        oldest.printInfo();
    }

    public void youngestCat(Cat[] cats) {
        Cat youngest = cats[0];

        for (int i = 1; i < cats.length; i++) {
            if (cats[i].getAge() < youngest.getAge()) {
                youngest = cats[i];
            }

        }
        youngest.printInfo();
    }

    public void heaviestCat(Cat[] cats) {
        Cat heaviest = cats[0];

        for (int i = 1; i < cats.length; i++) {
            if (cats[i].getWeight() > heaviest.getWeight()) {
                heaviest = cats[i];
            }

        }
        heaviest.printInfo();
    }

    public void litestCat(Cat[] cats) {
        Cat litest = cats[0];

        for (int i = 1; i < cats.length; i++) {
            if (cats[i].getWeight() < litest.getWeight()) {
                litest = cats[i];
            }

        }
        litest.printInfo();
    }

    public void youngestPet(Cat[] cats) {
        Cat min = null;
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isPet() && (min == null || cats[i].getAge() < min.getAge()))
                min = cats[i];

        }
        if (min == null)
            System.out.println("No youngest pet");
        else min.printInfo();
    }
}