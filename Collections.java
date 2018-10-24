package collections_demo;

import java.util.Collection;
import java.util.ArrayList;
import java.util.TreeSet;

/*
 * Demonstrates classes from the Java collections framework
 */

public class Collections {

		public static void main (String[] args) {
			System.out.println("Working with an ArrayList");
			workWith(new ArrayList<String>());
			System.out.println("Working with a TreeSet");
			workWith(new TreeSet<String>());
		}
		
		/**
		 * Examples of how to work with a collection of strings
		 * @param coll - collection from the Java collections framework
		 */
		public static void workWith(Collection<String> coll) {
			coll.add("Bob");
			coll.add("Nick");
			coll.add("Fred");
			coll.add("Sam");
			coll.add("Bob");
			System.out.println(coll);
			System.out.print("Removing Bob and Tom: ");
			System.out.print(coll.remove("Bob") + " ");
			System.out.println(coll.remove("Tom"));
			System.out.print("Looking for Bob and Nick: ");
			System.out.print(coll.contains("Bob") + " ");
			System.out.println(coll.contains("Nick"));
			for (String s : coll) {
				System.out.println(s);
			}
		}
}
