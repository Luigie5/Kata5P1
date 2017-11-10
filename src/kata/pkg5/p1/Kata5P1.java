package kata.pkg5.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c= DriverManager.getConnection("jdbc:sqlite:qwerty.db");
        Statement st= c.createStatement();
        ResultSet rs= st.executeQuery("select * from People");
        while(rs.next()){
            System.out.println("ID = " + rs.getInt("Id"));
            System.out.println("Name = " + rs.getString("Name"));
        }
        st.execute("CREATE TABLE IF NOT EXISTS Mail ( 'Id' INTEGER PRIMARY KEY "
                + "AUTOINCREMENT, 'Mail' TEXT NOT NULL );");
        
    }
}
