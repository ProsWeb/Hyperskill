import java.util.Scanner;

public class SumDigits {
//    Given a three-digit integer (i.e. an integer from 100 to 999). Find the sum of its digits.
////    Sample Input 1:
////            476
//    Sample Output 1:
////            17
    public static void sumDigits() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int first = num / 100;
        int mid = (num / 10) % 10;
        int last = num % 10;

        int sum = first + mid + last;

        System.out.print(sum);
    }
}
