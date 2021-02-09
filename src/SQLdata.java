import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class SQLData implements DataInterface {

    String connectionString = "";
    String username = "";
    String password = "";
    Connection con;
    java.sql.Statement st;
    ResultSet rs;

    @Override
    public void initializeDatabase(String filename) {
        parseString(filename);
        try {
            con = DriverManager.getConnection(connectionString,username, password);
            st =  con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");
            if(rs.next()){
                System.out.println("Connected to..." + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }


    private void parseString(String s){
        s+=" ";
        String buffer = "";
        String[] information = new String[3];
        int place = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                information[place] = buffer;
                buffer = "";
                place++;
            }
            else{
                buffer+= s.charAt(i);
            }
        }
        connectionString = information[0];
        username = information[1];
        password = information[2];
    }

    @Override
    public void createEntry(Entry e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void readEntry() {
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