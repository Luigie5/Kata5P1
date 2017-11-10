package kata.pkg5.p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kata5P1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
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
        ArrayList <String> arrayMail= readFile();
        String query;
        for (String mail : arrayMail) {
            query="INSERT INTO MAIL (mail) VALUES ('" + mail+"');";
            st.executeUpdate(query);
        }
        
    }
    public static ArrayList readFile() throws IOException{
        ArrayList <String> res= new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader("emails.txt"));
        String mail;
        while((mail=reader.readLine())!=null){
            if(!mail.contains("@")){
                continue;
            }
            res.add(mail);
        }
        return res;
    }
}
