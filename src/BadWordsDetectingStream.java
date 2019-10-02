//Create a stream that will detect bad words in a text according to a bad words list.
// All words in the text are divided by whitespaces (always only one whitespace between two words).
//After calling collect(Collectors.toList())
// the stream must return the list of bad words which were found in the text.
// The result should be dictionary ordered (in lexicographical order, i.e. sorted)
// and bad words shouldn't repeat.
//Important. You need return a prepared stream from the template method,
// not a list of bad words. Pay attention to the method template. Do not change it!

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BadWordsDetectingStream {



    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        java.util.function.Predicate<String> badWord = badWords::contains;
        Stream<String> textStream = Arrays.stream(text.split("\\s+"));
        return textStream
                .filter(badWord)
                .distinct()
                .sorted();
    }
}
