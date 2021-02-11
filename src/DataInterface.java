public interface DataInterface {
    void initializeDatabase(String filename); // filename allows us to add different files
    void createEntry(Entry e);
    Entry readEntry(String ID);
    void updateEntry();
    void deleteEntry();
    void saveEntry();
}
