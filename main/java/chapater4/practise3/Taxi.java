package chapater4.practise3;

public class Taxi extends Transport{
    private String name;
    private String type;
    private double speed;
    public Taxi(String name) {
        super(name);
    }
    
    public Taxi(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void book() {
        this.setSpecific("Easy to book and take your anywhere you want");
        System.out.println(this.getSpecific());
        System.out.println("You book " + name + ", " + type +" car, and give you a nice and comfortable service");
    }
}
