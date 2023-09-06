package chapater3;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.test();
    }

    public void test() {
        char var_1[] = {' ', ' ', ' ', '*', ' ', ' ', ' '};
        char var_2[] = {' ', ' ', '*', '*', '*', ' ', ' '};
        char var_3[] = {' ', '*', '*', '*', '*', '*', ' '};
        char var_4[] = {'*', '*', '*', '*', '*', '*', '*'};

        char[][] vars = {var_1, var_2, var_3, var_4};
        for (int i = 0; i < vars.length; i++) {
            for (int j = 0; j < vars[i].length; j++) {
                System.out.print(vars[i][j]);
            }
            System.out.println();
        }
    }

}
