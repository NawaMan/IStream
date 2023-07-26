package net.nawaman.istream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import net.nawaman.collection.istream.IStream;

class ExtensibleStreamTest {
	
	IStream<String> stream = IStream.of("A", "B", "C");
	
	<D> void compare(String expeced, Stream<D> actual) {
		assertEquals(expeced, actual.collect(toList()).toString());
	}
	
	@Test
	void testCount() {
		assertEquals(3, stream.count());
	}
	
	@Test
	void testIterator() {
		List<String> list = new ArrayList<>();
		for (String string : (Iterable<String>)stream::iterator) {
			list.add(string);
		}
		assertEquals("[A, B, C]", list.toString());
	}
	
	@Test
	void testDistinct() {
		compare("[A, B, C, A]", stream.concatWith("A"));
		compare("[A, B, C]",    stream.concatWith("A").distinct());
	}
	
	@Test
	void testSorted() {
		compare("[A, B, C, A]", stream.concatWith("A"));
		compare("[A, A, B, C]", stream.concatWith("A").sorted());
	}
	
	@Test
	void testLimitLong() {
		compare("[A, B]", stream.limit(2));
	}
	
	@Test
	void testSkipLong() {
		compare("[B, C]", stream.skip(1));
	}
	
	@Test
	void testToArray() {
		assertEquals("[A, B, C]", Arrays.toString(stream.toArray()));
	}
	
	@Test
	void testToArrayIntFunctionOfA() {
		assertEquals("[A, B, C]", Arrays.toString(stream.toArray(String[]::new)));
	}
	
	@Test
	void testReduceDATABinaryOperatorOfDATA() {
		assertEquals(">+A+B+C", stream.reduce(">", (a, b) -> a + "+" + b));
	}
	
	@Test
	void testReduceBinaryOperatorOfDATA() {
		assertEquals("Optional[A+B+C]", stream.reduce((a, b) -> a + "+" + b).toString());
	}
	
	@Test
	void testFindFirst() {
		assertEquals("A", stream.findFirst().get());
	}
	
	@Test
	void testFindAny() {
		assertEquals("A", stream.findAny().get());
	}
	
}
