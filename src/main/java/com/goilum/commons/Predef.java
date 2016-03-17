package com.goilum.commons;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * A set of simple common methods. The implementation was based on Scala
 * {@code Predef} class.
 * <p/>
 * The methods should be statically imported to improve readability.
 * <p/>
 * Example:
 * 
 * <pre>
 * <code>
 * {@code
 * import static com.goilum.commons.Predef.*;
 *
 * import java.util.List;
 * 
 * public class Test {
 *     public static String myTest() {
 *         List<String> l = mkList("a", "b", "c");
 *         return mkString(l);
 *     }
 *
 *     public static void main(String[] args) {
 *         println(Test.myTest());
 *     }
 * }
 * </code>
 * </pre>
 */
public class Predef {

	/**
	 * Returns a fixed size list.
	 * <p/>
	 * Example:
	 * 
	 * <pre>
	 * <code>
	 * {@code List<String> list = mkList("a", "b", "c");}
	 * </code>
	 * </pre>
	 * 
	 * @param elems
	 *            the elements of the list.
	 * @return a fixed size list.
	 */
	@SafeVarargs
	public static <E> List<E> mkList(E... elems) {
		return Arrays.asList(elems);
	}

	/**
	 * Displays all elements of a collection as a string.
	 * <p/>
	 * Example:
	 * 
	 * <pre>
	 * <code>
	 * {@code
	 * List<String> list = mkList("a", "b", "c");
	 * String str = mkString(list, "(", ", ", ")");
	 * // str = "(a, b, c)"
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param collection
	 *            the collection.
	 * @param start
	 *            the starting string.
	 * @param sep
	 *            the separator string.
	 * @param end
	 *            the end string.
	 * @return a string representation of the collection.
	 */
	public static <E> String mkString(Collection<E> collection, String start, String sep, String end) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;

		sb.append(start);
		for (E elem : collection) {
			if (first) {
				sb.append(elem);
				first = false;
			} else {
				sb.append(sep);
				sb.append(elem);
			}
		}
		sb.append(end);

		return sb.toString();
	}

	/**
	 * Displays all elements of a collection as a string.
	 * <p/>
	 * Example:
	 * 
	 * <pre>
	 * <code>
	 * {@code
	 * List<String> list = mkList("a", "b", "c");
	 * String str = mkString(list, ", ");
	 * // str = "a, b, c"
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param collection
	 *            the collection
	 * @param sep
	 *            the separator
	 * @return a string representation of the collection.
	 */
	public static <E> String mkString(Collection<E> collection, String sep) {
		return mkString(collection, "", sep, "");
	}

	/**
	 * Displays all elements of a collection as a string.
	 *
	 * <pre>
	 * <code>
	 * {@code
	 * List<String> list = mkList("a", "b", "c");
	 * String str = mkString(list);
	 * // str = "abc"
	 * }
	 * </code>
	 * </pre>
	 * 
	 * @param collection
	 *            the collection
	 * @return a string representation of the collection.
	 */
	public static <E> String mkString(Collection<E> collection) {
		return mkString(collection, "", "", "");
	}

	/**
	 * Tests an expression, throwing {@link IllegalArgumentException} if false.
	 * 
	 * @param requirement
	 *            the expression to test
	 * @param message
	 *            the message to show in case of failure.
	 */
	public static void requires(boolean requirement, String message) {
		if (!requirement)
			throw new IllegalArgumentException("requirement failed: " + message);
	}

	/**
	 * Tests an expression, throwing {@link IllegalArgumentException} if false.
	 * 
	 * @param requirement
	 *            the message to show in case of failure.
	 */
	public static void requires(boolean requirement) {
		if (!requirement)
			throw new IllegalArgumentException("requirement failed");
	}

	/**
	 * Prints a string and terminates the line.
	 * 
	 * @param s
	 *            the string to be printed.
	 */
	public static void println(String s) {
		System.out.println(s);
	}

	/**
	 * Prints a string.
	 * 
	 * @param s
	 *            the string to be printed.
	 */
	public static void print(String s) {
		System.out.print(s);
	}
}
