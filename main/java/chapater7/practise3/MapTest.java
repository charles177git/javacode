package chapater7.practise3;

import java.util.*;

public class MapTest {
    private char[] chars;
    private Map<String, Integer> map;
    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.test();
    }
    protected void test() {
        chars = new char[] {'a', 'b' , 'a' ,'b' ,'c', 'a','b', 'c', 'b'};
        map = new HashMap<String, Integer>();
        Set<String> set = new HashSet<>();
        System.out.println(Arrays.toString(chars));
        for (int i=0; i < chars.length; i++) {
            String value = String.valueOf(chars[i]);
            set = map.keySet();
            if (!set.contains(value)) {
                map.put(value, 1);
            } else {
                int count = map.get(value);
                map.put(value, ++count);
            }
        }
        map.forEach((key,val) -> System.out.println("key = " + key + ", value = " + val));
    }

}
