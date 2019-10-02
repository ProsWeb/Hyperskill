//  For given lines with words, count the number of unique words ignoring case sensitivity.
//  The first line contains the number N - the next N lines contain words separated by a space.

//        Sample Input 1:

//        3
//        Word word wORD
//        line Line SplinE word
//        spline align Java java

//        Sample Output 1:
//        5

import java.util.Arrays;
import java.util.Scanner;

public class CountNumberUniqueWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] data = new String[n][];
        for (int i = 0; i < data.length; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            data[i] = currentLine;
        }
        System.out.println(Arrays.stream(data)
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .distinct()
                .count());
    }
}
