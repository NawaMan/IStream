package net.nawaman.collection.istream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Extensible stream.
 * 
 * @param <DATA>  the data type.
 */
public interface ExtensibleStream<DATA> extends Stream<DATA> {
    
    public Stream<DATA> stream();
    
    @Override
    public default Iterator<DATA> iterator() {
        return stream().iterator();
    }
    
    @Override
    public default Spliterator<DATA> spliterator() {
        return stream().spliterator();
    }
    
    @Override
    public default boolean isParallel() {
        return stream().isParallel();
    }
    
    @Override
    public default Stream<DATA> sequential() {
        return stream().sequential();
    }
    
    @Override
    public default Stream<DATA> parallel() {
        return stream().parallel();
    }
    
    @Override
    public default Stream<DATA> unordered() {
        return stream().unordered();
    }
    
    @Override
    public default Stream<DATA> onClose(Runnable closeHandler) {
        return stream().onClose(closeHandler);
    }
    
    @Override
    public default void close() {
        stream().close();
    }
    
    @Override
    public default Stream<DATA> filter(Predicate<? super DATA> predicate) {
        return stream().filter(predicate);
    }
    
    @Override
    public default <R> Stream<R> map(Function<? super DATA, ? extends R> mapper) {
        return stream().map(mapper);
    }
    
    @Override
    public default IntStream mapToInt(ToIntFunction<? super DATA> mapper) {
        return stream().mapToInt(mapper);
    }
    
    @Override
    public default LongStream mapToLong(ToLongFunction<? super DATA> mapper) {
        return stream().mapToLong(mapper);
    }
    
    @Override
    public default DoubleStream mapToDouble(ToDoubleFunction<? super DATA> mapper) {
        return stream().mapToDouble(mapper);
    }
    
    @Override
    public default <R> Stream<R> flatMap(Function<? super DATA, ? extends Stream<? extends R>> mapper) {
        return stream().flatMap(mapper);
    }
    
    @Override
    public default IntStream flatMapToInt(Function<? super DATA, ? extends IntStream> mapper) {
        return stream().flatMapToInt(mapper);
    }
    
    @Override
    public default LongStream flatMapToLong(Function<? super DATA, ? extends LongStream> mapper) {
        return stream().flatMapToLong(mapper);
    }
    
    @Override
    public default DoubleStream flatMapToDouble(Function<? super DATA, ? extends DoubleStream> mapper) {
        return stream().flatMapToDouble(mapper);
    }
    
    @Override
    public default Stream<DATA> distinct() {
        return stream().distinct();
    }
    
    @Override
    public default Stream<DATA> sorted() {
        return stream().sorted();
    }
    
    @Override
    public default Stream<DATA> sorted(Comparator<? super DATA> comparator) {
        return stream().sorted(comparator);
    }
    
    @Override
    public default Stream<DATA> peek(Consumer<? super DATA> action) {
        return stream().peek(action);
    }
    
    @Override
    public default Stream<DATA> limit(long maxSize) {
        return stream().limit(maxSize);
    }
    
    @Override
    public default Stream<DATA> skip(long n) {
        return stream().skip(n);
    }
    
    @Override
    public default void forEach(Consumer<? super DATA> action) {
        stream().forEach(action);
    }
    
    @Override
    public default void forEachOrdered(Consumer<? super DATA> action) {
        stream().forEachOrdered(action);
    }
    
    @Override
    public default Object[] toArray() {
        return stream().toArray();
    }
    
    @Override
    public default <A> A[] toArray(IntFunction<A[]> generator) {
        return stream().toArray(generator);
    }
    
    @Override
    public default DATA reduce(DATA identity, BinaryOperator<DATA> accumulator) {
        return stream().reduce(identity, accumulator);
    }
    
    @Override
    public default Optional<DATA> reduce(BinaryOperator<DATA> accumulator) {
        return stream().reduce(accumulator);
    }
    
    @Override
    public default <U> U reduce(U identity, BiFunction<U, ? super DATA, U> accumulator, BinaryOperator<U> combiner) {
        return stream().reduce(identity, accumulator, combiner);
    }
    
    @Override
    public default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super DATA> accumulator,
            BiConsumer<R, R> combiner) {
        return stream().collect(supplier, accumulator, combiner);
    }
    
    @Override
    public default <R, A> R collect(Collector<? super DATA, A, R> collector) {
        return stream().collect(collector);
    }
    
    @Override
    public default Optional<DATA> min(Comparator<? super DATA> comparator) {
        return stream().min(comparator);
    }
    
    @Override
    public default Optional<DATA> max(Comparator<? super DATA> comparator) {
        return stream().max(comparator);
    }
    
    @Override
    public default long count() {
        return stream().count();
    }
    
    @Override
    public default boolean anyMatch(Predicate<? super DATA> predicate) {
        return stream().anyMatch(predicate);
    }
    
    @Override
    public default boolean allMatch(Predicate<? super DATA> predicate) {
        return stream().allMatch(predicate);
    }
    
    @Override
    public default boolean noneMatch(Predicate<? super DATA> predicate) {
        return stream().noneMatch(predicate);
    }
    
    @Override
    public default Optional<DATA> findFirst() {
        return stream().findFirst();
    }
    
    @Override
    public default Optional<DATA> findAny() {
        return stream().findAny();
    }
    
}
