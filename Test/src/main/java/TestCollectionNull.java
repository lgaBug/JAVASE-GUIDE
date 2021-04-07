import java.util.*;

public class TestCollectionNull {


    public static void main(String[] args) {


        String[] strs = {"a","abc","b"};
        final String s = Arrays.stream(strs).filter(str -> str.length() > 3).findFirst().orElse("");
        System.out.println("s = " + s);


    }
}
