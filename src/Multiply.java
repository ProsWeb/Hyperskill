public class Multiply {
//
//    Remember all these good old photocopiers?
//    Let's try to implement something similar with time-proven
//    Java arrays in a dangerous mix with up to date Java Generics.
//
//    Your task is to create Multiplicator that receives
//    Folders with anything that can be copied (i.e. implementing Copy interface) and creates an array of Folders with copies of the original Folder content. The mix of generics and arrays is not desirable, but sometimes we need to work in such a way (e.g. when interacting with legacy code) and it worth to spend the time to learn how to deal with it.

    class Multiplicator {

        public <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
            Folder<T>[] result = new Folder[arraySize]; //(Folder<T>[]) java.lang.reflect.Array.newInstance(Folder.class, arraySize);
            for (int i = 0; i < result.length; i++) {
                result[i] = new Folder<>();
                result[i].put(folder.get().copy());
            }
            return result;
        }

    }
}
