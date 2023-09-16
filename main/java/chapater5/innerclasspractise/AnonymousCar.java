package chapater5.innerclasspractise;

abstract class Car{
    private int wheels;
    private String steering;
    private String carbreak;
    public Car() {

    }
    public Car(int wheels, String steering, String carbreak) {
        this.steering = steering;
        this.wheels = wheels;
        this.carbreak = carbreak;
    }

    public void description() {
        System.out.println("This car has " + wheels + " wheels, has " + steering + " steering");
    }
    public String getCarbreak() {
        return this.carbreak;
    }
    abstract void engine();
}
public class AnonymousCar {
    public void purseCar(Car car) {
        car.description();
        car.engine();
    }

    public static void main(String[] args) {
        AnonymousCar anonymousCar = new AnonymousCar();
        anonymousCar.purseCar(new Car(4, "Rectangle cute", "autobreak") {
            private String engine;

            public void engine() {
                this.engine = "Electricity Power";
                System.out.println("The car use " + this.engine+" output 2000N force");
            }

            @Override
            public void description() {
                super.description();
                System.out.println("also has " + this.getCarbreak() + " system");
            }
        });

        Car commonCar = new Car() {
            private String engine;
            {
                System.out.println("This is block code for initialize class");
            }
            @Override
            void engine() {
                this.engine = "mechanical engine";
                System.out.println("The car is a common car with " + this.engine);
            }
            public void description() {
                System.out.println("This car has 4 wheels, has round steering");
            }
        };

        anonymousCar.purseCar(commonCar);
    }
}
