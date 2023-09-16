package chapater5.innerclasspractise;

interface LoopArray {
    public void loop(int[] arr);
}
public class LambdaExample {
    public void process(int arr[], LoopArray loopArray) {
        loopArray.loop(arr);
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,4,10,3};
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.process(arr, new LoopArray() {
            @Override
            public void loop(int[] arr) {
                int sum = 0;
                for (int value : arr) {
                    sum += value;
                }
                System.out.println("Summary is " + sum);
            }
        });
    }
}
