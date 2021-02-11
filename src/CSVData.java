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
    }

    @Override
    public void createEntry(Entry e) {

    }

    @Override
    public Entry readEntry(String ID) {
        return null;
        // TODO Auto-generated method stub

    }

    @Override
    public void updateEntry() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEntry() {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveEntry() {
        // TODO Auto-generated method stub

    }
    
}
