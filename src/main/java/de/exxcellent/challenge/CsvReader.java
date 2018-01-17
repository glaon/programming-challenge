import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The CsvReader holds the function readData to generate a table object from a given cvs-file
 *
 * @author Frithjof Fehsenfeld
 */

public final class CsvReader {
        
    public static Table readData(String cvsFilename) throws IOException {
    
    	// Initiate file from the filename and a buffer to read from
    	File cvsFile = new File(cvsFilename);
    	BufferedReader reader = null;
	    reader = new BufferedReader(new FileReader(cvsFile));
	    
	    // Read first line and generate columns names
	    String line = reader.readLine();
	    String[] columnNames = line.split(",");
	    
	    // Initiate the table with corresponding column names
	    Table weatherTable = new Table(columnNames);
	    
	    // Read the lines and generate an tableEntry for each row
	    while ((line = reader.readLine()) != null) {

	    	String[] stringValues = line.split(",");
	    	float values[] = new float[stringValues.length - 1];
			for(int i = 1; i < values.length; i++) {
				
			    values[i-1] = Float.valueOf(stringValues[i]);
			}
			weatherTable.addEntry(stringValues[0], values);
	    }

		return weatherTable;
    
    }   
}
