package chapater5.innerclasspractise;

import javax.swing.plaf.synth.SynthMenuBarUI;

interface Eatable{
    void taste();
}
interface Flyable {
    void fly(String weather);
}
interface Addable {
    int add(int ab, int bc);
}

public class LambdaQs {
    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }

    public void fly(Flyable f) {
        System.out.println("I am driving " + f);
        f.fly("Bright warm weather ");
    }
    public void add(Addable addable) {
        System.out.println( " 4 + 5 = " + addable.add(4,5));
    }

    public static  void main(String[] args) {
        LambdaQs lambdaQs = new LambdaQs();
        lambdaQs.eat(
                () -> System.out.println("I am eating too much"));

        lambdaQs.fly((String weather) -> System.out.println("I am flying in the " + weather));
        //remove the parameter parentheses
        lambdaQs.fly(weather -> System.out.println("I am flying again in the " + weather));
        lambdaQs.add((int a, int b) -> a + b);

    }
}
