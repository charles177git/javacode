package chapater5.innerclasspractise;

public class LambdaExample3 implements  Runnable {
    public static void main(String[] args) {
        LambdaExample3 example3 = new LambdaExample3();
        Runnable r = () -> {
            for (int j=0 ; j <10; j++) {
                System.out.println("10");
            }
        };
    }

    @Override
    public void run() {

    }
}
