package net.nawaman.istream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import net.nawaman.collection.istream.IStream;

class IStreamTest {
	
	<D> void compare(String expeced, IStream<D> actual) {
		assertEquals(expeced, actual.toList().toString());
	}
	
	@Test
	void testEmpty() {
		compare("[]", IStream.empty());
	}
	
	@Test
	void testFromArray() {
		compare("[A, B, C]", IStream.of      ("A", "B", "C"));
		compare("[A, B, C]", IStream.forArray("A", "B", "C"));
	}
	
	@Test
	void testFromCollection() {
		compare("[A, B, C]", IStream.from         (asList("A", "B", "C")));
		compare("[A, B, C]", IStream.forCollection(asList("A", "B", "C")));
	}
	
	@Test
	void testConcat() {
		compare("[A, B, C, D, E, F]", IStream.of("A", "B", "C").concatWith(Stream.of    ("D", "E", "F")));
		compare("[A, B, C, D, E, F]", IStream.of("A", "B", "C").concatWith(Arrays.asList("D", "E", "F")));
		compare("[A, B, C, D, E, F]", IStream.of("A", "B", "C").concatWith(              "D", "E", "F" ));
	}
	
	@Test
	void testConcatNull() {
		compare("[A, B, C]", IStream.of("A", "B", "C").concatWith((Stream<String>)null));
		compare("[A, B, C]", IStream.of("A", "B", "C").concatWith((List<String>)  null));
		compare("[A, B, C]", IStream.of("A", "B", "C").concatWith((String[])      null));
	}
	
}
