package lists_sets;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class ListsSetsDemo {
	public static void main (String[] args) {
		
		List<String> myList = new ArrayList<String>();
		
		myList.add("Brenton");
		myList.add("Bob");
		myList.add("Mark");
		myList.add(2, "Chris"); // Adds element at index 2 (3rd position)
		myList.add("Ted");
		myList.add("Ted"); // Adds duplicate value
		myList.remove(1); // Removes element at index 1 (2nd position)
		
		System.out.println(myList);
		
		Set<Integer> mySet = new HashSet<Integer>();
		
		mySet.add(11579);
		mySet.add(21612);
		mySet.add(21612); // Duplicate value ignored (original duplicate value replaced with new duplicate)
		mySet.add(56981);
		mySet.remove(11579);
		
		System.out.println(mySet);
	}
}
