package Util;

import java.sql.*;

public class Validate {
    public static boolean checkUser(String username,String password)
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("org.postgresql.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:postgresql://postgres.ckheurx0twws.us-east-1.rds.amazonaws.com:5432/postgres","postgres","Bilbuk.1994");
            PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}