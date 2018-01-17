import java.util.LinkedList;

/**
 * This class represents a table. A table consists of columnNames, 
 * and a list of entries. 
 *
 * @author Frithjof Fehsenfeld
 */

public class Table {

	String[] columnNames;
	LinkedList<Entry> entries;

	public Table(String[] columnNames) {
		this.columnNames = columnNames;
		this.entries = new LinkedList<Entry>();	
	}
	
	// This function adds a new Entry to the table
	public void addEntry(String key, float[] values) {
		
		if (values.length + 1 == this.columnNames.length) {
			this.entries.add(new Entry(key, values));
		}
	}
	
	// This function looks up the number of the column based on the columnName
	public int getIndexByColumnname(String columnName) {
		
		for (int i = 0; i < this.columnNames.length - 1; i++) {
			if(this.columnNames[i].equals(columnName)) {
				return i - 1; // subtract 1 to ignore the name / key column
			}
		}
		return -1; // In case columnName was not found, return -1 (rather than an exception) 
	}
}








