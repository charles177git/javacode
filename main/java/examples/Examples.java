package examples;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
        System.out.println("Hello Examples");
        Examples examples = new Examples();
        examples.test();
    }

    public void test(){
        List<String> courses = new ArrayList<String>();
        courses.add("math");
        courses.add("english");
        for (String course: courses ) {
            System.out.println(course);
        }
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("math", 90.9);
        map.put("english",60.2);

        Set<String> set = map.keySet();
        for(String key : set) {
            System.out.println("key " + key + ", value " + map.get(key));
        }

        map.forEach((key, value) -> System.out.println(key + "->" + value));
    }

}
