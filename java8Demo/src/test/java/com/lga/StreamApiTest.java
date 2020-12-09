package com.lga;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {

    @Test
    public void test() {
        List<String> players = Arrays.asList("kobe", "james", "carr", "cbyt");
        players.stream()
                .filter(u -> u.startsWith("c"))
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList()).forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void test2() {
        String[] palyers = {"kobe", "james", "carra", "cbytb"};
        Set<String> set = new HashSet<>(Arrays.asList(palyers));
        Stream.of(palyers).filter(u -> u.length() > 4).collect(Collectors.toList()).forEach(u -> System.out.println(u));
    }

    @Test
    public void test3() {
        List<String> players = Arrays.asList("kobe1", "jam33es", "car123213r", "cb11adssyt");
        players.stream()
                .mapToInt(String::length)
                .toArray();

    }

    @Test
    public void test4() {
        List<String> words = Arrays.asList("hello", "word");
        words.stream()
                .flatMap(e->Stream.of(e.split("")))
                .forEach(System.out::println);

        words.sort(String.CASE_INSENSITIVE_ORDER);

    }
}
