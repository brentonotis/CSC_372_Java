package maps;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Program utilizes a map to map names to colors
 * Example of HashMap implementation
 */

public class HashMapExample {
	
	// Driver
	public static void main (String[] args) {
		Map<String, Color> favoriteColors = new HashMap<String, Color>();
		favoriteColors.put("Brenton", Color.GREEN);
		favoriteColors.put("Kaylen", Color.GREEN);
		favoriteColors.put("Moxie", Color.ORANGE);
		favoriteColors.put("Yogi", Color.BLUE);
		
		// Print all key/values in the map
		Set<String> keySet = favoriteColors.keySet();
		for (String key : keySet) {
			Color value = favoriteColors.get(key);
			System.out.println(key + " : " + value);
		}
	}
}
