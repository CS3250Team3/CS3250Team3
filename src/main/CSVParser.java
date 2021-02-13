package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
  This class will eventually hook up to our database,
  so in the future it might change from adding the entries 
  to a HashMap to instead calling the createEntry method
  to add it straight in to the DB
 */
public class CSVParser {
	
	/**
	 * Parses a CSV file full of products into Entry objects
	 *  
	 * @param filename - Path to the csv file to be parsed
	 * @return - A HashMap full of filled in entry objects
	 */
	public HashMap<String, Entry> readCSV(String filename){
		String line;  	// Current row contents
		String[] fields;// Array to store individual product fields
		HashMap<String, Entry> results = new HashMap<String, Entry>(); // Stores <productID,Entry object>
		
		// Try to open the file and start reading
		try (InputStream inputStream = getClass().getResourceAsStream(filename);
			    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
				reader.readLine(); // Skips the first line containing row headers
				int i = 1;
				
				// Loop through each row and instantiate entries
			    while((line = reader.readLine()) != null) {
			    	Entry newEntry = new Entry(); // Create new entry
			    	fields = line.split(",");     // Split the row into individual fields
			    	
			    	// Fill in newEntry's fields
			    	newEntry.setProductID(fields[0]);
			    	newEntry.setStockQuantity(Integer.parseInt(fields[1]));
			    	newEntry.setWholesaleCost(Double.parseDouble(fields[2]));
			    	newEntry.setSalePrice(Double.parseDouble(fields[3]));
			    	newEntry.setSupplierID(fields[4]);
			    	
			    	// Add the entry to the result map
			    	results.put(fields[0], newEntry);
			    	i++;
			    }
		} catch (IOException e) {
				e.printStackTrace();
		}
		return results;
	}
}
