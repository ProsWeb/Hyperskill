//
//You are asked to create quality control system in a company that produces and packs Bakery.
//        Implement check method in a way it would:
//
//        Return true if all objects in all boxes belong to class Bakery
//        or its subclasses or list contains no boxes
//        Return false otherwise, including cases when Box is empty
//        or List contains something that is not Box at all
//        The method shouldn't throw any exceptions.

import java.util.List;

class QualityControl {
    public static<T> boolean check(List<T> items) {
        if (items == null) {
            return false;
        }
        if (items.isEmpty()) {
            return true;
        }
        for (T b : items) {
            if (b == null) {
                return false;
            }
            if (!(b instanceof Box)
                    || !(((Box) b).get() instanceof Bakery)) {
                return false;
            }
        }
        return true;
        //    return items.stream()
        //            .noneMatch(b -> (!(b instanceof Box))
        //                    || !(((Box) b).get() instanceof Bakery));
    }
}
