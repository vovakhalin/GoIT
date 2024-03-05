package Module11;


import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import java.util.Iterator;


public class Demo {
    public static void main(String[] args) {
        // Завдання 1
        List<String> names = Arrays.asList("Ivan", "Igor", "Sasha", "Vova", "Olga", "Kolya", "Wera");

        List<String> filteredNames = IntStream.range(1, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> (i) + ". " + names.get(i))
                .collect(Collectors.toList());

        System.out.println(filteredNames);

        // Завдання 2
        List<String> sortedNames = names.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

        System.out.println(sortedNames);

        // Завдання 3
        String[] numbers = {"1, 2, 0", "4, 5", "3"};

        String stringToNumber = Arrays.stream(numbers)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(stringToNumber);

        // Завдання 4
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        Stream<Long> randomStream = generateRandom(a, c, m, 42L);

        randomStream.limit(10).forEach(System.out::println);

        // Завдання 5
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> second = Stream.of(6, 7, 8, 9, 10, 11);

        Stream<Integer> zippedStream = zip(first, second);
        zippedStream.forEach(System.out::println);
        }
    // Метод до Завдання 4
    public static Stream<Long> generateRandom(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
    // Метод до Завдання 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();

        Builder<T> builder = Stream.builder();
        first.forEachOrdered(item -> {
            if (secondIterator.hasNext()) {
                builder.accept(item);
                builder.accept(secondIterator.next());
            }
        });

        return builder.build();
    }

}
