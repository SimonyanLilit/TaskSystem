import model.Plane;
import service.AirportService;

public class AirportTest {
    public static void main(String[] args) {
        AirportService service = new AirportService();
        Plane p1 = service.createPlane();


        Plane p2 = service.createPlane();
        Plane p3 = service.createPlane();
        Plane[] planes = {p1, p2, p3};
        service.task1(p1);
        service.task2(p1);
        service.task3(p1, p2);
        service.task4(p1, p2);
        service.task5(p1, p2, p3);
        service.task6(planes);
        service.task7(planes);
        service.task8(planes);
        service.task9(planes);
            service.task10(planes);
    }
}
