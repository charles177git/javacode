package chapater6.practise2;

public class TruncateString {
    public static void main(String[] args) {
        TruncateString truncateString = new TruncateString();
        truncateString.test();
    }

    public void test() {
        String source = "ABCDEFG";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.insert(0, source);
        int index = stringBuffer.indexOf("CD");
        if (index >= 0) {
            String stake = stringBuffer.substring(index, index + 2);
            System.out.println(stake);
            System.out.println(stringBuffer.toString());
        }
        if (stringBuffer.indexOf("B") != -1) {
            String stakeb = stringBuffer.substring(stringBuffer.indexOf("B"), stringBuffer.indexOf("B") + 1);
            System.out.println(stakeb);
        }
        if (stringBuffer.indexOf("F") != -1) {
            String stakef = stringBuffer.substring(stringBuffer.indexOf("F"), stringBuffer.indexOf("F") + 1);
            System.out.println(stakef);
            System.out.println(stringBuffer.toString());

        }

    }


}
