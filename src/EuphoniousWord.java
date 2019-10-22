//All the letters of the English alphabet are divided into vowels and consonants.
//        The vowels are: a, e, i, o, u, y.
//        The remaining letters are consonants.
//
//        A word is considered euphonious if it has not three or more vowels or consonants in a row. Otherwise, it is considered discordant.
//
//        Your task is to create euphonious words from discordant. You can insert any letters inside word. You should output the minimum number of characters needed to create a euphonious word from a given word.
//
//        For example, word "schedule" is considered discordant because it has three consonants in a row - "sch". To create a euphonious word you need to add any vowel between 's' and 'c' or between 'c' and 'h'.
//
//        Sample Input 1:
//
//        schedule
//        Sample Output 1:
//
//        1
//        Sample Input 2:
//
//        garage
//        Sample Output 2:
//
//        0
//        Sample Input 3:
//
//        player
//        Sample Output 3:
//
//        1
//        Sample Input 4:
//
//        biiiiig
//        Sample Output 4:
//
//        2

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EuphoniousWord {
    public static void main(String[] args) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int countVowelsInARow = 0;
        int countConsonantsInARow = 0;

        int numberOfLettersToAdd = 0;

        for (int i = 0; i < word.length(); i++) {
            boolean isCurrentLetterVowel = vowels.contains(word.charAt(i));
            if (isCurrentLetterVowel) {
                countVowelsInARow++;
                countConsonantsInARow = 0;
            }
            if (!isCurrentLetterVowel) {
                countConsonantsInARow++;
                countVowelsInARow = 0;
            }
            if (countVowelsInARow == 3) {
                numberOfLettersToAdd++;
                countVowelsInARow = 0;
                i--;
            }
            if (countConsonantsInARow == 3) {
                numberOfLettersToAdd++;
                countConsonantsInARow = 0;
                i--;
            }
        }
        System.out.println(numberOfLettersToAdd);
    }
}
