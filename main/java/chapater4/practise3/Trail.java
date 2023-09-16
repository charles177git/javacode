package chapater4.practise3;

public class Trail {
    public static void main(String[] args ){
        Trail trail = new Trail();
        trail.test();
    }

    public void test() {
        Taxi cherry = new Taxi("Cherry" , "electricity");
        cherry.book();

        Train fuxinghao = new Train("Fuxinghao", "bullet");
        fuxinghao.service();

        AirPlane airPlane = new AirPlane("C919", "luxury plane");
        airPlane.service();

    }

}
