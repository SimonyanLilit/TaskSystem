package service;

import model.Plane;

import java.util.Scanner;

public class AirportService {
    public Plane createPlane(){
       Plane plane=new Plane();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter model");
        plane.setModel(scanner.next());
        System.out.println("enter country");
        plane.setCountry(scanner.next());
        System.out.println("enter year");
        plane.setYear(scanner.nextInt());
        System.out.println("enter hours");
        plane.setHours(scanner.nextInt());
        System.out.println("Is military?");
        plane.setMilitary(scanner.nextBoolean());
        System.out.println("enter weight");
        plane.setWeight(scanner.nextDouble());
        System.out.println("enter wingspan");
        plane.setWingspan(scanner.nextInt());
        System.out.println("enter top speed");
        plane.setTopSpeed(scanner.nextInt());
        System.out.println("enter seats");
        plane.setSeats(scanner.nextInt());
        System.out.println("enter coast");
        plane.setCoast(scanner.nextDouble());
        return plane;
    }
    public void task1(Plane p){
        System.out.println("model is "+ p.getModel());
        System.out.println("country is "+p.getCountry());
        System.out.println("year is "+p.getYear());
        System.out.println("hours are"+p.getHours());
        System.out.println(" is military "+ p.isMilitary());
        System.out.println("weight is "+p.getWeight());
        System.out.println("wingspan is "+ p.getWingspan());
        System.out.println("top speed is "+ p.getTopSpeed());
        System.out.println("seats are"+ p.getSeats());
        System.out.println("coast is "+p.getCoast());
    }
public void  task2(Plane p){
        if (p.isMilitary()){
            System.out.println("coast is "+p.getCoast());
            System.out.println("top speed is "+ p.getTopSpeed());
        }else{
            System.out.println("model is "+ p.getModel());
            System.out.println("country is "+p.getCountry());
        }
}
    public Plane task3(Plane p1, Plane p2)
    {
        if(p1.getYear()<=p2.getYear())
            return p1;
        else return p2;
    }
    public String task4(Plane p1, Plane p2){
        if(p1.getWingspan()>p2.getWingspan())
            return p1.getModel();
        else return p2.getModel();
    }
    public void task5(Plane p1, Plane p2, Plane p3)
    {
        Plane smallest=p1;

            if(p2.getSeats()<smallest.getSeats())
                smallest=p2;
            if(p3.getSeats()<smallest.getSeats())
                smallest=p3;
        System.out.println(smallest.getCountry());

    }
    public void task6(Plane[] planes){
        for (int i = 0; i < planes.length; i++) {
          if(!planes[i].isMilitary()) {
              task1(planes[i]);
          }
        }
    }
    public void task7(Plane[] planes){
        for (int i = 0; i < planes.length; i++) {
            if(planes[i].isMilitary()&&planes[i].getHours()>100)
                task1(planes[i]);
        }
    }
    public  Plane task8(Plane[] planes){
        Plane min=planes[0];
        for (int i = 1; i < planes.length; i++) {
            if(planes[i].getWeight()<=min.getWeight())
                min=planes[i];


        }return  min;
    }
    public  Plane task9(Plane[] planes){
        Plane min=null;
        for (int i = 0; i < planes.length; i++) {
            if(planes[i].isMilitary()&&(min==null||planes[i].getCoast()< min.getCoast()))
                min=planes[i];

        }return min;
    }
    public void task10(Plane[] planes){
        Plane temp=null;
        for (int i = 0; i < planes.length; i++) {
            for (int j = 0; j < planes.length-i; j++) {
                if(planes[j+1].getYear()<planes[j].getYear())
                    planes[j]=temp;
                planes[j]=planes[j+1];
                planes[j+1]=temp;


            }

        }
        for (int i = 0; i < planes.length; i++) {
          task1(planes[i]);
        }
    }
}
