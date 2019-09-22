//        A multiset is a generalization of the concept of a set.
//        Unlike sets, it can store duplicate elements. The number of instances of an element
//        is the multiplicity.

//        For example,given the following multiset:
//        {a,a,b,b,b,c}
//        The multiplicity of a is 2,the multiplicity of b is 3,the multiplicity of c is 1.
//        If a multiset does not have an element,the multiplicity of it is 0.
//        Write an implementation of the provided generic
//        interface Multiset.The template for your generic
//        class named HashMultiset is given as well.You should implement all methods of the class,
//        according to its interface.You also can add additional methods for helping.
//        Read the given
//
//        interface to understand the common multiset operations (add,remove,union,intersection and so one).
//
//        Do not forget to test your class.If your implementation is not correct,
//        the testing system gives you a hint throwing an exception with a text,like:
//
//        Exception in thread"main"java.lang.AssertionError:size()returned an incorrect result
//        Given a table of integer numbers.You should rotate rows of the table by the specified distance.
//        Try to use collections and standard methods for them.
//        Input data format
//        The first line contains two numbers:a number of rows and a number of columns of the table.
//        The following lines describe rows of the table.In each row,all elements are separated by spaces.
//        The last line consists of one number-the distance for rotating.

//        Output data format
//        Output the resulting table.Separate numbers by a single space in the output.
//
//        Sample Input 1:
//
//        3 3
//        1 1 1
//        2 2 2
//        3 3 3
//        1

//        Sample Output 1:
//
//        3 3 3
//        1 1 1
//        2 2 2

        import java.util.*;

class MultiSet {
    public static void multiSet() {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(scanner.nextInt());
            }
        }
        int rotationDistance = scanner.nextInt() % row * column;
        Collections.rotate(list, rotationDistance);

        int rowNum = 1;
        for (int i = 0; i < row * column; i++) {

            System.out.print(list.get(i) + " ");

            if (i == (column * rowNum) - 1) {
                System.out.println();
                rowNum++;
            }
        }
    }
}
