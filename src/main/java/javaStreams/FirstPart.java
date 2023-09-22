package javaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstPart {

    public static void main(String[] args) {

        int count = 0;

        List<String> names = new ArrayList<>();

        names.add("Oleg");
        names.add("Dmitriy");
        names.add("Maria");
        names.add("Zhenya");
        names.add("Daniil");
        names.add("Maxim");
        names.add("Darya");


        for (int i = 0; i < names.size(); i++){

            String str = names.get(i);

            if (str.startsWith("D")){
                count++;
            }
        }
        //System.out.println(count);


        List<String> names2 = new ArrayList<>();

        names2.add("Oleg");
        names2.add("Dmitriy");
        names2.add("Maria");
        names2.add("Zhenya");
        names2.add("Daniil");
        names2.add("Maxim");
        names2.add("Darya");

        Long s = names2.stream().filter(c->c.startsWith("D")).count();

        //names2.stream().filter(c->c.length()>5).forEach(c-> System.out.println(c));
        //names2.stream().filter(c->c.length()>5).limit(1).forEach(c-> System.out.println(c));

        /*
        Stream.of("Oleg", "Dmitriy", "Maria", "Zhenya", "Daniil", "Maxim", "Darya", "Alexandra").
                filter(c->c.endsWith("a")).map(c->c.toUpperCase()).forEach(c-> System.out.println(c));
         */

        Stream.of("Oleg", "Dmitriy", "Maria", "Zhenya", "Daniil", "Maxim", "Darya", "Alexandra")
                .filter(c->c.startsWith("A")).sorted().forEach(c-> System.out.println(c));

    }
}
