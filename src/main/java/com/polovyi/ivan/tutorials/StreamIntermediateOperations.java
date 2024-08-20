package com.polovyi.ivan.tutorials;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamIntermediateOperations {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2)
                .filter(i -> i % 2 == 0);

        System.out.println("limit method on infinite stream");
        List<Integer> example1 = Stream.iterate(1, n -> n + 1)
                .limit(3)
                .toList();
        // [1, 2, 3]
        System.out.println("example1 = " + example1);

        System.out.println("limit method on finite stream");
        List<Integer> example2 = Stream.of(1, 2, 3, 4, 5)
                .limit(3)
                .toList();
        // [1, 2, 3]
        System.out.println("example2 = " + example2);

        System.out.println("skip method on stream");
        List<Integer> example3 = Stream.of(1, 2, 3, 4, 5)
                .skip(3)
                .toList();
        // [4, 5]
        System.out.println("example3 = " + example3);

        List<Integer> example4 = Stream.iterate(1, n -> n + 1)
                .skip(1)
                .limit(3)
                .toList();
        // [2, 3, 4]
        System.out.println("example4 = " + example4);

        System.out.println("distinct method on stream");
        List<Integer> example5 = Stream.of(1, 1, 2, 2, 3, 3)
                .distinct()
                .toList();
        // [1, 2, 3]
        System.out.println("example5 = " + example5);

        System.out.println("sort method on stream");
        List<Integer> example6 = Stream.of(2, 3, 5, 4, 1)
                .sorted()
                .toList();
        // [1, 2, 3, 4, 5]
        System.out.println("example6 = " + example6);

        List<Integer> example7 = Stream.of(2, 3, 5, 4, 1)
                .sorted(Comparator.reverseOrder())
                .toList();
        // [5, 4, 3, 2, 1]
        System.out.println("example7 = " + example7);

        System.out.println("unordered method on stream");
        List<Integer> example8 = List.of(2, 3, 5, 4, 1)
                .stream()
                .unordered()
                .parallel() // potentially can lead to better performance
                .toList();
        System.out.println("example8 = " + example8);

        System.out.println("peek method on stream");
        List<Integer> example9 = Stream.of(2, 3, 5, 4, 1)
                //.peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                //.peek(System.out::println)
                .toList();
        // [5, 4, 3, 2, 1]
        System.out.println("example9 = " + example9);

        System.out.println("Filter method on stream");
        List<Integer> example10 = Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .toList();
        // [2, 4]
        System.out.println("example10 = " + example10);

        System.out.println("take while method on stream");
        List<Integer> example11 = Stream.of(1, 2, 3, 4, 5, 1)
                .takeWhile(n -> n < 4)
                .toList();
        // [1, 2, 3]
        System.out.println("example11 = " + example11);

        List<Integer> example12 = Stream.of(4, 1, 2, 3, 4, 5)
                .takeWhile(n -> n < 4)
                .toList();
        // []
        System.out.println("example12 = " + example12);

        List<Integer> example13 = Set.of(1, 2, 3, 4, 5)
                .stream()
                .takeWhile(n -> n < 4)
                .toList();
        // [] -- first run
        // [2, 3] -- second run
        // [1, 2, 3] -- third run
        System.out.println("example13 = " + example13);

        System.out.println("take while method on stream");
        List<Integer> example14 = Stream.of( 1, 2, 3, 4, 5, 1)
                .dropWhile(n -> n < 4)
                .toList();
        // [4, 5, 1]
        System.out.println("example14 = " + example14);

        List<Integer> example15 = Stream.of( 4, 2, 3, 4, 5, 1)
                .dropWhile(n -> n < 4)
                .toList();
        // [4, 2, 3, 4, 5, 1]
        System.out.println("example15 = " + example15);


        List<Integer> example16 = Set.of(1, 2, 3, 4, 5)
                .stream()
                .dropWhile(n -> n < 4)
                .toList();
        // [5, 4] -- first run
        // [5, 4, 3, 2, 1] -- second run
        // [4, 5] -- third run
        System.out.println("example16 = " + example16);

        List<Integer> example17 = Set.of(1, 2, 3, 4, 5)
                .stream()
                .parallel()
                .toList();
        System.out.println("example17 = " + example17);

        List<Integer> example18 = Set.of(1, 2, 3, 4, 5)
                .parallelStream()
                .sequential()
                .toList();
        System.out.println("example18 = " + example18);

    }
}
