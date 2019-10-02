//  For a given array, output the maximum of absolute values in the array.
//  Try not to use the for loop, but use Stream API.
//  Use .getAsInt() to convert from OptionalInt (returned by .max() ) to int.

//        Sample Input 1:
//        1 4 7 -2 -5

//        Sample Output 1:
//        7

//        Sample Input 2:
//        1 4 7 -2 -8

//        Sample Output 2:
//        8

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class MaxArrayStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        OptionalInt max = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .max();

        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        } else {
            System.out.println("-1");
        }
    }
}
