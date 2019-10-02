//  For a given array, output the sorted array of absolute values.
//  You should sort the array in the ascending order.
//  Try not to use the for loop, but use Stream API.

//        Sample Input 1:
//        1 2 6 -3 -9

//        Sample Output 1:
//        1 2 3 6 9

import java.util.*;
import java.util.stream.*;

public class SortedArrayStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        List<Integer> list = Arrays.stream(values)
                .map(Integer::parseInt)
                .map(Math::abs)
                .sorted()
                .collect(Collectors.toList());

        list.forEach(n -> System.out.print(n + " "));
    }
}
