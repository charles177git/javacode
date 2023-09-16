package chapater4.practise3;

public class Train extends Transport {
    private String name;
    private String type;
    private double speed;
    public Train(String name) {
        super(name);
    }

    public Train(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void service() {
        this.setSpeed(300);
        System.out.println("Thank you to choose " + this.name + ", " + this.type + " train service, we run accurate time and you can enjoy a good view");
        this.setSpecific("I run accurate and am running very fast at "+ this.getSpeed() + " km/hour");
        System.out.println(this.getSpecific());
    }
}

