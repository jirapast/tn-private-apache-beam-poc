import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        // ArrayList<String> x = new ArrayList<String>();
        // x.add("a");
        // x.add("b");
        // System.out.println(x);
        // String[] x = {"1","2"};
        // String y[] = new String[] {"1","2"};
        // System.out.println(y[0]);
        // Integer x[] = new Integer[] {1,2,3,4};
        // List<Integer> list = Arrays.asList(x);
        // System.out.println(x);
        // System.out.println(x[0]);
        // System.out.println(list);
        // System.out.println(list.get(0));
        // String x[] = new String[] {"aaa bbb ccc", "eee rrr ttt"};
        String x = "asdf asdf  asdf";
        System.out.println(Arrays.asList(x.split(" ")[0]));
    }
}
