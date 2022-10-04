package com.example.studentdata.utils;

import com.example.studentdata.utils.interfaces.TriConsumer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionalConsumer<T> {

    Optional<T> optional;

    public static <T> OptionalConsumer<T> of(T value) {
        return Objects.nonNull(value)
                ? new OptionalConsumer<>(Optional.of(value))
                : OptionalConsumer.empty();
    }

    public static <T> OptionalConsumer<T> of(Optional<T> optional) {
        return new OptionalConsumer<>(optional);
    }

    public static <R> OptionalConsumer<R> of(Supplier<R> supplier) {
        R value = supplier.get();
        return OptionalConsumer.of(value);
    }

    public static <T> OptionalConsumer<T> empty() {
        return new OptionalConsumer<>(Optional.empty());
    }

    public T get() {
        return optional.orElse(null);
    }

    public <K> OptionalConsumer<K> map(Function<T, K> mapper) {
        return optional.isPresent()
                ? optional.map(mapper).map(OptionalConsumer::of).orElseGet(OptionalConsumer::empty)
                : OptionalConsumer.empty();
    }

    public <K> OptionalConsumer<K> mapOr(Function<T, K> mapper, K reserve) {
        return optional.isPresent()
                ? optional.map(mapper).map(OptionalConsumer::of).orElse(OptionalConsumer.of(reserve))
                : OptionalConsumer.empty();
    }

    public <K> OptionalConsumer<T> setProperty(BiConsumer<T, K> setter, K value) {
        return optional.isPresent()
                ? optional.map(FunctionalUtils.setProperty(setter, value)).map(OptionalConsumer::of)
                .orElseGet(OptionalConsumer::empty)
                : this;
    }

    public <K> OptionalConsumer<T> setProperty(BiConsumer<T, K> setter, Function<T, K> function) {
        return optional.isPresent()
                ? optional.map(FunctionalUtils.setProperty(setter, function)).map(OptionalConsumer::of)
                .orElseGet(OptionalConsumer::empty)
                : this;
    }

    public OptionalConsumer<T> filter(Predicate<T> predicate) {
        return optional.isPresent()
                ? optional.filter(predicate).map(OptionalConsumer::of).orElseGet(OptionalConsumer::empty)
                : this;
    }

    public OptionalConsumer<T> filterOrElseThrow(Predicate<T> predicate, Supplier<? extends RuntimeException> ex) {
        return optional.isPresent()
                ? optional.filter(predicate).map(OptionalConsumer::of).orElseThrow(ex)
                : this;
    }

    public void andThen(Supplier<? extends RuntimeException> ex) {
        throw ex.get();
    }

    public OptionalConsumer<T> andThen(Consumer<T> consumer) {
        optional.ifPresent(consumer);
        return this;
    }

    public <K> OptionalConsumer<T> andThen(BiConsumer<T, K> consumer, K arg) {
        optional.ifPresent(val -> consumer.accept(val, arg));
        return this;
    }

    public <K, V> OptionalConsumer<T> andThen(BiConsumer<K, V> consumer, Function<? super T, ? extends K> getter, V arg) {
        optional.map(getter).ifPresent(val -> consumer.accept(val, arg));
        return this;
    }

    public <K> OptionalConsumer<T> andThen(Consumer<K> consumer, Function<? super T, ? extends K> getter) {
        optional.ifPresent(val -> consumer.accept(getter.apply(val)));
        return this;
    }

    public OptionalConsumer<T> log(TriConsumer<String, T, Object> logger, String msg, Object... args) {
        optional.ifPresent(val -> logger.accept(msg, val, args));
        return this;
    }

    public <K> OptionalConsumer<T> log(TriConsumer<String, Object, Object> logger, String msg, Function<? super T, Object> getter, Object... args) {
        optional.ifPresent(val -> logger.accept(msg, getter.apply(val), args));
        return this;
    }

    public <K> OptionalConsumer<K> extractOptional(Class<? super K> clazz) {
        return optional.map(opt -> (Optional<K>) opt)
                .map(OptionalConsumer::of)
                .orElse(OptionalConsumer.empty());
    }

    public T orElse(T value) {
        return optional.orElse(value);
    }

    public T orElseThrow(Supplier<? extends RuntimeException> ex) {
        if (optional.isPresent()) {
            return this.get();
        } else {
            throw ex.get();
        }
    }

}
