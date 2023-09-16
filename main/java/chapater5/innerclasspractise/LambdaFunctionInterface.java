package chapater5.innerclasspractise;

interface Todo {
    public void dosomething();
}
public class LambdaFunctionInterface {
    public void todo(Todo todo) {
        todo.dosomething();
    }
    public static void main(String[] args) {
        LambdaFunctionInterface lambdaFunctionInterface = new LambdaFunctionInterface();
//        using anonymous inner class.
        lambdaFunctionInterface.todo(new Todo() {
            public void dosomething() {
                System.out.println("I am doing something");
            }
        });
        //using Lambda function interface expression
        lambdaFunctionInterface.todo(() -> System.out.println("I will do something today"));
        //another way to use Lambda interface expression.
        Todo todo = () -> System.out.println("I will do something tonight");
        todo.dosomething();
    }
}
