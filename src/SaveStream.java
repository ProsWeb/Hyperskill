//Sometimes after mapping and filtering a stream, you need to use it more than one time.
// For example, find the maximum and count all the elements of a resulted sequence.
//
//        You need to implement a method that solves this problem.
//        The method should save the stream and create a supplier,
//        that can return this stream over and over again.
//
//        For example, this code should output 4, 8, 2 on separate lines:
//
//        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
//        Supplier<Stream<Integer>> saved = saveStream(stream.filter(e -> e % 2 == 0));
//
//        System.out.println(saved.get().count());
//        System.out.println(saved.get().max(Integer::compareTo).get());
//        System.out.println(saved.get().min(Integer::compareTo).get());
//        Sample Input 1:
//
//        1 2 3 4 5 6 7 8
//        Sample Output 1:
//
//        4
//        8
//        2

import java.util.function.*;
import java.util.stream.*;

class SaveStream {

    public static <T> Supplier<Stream<T>> saveStream(Stream<T> stream){
        T[] items = (T[]) stream.toArray();
        return () -> Stream.of(items);

        //        ArrayList list = new ArrayList<>();
        //        stream.forEach(list::add);
        //        return list::stream;
    }

}
