//
//You need to implement method getComparatorType(Class) in ComparatorInspector class. The method should examine provided class and return Type object that corresponds to the type parameter that parameterizes Comparable interface the class implements
//        The method should:
//
//        Return type parameter for Comparable interface class implements
//        Return null if Comparable interface does not have type parameter
//        Should not produce compile-time warnings
//        Additional requirements:﻿
//
//        Compile-time error should arise if class not implementing Comparable is provided as input value
//        No 'rawtype' warnings should remain or be suppressed
//        Method getComparatorType should be generic
//        You are free to correct method's type signature if needed.

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Class to work with
 */
class ComparatorInspector {

    /**
     * Return Type variable that corresponds to the type parameterizing Comparator.
     *
     * @param clazz {@link Class} object, should be non null
     * @return {@link Type} object or null if Comparable does not have type parameter
     */
    public static <T extends Comparable<?>> Type getComparatorType(Class<T> clazz) {
        return Stream.of(clazz.getGenericInterfaces())
                .filter(ParameterizedType.class::isInstance)
                .map(type -> (ParameterizedType) type)
                .filter(type -> type.getRawType().getTypeName().equals(
                        Comparable.class.getCanonicalName()))
                .flatMap(type -> Arrays.asList(type.getActualTypeArguments()).stream())
                .findFirst()
                .orElse(null);
    }

}