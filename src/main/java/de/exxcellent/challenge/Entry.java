import java.util.Comparator;
import java.lang.Math;

/**
 * This class Entry represents a row in a Table.  
 * Each entry holds a key (basically a name or id) 
 * and a list of float values.
 * 
 * @author Frithjof Fehsenfeld
 *
 */

public class Entry{
	
	float[] values;
	String key;
	
	public Entry(String key, float[] values){

		this.key = key;
		this.values = values;
	}
	
	public String toString() {		
		return key;
	}
}


// A Comparator for the class Entry
// It calculates the difference between two values in each Entry and compares these to each other. 
class SortByDiff implements Comparator<Entry> {

	int indexPlus;
	int indexMinus;
	
	
	// Creates an instance of the Comparator. 
	public SortByDiff(int indexPlus, int indexMinus) {
		this.indexPlus = indexPlus;
		this.indexMinus = indexMinus;
	}
	
	// Compares two Entry based on the indexes that are used
	public int compare(Entry entryA, Entry entryB) {
		
		// Calculate values of both entries
		float diffA = Math.abs(entryA.values[indexPlus] - entryA.values[indexMinus]);
		float diffB = Math.abs(entryB.values[indexPlus] - entryB.values[indexMinus]);
		
		if (diffA > diffB) {
			return 1;
		} else if ( diffA < diffB ) {
			return -1;
		} else {
			return 0;
		}
	}
}

