package com.my.fitness.converters;

import com.my.fitness.enums.LoadOptions;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter interface
 */
public interface Converter<SOURCE, RESULT> {

    /**
     * Convert a source object to a result object
     * @param source Source object
     * @param options Load options
     * @return Result object
     */
    RESULT convert(SOURCE source, LoadOptions... options);

    /**
     * Fill a result object from a source object
     * @param source Source object
     * @param result Result object
     * @param options Load options
     */
    void fillIn(SOURCE source, RESULT result, LoadOptions... options);

    /**
     * Convert source object to result objects
     * @param sources Source objects
     * @param options Load options
     * @return Result objects
     */
    default List<RESULT> convertAll(List<SOURCE> sources, LoadOptions... options) {
        List<RESULT> results = new ArrayList<>(sources.size());
        for (int i = 0; i < sources.size(); i++) {
            results.add(convert(sources.get(i), options));
        }
        return results;
    }

    /**
     * Fill all result objects from source objects
     * @param sources Source objects
     * @param results Result objects
     * @param options Load options
     */
    default void fillInAll(List<SOURCE> sources, List<RESULT> results, LoadOptions... options) {
        for (int i = 0; i < sources.size(); i++) {
            fillIn(sources.get(i), results.get(i), options);
        }
    }
}
