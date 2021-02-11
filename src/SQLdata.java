import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

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
        String statement="INSERT INTO DataEntries(productID,supplierID,stockQuantity,WholesaleCost,salePrice) VALUES('" + e.getProductID() + "', '" + e.getSupplierID() + "' , '"+ e.getStockQuantity() + "' , '" + e.getWholesaleCost() + "' , '" + e.getSalePrice() + "');" ;
        try {
            st.execute(statement);
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        
    }

    @Override
    public Entry readEntry(String ID) {
        String statement = "SELECT * FROM DataEntries HAVING productID ='"+ ID + "';";
        try {
            rs = st.executeQuery(statement);
            Entry ent;
            rs.next();
            System.out.println(rs.getString("productID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


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