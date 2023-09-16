package chapater5.practise1;

public class TestVehicle {
    public static void main(String[] args) {
        TestVehicle testVehicle = new TestVehicle();
        testVehicle.test();

    }

    public void test() {
        Tractor tractor = new Tractor(2, "steel brown color" , "petrol");
        tractor.drive();

        Truck truck = new Truck(8, "big black round", "diesel" );
        truck.drive();

        ElectricCar ecar = new ElectricCar(4, "cute rectangle", "battery");
        ecar.drive();
    }
}
