package Junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import main.CSVData;
import main.DataInterface;

public class CSVDataTest {  
    DataInterface testCSV = new CSVData();
    String File = "inventory_team3.csv";
    @Test
    public void initDBTest() {
        // creates test db
        testCSV.initializeDatabase(File);

        assertEquals(42585, testCSV.retSize());
    }
    @Test
     void retSizeTest(){
        // once Create Entry is finished we can make this less tightly 
        // coupled by starting with a blank testCSV and adding one entry to check if we only have a size of one 
        testCSV.initializeDatabase(File);
        testCSV.deleteEntry("6JKIQ99UY8OH");
        assertEquals(42584,testCSV.retSize());
    }

    @Test
    void deleteEntryTest(){
        testCSV.initializeDatabase(File);
        int first = testCSV.retSize();
        testCSV.deleteEntry("B67VWX6R77AQ");
        assertNotEquals(first, testCSV.retSize());
    }
}
