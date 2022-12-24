import java.util.Scanner;

public class AirportService extends Plane{


    public Plane createPlane(){
        Scanner scanner=new Scanner(System.in);
        Plane Plane = new Plane();
        System.out.println("Enter Name:");
        Plane.setName(scanner.next());
        System.out.println("Enter release date:");
        Plane.setRelDate(scanner.nextInt());
        System.out.println("Enter hours spent in air:");
        Plane.setHour(scanner.nextInt());
        System.out.println("Enter yes if the plane is military:");
       String mil= scanner.next();
       Plane.setMilitary("yes".equals(mil));
        return Plane;
    }
    //task 1
    public void printNameAndDate(Plane p){
        System.out.print(p.getName()+" "+p.getRelDate());

    }
    //task 2
    public void printNameOrHours(Plane p1){
        if(p1.getRelDate()>2000)
            System.out.println(p1.getName());
        else System.out.println(p1.getHour());
    }
    // task 3
    public String spendsMoreHours(Plane p1, Plane p2){
        if(p1.getHour()>p2.getHour())
            return p1.getName();
        else {
            return p2.getName();
        }

    }
    //task 4
    public Plane biggerPlane(Plane p1,Plane p2)
    {
       return p1.getName().length()>p2.getName().length()?  p1: p2;
    }
    // task 5
    public void listOfPlanes(Plane[] planeArr){
        for (int i = 0; i < planeArr.length; i++)
            planeArr[i].printInfo();
    }
    // task 6
    public void militaryAndAfter2010(Plane[] planes){
        for (Plane i:
             planes) {
            if(i.getRelDate()>2010&&i.isMilitary())
                i.printInfo();
        }
    }
    //task 7
    public Plane maxTimeInAir(Plane[] planes){
        int maxIndex=0;
        for (int i=1,max=planes[0].getHour();i< planes.length;i++)
            if(planes[i].getHour()>max) {
                max = planes[i].getHour(); maxIndex=i;
            }
        return planes[maxIndex];
    }
    //task 8
    public void oldestPlain(Plane[] planes){
        int oldIndex=0;
        for (int i=1,oldest=planes[0].getRelDate();i< planes.length;i++)
            if(planes[i].getRelDate()<oldest) {
                oldest= planes[i].getRelDate(); oldIndex=i;
            }
        planes[oldIndex].printInfo();
    }
    //task 9
    public void newestOfMilitary(Plane[] planes){
        int newIndex = 0;
        int newest = 0;
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].isMilitary()){
                newest=planes[i].getRelDate();
            newIndex=i;
            break;}
        }
        for (int i=newIndex+1;i< planes.length;i++)
            if(planes[i].isMilitary()&&planes[i].getRelDate()>newest) {
                newest= planes[i].getRelDate(); newIndex=i;
            }

        planes[newIndex].printInfo();

    }
    // task 10
    public void sort(Plane[] planes){
        boolean isSwitching=true;
        int countOfFors=0;
        while(isSwitching){
            isSwitching=false;
            for (int i = 0; i < planes.length-countOfFors-1 ; i++) {
                if(planes[i].getRelDate()>planes[i+1].getRelDate()){
                    int temp=planes[i].getRelDate();
                    planes[i].setRelDate(planes[i+1].getRelDate());
                    planes[i+1].setRelDate(temp);

                }
                isSwitching=true;
            }
            countOfFors++;
        }
        listOfPlanes(planes);
    }
}
