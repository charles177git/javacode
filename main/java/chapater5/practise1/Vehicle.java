package chapater5.practise1;

public abstract class Vehicle {
    private int wheel;
    private String steering;
    private String energy;
    protected abstract void drive();

    public Vehicle(int wheel, String steering, String energy) {
        this.wheel = wheel;
        this.steering = steering;
        this.energy = energy;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public int getWheel() {
        return this.wheel;
    }

    public String getSteering() {
        return this.steering;
    }

    public String getEnergy() {
        return this.energy;
    }


}
