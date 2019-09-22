public class ClosestToZero {
    // Given array of ints values. You need to return closest value to zero
    // If will be -5 and 5 return 5
    // and if will be -2 and 3 return -2
    // If arrays is empty return 0

    public static int closestToZero(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int diffToZero = 0 - arr[0];
        int closedToZero = arr[0];

        for (int num : arr) {
            if (Math.abs(num) == Math.abs(closedToZero)) {
                closedToZero = Math.abs(num);
            }
            if (Math.abs((0 - num)) < diffToZero) {
                diffToZero = 0 - num;
                closedToZero = num;
            }
        }
        return closedToZero;
    }
}
