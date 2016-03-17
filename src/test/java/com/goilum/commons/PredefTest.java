package com.goilum.commons;

import static com.goilum.commons.Predef.mkList;
import static com.goilum.commons.Predef.mkString;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PredefTest {

	@Test
	public void testMkString() {
		List<String> list = mkList("a", "b", "c");

		// Test without start/end
		String s1 = mkString(list, ", ");
		assertEquals(s1, "a, b, c");

		// Test with start/end
		String s2 = mkString(list, "(", ", ", ")");
		assertEquals(s2, "(a, b, c)");

		// Test with sep
		String s3 = mkString(list);
		assertEquals(s3, "abc");

		// Test with Integer
		List<Integer> intList = mkList(1, 3, 2);
		String s4 = mkString(intList, ":");
		assertEquals(s4, "1:3:2");

		// Test with Color
		List<Color> colors = mkList(Color.RED, Color.GREEN, Color.BLUE);
		String s5 = mkString(colors, ";");
		assertEquals(s5, "red;green;blue");
	}

	private enum Color {
		RED, GREEN, BLUE;

		@Override
		public String toString() {
			switch (this) {
			case RED:
				return "red";
			case GREEN:
				return "green";
			case BLUE:
				return "blue";
			default:
				return null;
			}
		}
	}
}
