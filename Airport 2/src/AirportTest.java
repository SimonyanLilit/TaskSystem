
public class AirportTest {
    public static void main(String[] args) {
AirportService airport = new AirportService();
Plane plane=airport.createPlane();
      // plane.printInfo();
      //  System.out.println();
      // airport.printNameAndDate(plane);
        //System.out.println();
      // airport.printNameOrHours(plane);
       // System.out.println();
       Plane plane2 =airport.createPlane();
      // plane2.printInfo();
      //  System.out.println();
        // System.out.println(airport.spendsMoreHours(plane,plane2));
       Plane plane3=airport.createPlane();
       Plane[] planeArray={plane,plane2,plane3};
       airport.sort(planeArray);
    }
}
