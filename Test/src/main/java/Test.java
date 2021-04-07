import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {


    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {


            String val = iterator.next();
            iterator.remove();
            System.out.println(val);
        }


    }
}
