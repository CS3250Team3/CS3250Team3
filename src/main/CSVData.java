package main;

import java.util.HashMap;
import java.util.Vector;

public class CSVData implements DataInterface {
    /*  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this is where we need to create our methods
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        One note is that we already have a list of Entry type objects, so when dealing with the list 
        we will be getting or setting entry objects which holds all our individual datas.
    */

    private Vector<Entry>  Data = new Vector<Entry>();
    private int NumEntries;
    private HashMap<String, Entry> initialData = new HashMap<String, Entry>();
    


    @Override
    public void initializeDatabase(String filename) {
    	// Initialize a HashMap that stores all inventory data
    	HashMap<String, Entry> initialData = new HashMap<String, Entry>();
    	// Initialize a new parser
    	CSVParser parse = new CSVParser();
    	
    	// Load the HashMap with entries
        initialData = parse.readCSV(filename);
       
        // Track how many entries were added
        this.NumEntries = initialData.size();
        this.initialData = initialData;
    }

    @Override
    public void createEntry(Entry e) {
        // TODO Auto-generated method stub
            
    }

    @Override
    public Entry readEntry(String ID) {
        // TODO Auto-generated method stub
        return null;

    }

    @Override
    public void updateEntry(String ID, Entry e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEntry(String id) {
        // deletes entry using id provided
        initialData.remove(id);
    }

    @Override
    public void saveEntry(Entry e) {
        // TODO Auto-generated method stub

    }
    
    @Override
    public int retSize() {
        // returns size of HashMap to test delete function
        return initialData.size();
    }
}
