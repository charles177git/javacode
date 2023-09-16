package chapater4.practise3;

public class AirPlane extends Transport{
    private String type;
    public AirPlane(String name) {
        super(name);
    }

    public AirPlane(String name, String type) {
        super(name);
        this.type = type;
    }

    public void service() {
        this.setSpeed(900);
        System.out.println("Thank you to choose " + this.getName() + ", " + type + ", I am providing your the fastest speed "  + this.getSpeed() + " km/hour in your journey");
    }

}
