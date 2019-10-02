//Create a supplier that return integer values from 0 to infinity.
//        After first get() invocation supplier must return 0. After second - 1, next - 2, 3 etc.
//
//        So this code should print "0 1 2 3 4 ":
//        Supplier<Integer> sup = getInfiniteRange();
//        for(int i = 0; i < 5; i++) {
//        System.out.print(sup.get() + " ");
//        }
//
//        Also it should be possible to use separate suppliers simultaneously.
//        For example, this code should print "0 0 1 1 2 2 3 3 4 4 ":
//        Supplier<Integer> sup1 = getInfiniteRange();
//        Supplier<Integer> sup2 = getInfiniteRange();
//
//        for(int i = 0; i < 5; i++) {
//        System.out.print(sup1.get() + " " + sup2.get() + " ");
//        }
//
//        Sample Input 1:
//
//        5
//        Sample Output 1:
//
//        0 1 2 3 4
//        0 0 1 1 2 2 3 3 4 4

import java.util.function.*;
import java.util.stream.IntStream;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return IntStream.iterate(0, i -> i + 1).iterator()::next;
    }

//    public static Supplier<Integer> getInfiniteRange() {
//        return new Supplier<>() {
//            private int i = 0;
//
//            @Override
//            public Integer get() {
//                return i++;
//            }
//        };
//    }
}

