import java.util.Scanner;

public class LuckyNum {
//    Given the number N with an even number of digits. If the sum of the first half of the digits equals the sum of the second half of the digits, then this number is considered lucky. For a given number, output "YES" if this number is lucky, otherwise output "NO".
//    Sample Input 1:
//
//            12344321
//    Sample Output 1:
//
//    YES
//    Sample Input 2:
//
//            125322
//    Sample Output 2:
//
//    NO

    public static void luckyNum() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);

        int leftSum = sum(left);
        int rightSum = sum(right);

        System.out.print(leftSum == rightSum ? "YES" : "NO");
    }

    private static int sum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }
}
