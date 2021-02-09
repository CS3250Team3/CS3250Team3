public class Main{
    public static void main(String[] args) {
        DataInterface init = new SQLData();
        init.initializeDatabase("jdbc:mysql://216.137.177.30:3306/testDB?allowPublicKeyRetrieval=true&useSSL=false team3 UpdateTrello!1");
    }
}
