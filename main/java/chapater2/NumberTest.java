package chapater2;

public class NumberTest {
    public static void main(String[] args) {
        NumberTest numberTest = new NumberTest();
        numberTest.test();
    }

    public void test(){
        byte val = 0123;
        System.out.println("8 value " + val);
        byte byteval = 0b1111;
        System.out.println("2 value " + byteval );
        byte val16 = 0x7f;
        int val162 = 0xfff;
        System.out.println("16 val " + val16 + ", another 16 val " + val162);
        int vchar = 'a';
        short v3char = 'o';
        int v2char = 'T';
        System.out.println("a asc is " + vchar + ", T asc is " + v2char+ ", o asc is " + v3char);
    System.out.println("Hello World");


    }
}
