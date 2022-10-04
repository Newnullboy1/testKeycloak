package com.example.studentdata.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;
import java.util.function.Function;

@Slf4j
@UtilityClass
public class FunctionalUtils {

    public <T, K> Function<T, T> setProperty(BiConsumer<T, K> setter, K value) {
        return t -> {
            setter.accept(t, value);
            return t;
        };
    }

    public <T, K> Function<T, T> setProperty(BiConsumer<T, K> setter, Function<T, K> function) {
        return t -> {
            setter.accept(t, function.apply(t));
            return t;
        };
    }

}
