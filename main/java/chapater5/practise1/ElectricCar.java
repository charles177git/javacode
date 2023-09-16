package chapater5.practise1;

public class ElectricCar extends Vehicle{
    public ElectricCar(int wheel, String steering, String energy)
    {
        super(wheel,steering, energy);
    }
    protected void drive() {
        int wheel = this.getWheel();
        String steering = this.getSteering();
        String energy = this.getEnergy();

        System.out.println("I am electricity car, I have " + wheel +  " wheels, I have a lovely " +  steering + " steering, I use " + energy + " rather than traditional petrol as energy " );
    }
}
