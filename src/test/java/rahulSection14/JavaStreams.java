package rahulSection14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    @Test
    void practice() {

        List<String> names = new ArrayList<>();

        names.add("Van");
        names.add("Billy");
        names.add("Biolannte");
        names.add("Kazua");
        names.add("Bogdan");

        Long count = names.stream().filter(c -> c.startsWith("B")).count();
        //System.out.println(count);

        //names.stream().sorted().forEach(c-> System.out.println(c));

        /*
        Stream.of("Van", "Billy", "Biolannte", "Kazua", "Bogdan").
                map(c->c.toUpperCase()).sorted().forEach(c-> System.out.println(c));
         */

        /*
        Stream.of("Van", "Billy", "Biolannte", "Kazua", "Bogdan").
                filter(c->c.startsWith("B")).limit(3).map(c->c.toUpperCase()).forEach(c-> System.out.println(c));

         */

        String[] arr = {"Gobzavr", "VjLink", "AnshaAbdul"};

        List<String> arrList = Arrays.asList(arr);

        //arrList.stream().filter(c->c.length() > 5).sorted().forEach(c-> System.out.println(c));

        Stream<String> streamList = Stream.concat(names.stream(), arrList.stream()).sorted();

        Boolean flag = streamList.anyMatch(s -> s.equalsIgnoreCase("Van"));

        //System.out.println(flag);

    }
        @Test
        @Ignore
        void collect(){

           List<String> convertion = Stream.of("Van", "Billy", "Biolannte", "Kazua", "Bogdan").
                    filter(c->c.startsWith("B")).limit(3).map(c->c.toUpperCase()).sorted().collect(Collectors.toList());

           convertion.add("LIST");

            System.out.println(convertion);

        }

        @Test
        void compile(){

        Integer[] array = {0, 1, 0, 2, 1, 0, 4, 4, 3, 1, 5};

        List<Integer> arrList = Arrays.asList(array);

        List<Integer> disctinctList = arrList.stream().sorted().distinct().collect(Collectors.toList());

            System.out.println(disctinctList);
            System.out.println(disctinctList.get(2));

        }

    }

