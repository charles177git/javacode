package chapater3;


import java.util.Arrays;

public class Circle {
    final private int lines = 11;
    final private float radium = 16f;
    final private double pi = 3.1415926;
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.test();
    }

    /**
     * when observe that return and new line key equals 3 starts.
     * so think the circle is about 33 * 33 rectangle.
      */

    public void test(){
//      for test cos(angle)
//        System.out.println(Math.sin(0.5235));
//        System.out.println(Math.cos(1.047));

        float[] angle = new float[]{58.0f, 41.0f, 27.0f, 14.3f};
        float[] hudu = new float[]{0, 0, 0, 0};
        int leftPosition =0;
        int rightPosition = 0 ;
        int dimension = 0;
        char[] var_1 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_2 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_3 = Arrays.copyOf(var_2, var_2.length);
        char[] var_4 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_5 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_6 = new char[]{'*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*'};
        char[] var_7 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_8 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_9 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] var_10 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};

        char[] var_11 = Arrays.copyOf(var_1, var_1.length);

        for (int i = 0; i<4; i++) {
            hudu[i] = (float)Math.cos(angle[i]/360*2*pi)*radium;
            dimension = Math.round(hudu[i]);
            rightPosition = 16 - 1 + dimension;
            leftPosition = 16 - 1 - dimension;

            switch (i) {
                case 0:
                    //right array position
                    var_2[leftPosition] = '*';
                    var_2[rightPosition] = '*';

                    var_10[leftPosition] = '*';
                    var_10[rightPosition] = '*';
                    break;
                case 1:
                    var_3[leftPosition] = '*';
                    var_3[rightPosition] = '*';
                    var_9[leftPosition] = '*';
                    var_9[rightPosition] = '*';

                    break;
                case 2:
                    var_4[leftPosition] = '*';
                    var_4[rightPosition] = '*';
                    var_8[leftPosition] = '*';
                    var_8[rightPosition] = '*';

                    break;

                case 3:
                    if (leftPosition <=0) {
                        leftPosition = 0;
                    }
                    //31 is the biggest dimension.
                    if (rightPosition >= 31) {
                        rightPosition = 31;
                    }
                    var_5[leftPosition] = '*';
                    var_5[rightPosition] = '*';
                    var_7[leftPosition] = '*';
                    var_7[rightPosition] = '*';
                    break;
            }
        }
        char[][]vars = new char[][] {var_1, var_2, var_3, var_4, var_5, var_6, var_7, var_8, var_9, var_10, var_11};

        //finally to print out all the stars.
        for (int j=0; j < lines; j++) {
            for (int k=0; k< var_1.length; k++) {
                System.out.print(vars[j][k]);
            }
            System.out.println();
        }


    }

}
