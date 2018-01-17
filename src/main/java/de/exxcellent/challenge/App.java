import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class provides a solution to the weather-challenge from Exxcellent solutions. It solves the two stated problems:
 * 1. Find the day with the minimal gap between maximum and minimum temperature in a given cvs-file
 * 2. Find the football team with the minimal gap between scored and allowed goals in a csv-file
 * 
 * The approach in both cases is to read the cvs-file via the CvsReader-Class and to generate a fully populated Table
 * (via the Table-Class). The CvsReader could easily be replaced by another Reader; the usage of an abstract class / 
 * an interface may be useful in that case.
 * The Table itself is based on Entries (see Entry-Class). By defining a Comparator-Class, the problem is a search 
 * for the minimal Entry.
 * 
 * The use of the fully populated table is just for the sake of increasing complexity for myself 
 * as handling more than the two needed columns was not necessary. Still, it allows the usage of more 
 * complex Comparators (e. g., building the football table  * with unsorted data) or further data manipulation.
 * 
 * Other acknowledgements:
 * - My last experience in Java dates back to 2009. Since then I've only used Fortran or Python
 * - I've never done test driven programming.
 * - I've used git only rarely.
 * 
 * @author Frithjof Fehsenfeld
 */
public final class App {

    public static void main (String[] args) {
    	
    	// ------------------ Weather Challenge ------------------
    	String filenameWeather = "weather.csv";
    	
		try{
			// Create the table with the weather data
	        Table weatherTable = CsvReader.readData(filenameWeather);
	        
	        // Lookup the corresponding columns for minimal and maximal temperature
	        String maximumTemp = "MxT";
	        String minimumTemp = "MnT";
	        int indexColumnMaximumTemp = weatherTable.getIndexByColumnname(maximumTemp);
	        int indexColumnMinimumTemp = weatherTable.getIndexByColumnname(minimumTemp);
	        
	        // Set up a Comparator to compare the Entries based on the difference
	        Comparator<Entry> cpEntry = new SortByDiff(indexColumnMaximumTemp, indexColumnMinimumTemp);
	        
	        // find the Entry with the minimal difference
	        Entry minDifference = Collections.min(weatherTable.entries, cpEntry);
	        // and print it 
        	System.out.printf("Day with smallest temperature spread : %s%n", minDifference);
        
        // only catching this exception while its highly likely that others can occur
	    } catch ( IOException e ) { 
	    	System.out.println("Fehler beim Lesen der Datei:\n"+e.getMessage());
	   	}    
		
		// ------------------ Football Challenge ------------------
        
		String filenameFootball = "football.csv";
		try{
			// Create the table with the football data
	        Table footballTable = CsvReader.readData(filenameFootball);
	        
	        // Lookup the corresponding columns for scored and allowed goals
	        String goalsString = "Goals";
	        String goalsAllowedString = "Goals Allowed";
	        int indexColumnGoals = footballTable.getIndexByColumnname(goalsString);
	        int indexColumnGoalsAllowed = footballTable.getIndexByColumnname(goalsAllowedString);
	        
	        // Set up a Comparator to compare the Entries based on the difference
	        Comparator<Entry> cpEntry = new SortByDiff(indexColumnGoals, indexColumnGoalsAllowed);
	        
	        // find the Entry with the minimal difference
	        Entry minDifference = Collections.min(footballTable.entries, cpEntry);
	        // and print it 
        	System.out.printf("Team with smallest goal spread       : %s%n", minDifference);
        
        // only catching this exception while its highly likely that others can occur
	    } catch ( IOException e ) { 
	    	System.out.println("Fehler beim Lesen der Datei:\n"+e.getMessage());
	   	}  
		
        return;
    }   
}



