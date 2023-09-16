package chapater5.practise3;

interface TodoList {
    public void todo();
}
public class FunctionInterface {
    public static void main(String[] args) {
        FunctionInterface functionInterface = new FunctionInterface();
        TodoList todoList = () -> System.out.println("I will do something in my job list");
        todoList.todo();
    }
}
