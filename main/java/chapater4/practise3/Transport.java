package chapater4.practise3;

public class Transport {
    private String name;
    private String type;
    private double speed;
    private String feature;

    public Transport() {

    }
    public Transport(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    protected void setType(String type) {
        this.type = type;
    }
    protected String getType() {
        return this.type;
    }
    protected void introduce() {
        System.out.println("I am parent class for all the transport class");
    }

    protected double getSpeed() {
        return this.speed ;
    }

    protected void setSpeed(double speed) {
        this.speed = speed;
    }

    protected void setSpecific(String feature) {
        this.feature = feature;
    }

    protected String getSpecific() {
        return this.feature;
    }

}
