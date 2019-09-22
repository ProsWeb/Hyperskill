import java.util.*;

public class TwoBoxes {

//    There are two boxes on the table. The first box has a size of X1 x Y1 x Z1, and the second box has a size of X2 x Y2 x Z2. You need to determine which box can be put inside another box. You can rotate both boxes as you want.
//
//    Input contains two lines.
//    The first line contains numbers X1, Y1, Z1, the second line contains numbers X2, Y2, Z2. All numbers are integers and greater than 0.
//
//    If the sizes of the boxes are equal, output "Box 1 = Box 2".
//    If the first box can be put inside the second box, output "Box 1 < Box 2".
//    If the second box can be put inside the first box, output "Box 1 > Box 2".
//    If none of the boxes can be put inside the other box, output "Incomparable".
//    Sample Input 1:
//
//            1 1 1
//            2 2 2
//    Sample Output 1:
//
//    Box 1 < Box 2
//    Sample Input 2:
//
//            2 2 2
//            1 2 2
//    Sample Output 2:
//
//    Box 1 > Box 2
//    Sample Input 3:
//
//            1 2 3
//            2 3 1
//    Sample Output 3:
//
//    Box 1 = Box 2
//    Sample Input 4:
//
//            2 3 4
//            1 3 5
//    Sample Output 4:
//
//    Incomparable


    public static void twoBoxes() {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();

        int cube1 = x1 * y1 * z1;
        int cube2 = x2 * y2 * z2;

        int[] arr1 = {x1, y1, z1};
        int[] arr2 = {x2, y2, z2};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (cube1 < cube2) {
            if (arr1[arr1.length - 1] <= arr2[arr2.length - 1] &&
                    arr1[1] <= arr2[1] &&
                    arr1[0] <= arr2[0]) {
                System.out.print("Box 1 < Box 2");
            } else {
                System.out.print("Incomparable");
            }
        } else if (cube1 > cube2) {
            if (arr1[arr1.length - 1] >= arr2[arr2.length - 1]
                    && arr1[1] >= arr2[1]
                    && arr1[0] >= arr2[0]) {
                System.out.print("Box 1 > Box 2");
            } else {
                System.out.print("Incomparable");
            }
        } else {
            System.out.print("Box 1 = Box 2");
        }
    }
}
