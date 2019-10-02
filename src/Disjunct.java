import java.util.List;
import java.util.function.IntPredicate;

class Disjunct {
    //Write the disjunctAll method that accepts a list of IntPredicate's and returns a single IntPredicate.
// The result predicate is a disjunction of all input predicates.
// If the input list is empty then the result predicate should return false for any integer value
// (always false).
// Important. Pay attention to the provided method template. Do not change it.

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        return predicates
                .stream()
                .reduce(predicates.get(0), IntPredicate::or);

        // IntPredicate res = predicates.get(0);
        //     for (int i = 1; i < predicates.size(); i++){
        //         res = res.or(predicates.get(i));
        //     }
        //     return res;

    }
}

