package chapater5.practise1;

public class Tractor extends Vehicle {
    public Tractor(int wheel, String steering, String energy) {
        super(wheel, steering, energy);
    }

    @Override
    protected void drive() {
        int wheel = this.getWheel();
        System.out.println("I am tractor, I have " + wheel + " wheels, I use " + this.getEnergy() + " as my energy, I have "+ this.getSteering() + " steering to drive my tractor");
    }

}
