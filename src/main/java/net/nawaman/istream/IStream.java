package net.nawaman.istream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The stream type that we will be using in this module.
 * 
 * @param <DATA>  the data type of the stream.
 */
public interface IStream<DATA> extends ExtensibleStream<DATA> {
	
	public static <D> IStream<D> empty() {
		return forArray();
	}
	
	@SafeVarargs
	public static <D> IStream<D> of(D... values) {
		return (IStream<D>)(() -> Stream.of(values));
	}
	
	public static <D> IStream<D> from(Collection<D> values) {
		return (IStream<D>)(() -> values.stream());
	}
	
	@SafeVarargs
	public static <D> IStream<D> forArray(D... values) {
		return (IStream<D>)(() -> Stream.of(values));
	}
	
	public static <D> IStream<D> forCollection(Collection<D> values) {
		return (IStream<D>)(() -> values.stream());
	}
	
	public default List<DATA> toList() {
		return collect(Collectors.toList());
	}
	
	public default IStream<DATA> concatWith(Stream<DATA> tail) {
		if (tail == null) {
			return this;
		}
		
		return (IStream<DATA>)(() -> Stream.concat(this, tail));
	}
	
	@SuppressWarnings("unchecked")
	public default IStream<DATA> concatWith(DATA ... tails) {
		if (tails == null) {
			return this;
		}
		
		return (IStream<DATA>)(() -> Stream.concat(this, Stream.of(tails)));
	}
	
	public default IStream<DATA> concatWith(Collection<DATA> tail) {
		if (tail == null) {
			return this;
		}
		
		return (IStream<DATA>)(() -> Stream.concat(this, tail.stream()));
	}
	
}
