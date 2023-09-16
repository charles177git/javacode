package chapater5.innerclasspractise;
interface LoopArray2 {
    public void loop(int[] arr);
}
//use Lambda expression.
public class LambdaExample2 {
    public void process(int arr[], LoopArray2 loopArray) {
        loopArray.loop(arr);
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,4,10,3};
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.process(arr, (int[] target) ->{
            int sum =0;
            for (int tmp : target) {
                sum += tmp;
            }
            System.out.println("summary is " + sum);
        });
    }
}
