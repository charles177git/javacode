package chapater5.innerclasspractise;

public interface Motherboard {
    int ports = 5;
    String brand = "Lenovo";
    public void soundcard();
    public void displaycard();
    default void introduce () {
        System.out.println("I am Lenovo mother board");
    }
    static int getPorts() {
        return ports;
    }
    //if static class method, must have body.
    static String getBoardName() {
        return brand;
    };

}
