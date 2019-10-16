import java.util.*;

import static java.util.stream.Collectors.*;

public class Order {
//
//    Write a program that reads a text (in the UTF-8) from the standard input.
//    The program must count the frequency of words in the text and print the 10 most frequent words.
//
//    A word is a sequence of characters consisting only of digits of letters.
//    For example, the string "Functions bring happiness!"
//    has three words: "Functions", "brings", "happiness".
//
//    The counting words should be case-insensitive,
//    i.e. "Functions", "functions" and "FUNCTIONS" are the same word. Output words in the lower case.
//
//    If the text has less than 10 unique words, output as many as there are.
//
//    If some words in the text have the same frequency,
//    order them lexicographically as well. For details,
//    see here (https://en.wikipedia.org/wiki/Lexicographical_order).
//
//            The problem has a beautiful solution using streams
//            without any loops and conditional operators. Try to write it.
//
//            Sample Input 1:
//
//            Functions bring happiness!
//
//            Sample Output 1:
//
//            bring
//            functions
//            happiness
    public static void order(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Long> map = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^a-zA-Z0-9]", ""))
                .collect(groupingBy(x -> x, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        map.keySet().forEach(System.out::println);
    }
}
