import java.util.*;

public class Sudoku {
//  N-size sudoku is a game with a square table of N2 width
//  and height divided into N2 smaller squares of N width and height.
//  In a solved state, each of this smaller squares, as well as each row and column of a full square,
//  contains all numbers from 1 to N2 without repetition.
//  Given a number N on the first line and a full sudoku table on the next N2 lines.
//  Every line contains N2 integers.
//  Your task is to determine whether this sudoku is solved or not.
//  Output "YES" if this sudoku table is solved, otherwise "NO".
//  N can be from 1 to 10.

    public static void sudoku() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[][] bigSquare = new String[N * N][N * N];

        for (int i = 0; i < bigSquare.length; i++) {
            bigSquare[i] = scanner.nextLine().split("\\s+");
        }

        int[][] transArray = new int[N * N][N * N];

        for (int i = 0; i < transArray.length; i++) {
            for (int j = 0; j < transArray[i].length; j++) {
                transArray[i][j] = Integer.parseInt(bigSquare[j][i]);
            }
        }

        for (int i = 0; i < bigSquare.length; i++) {
            if (!solved(transArray[i], N)) {
                System.out.print("NO");
                return;
            }
        }

        int[][] copyArray = new int[N * N][N * N];

        for (int i = 0; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray[i].length; j++) {
                copyArray[i][j] = Integer.parseInt(bigSquare[i][j]);
            }
        }

        for (int i = 0; i < bigSquare.length; i++) {
            if (!solved(copyArray[i], N)) {
                System.out.print("NO");
                return;
            }
        }

        int[] smallSquare = new int[N * N];
        int count = 0;

        int i = 0;
        for (int j = 0; j < bigSquare[i].length;) {
            smallSquare[count] = Integer.parseInt(bigSquare[i][j]);
            count++;
            j++;
            if (count == N * N) {
                if (!solved(smallSquare, N)) {
                    System.out.print("NO");
                    return;
                } else {
                    count = 0;
                    smallSquare = new int[N * N];
                    if (i == bigSquare.length - 1 && j != bigSquare.length - 1) {
                        i = 0;
                    } else if (i == bigSquare.length - 1 && j == bigSquare[i].length - 1) {
                        System.out.print("YES");
                        return;
                    } else {
                        i++;
                        j = j - N;
                    }
                }
            } else if (count > 0 &&
                    count % N == 0) {
                i++;
                j = j - N;
            }
        }
        System.out.print("YES");
    }

    private static boolean solved(int[] smallSquare, int maxValue) {
        Arrays.sort(smallSquare);
        System.out.println(Arrays.toString(smallSquare));
        if (smallSquare.length == 1 && smallSquare[0] > maxValue * maxValue) {
            return false;
        }

        for (int i = 0; i < smallSquare.length - 1; i++) {
            int currentNum = smallSquare[i];
            int nextNum = smallSquare[i + 1];
            if (currentNum == nextNum ||
                    currentNum > (maxValue * maxValue) ||
                    nextNum > (maxValue * maxValue)) {
                return false;
            }
        }
        return true;
    }
}