package com.example.studentdata.utils.interfaces;

@FunctionalInterface
public interface TriConsumer<T, K, V> {

    void accept(T t, K k, V v);

}
