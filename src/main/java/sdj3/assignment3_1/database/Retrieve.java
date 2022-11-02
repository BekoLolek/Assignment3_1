package sdj3.assignment3_1.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static sdj3.assignment3_1.database.DatabaseConnection.getConnection;

public class Retrieve {
    public static int getRegNum(String packageid) {
        String SQL = "SELECT FROM animalid FROM slaughterhouse.animalpackage WHERE packageid = " + packageid + ";";

        int count = 0;

        try (Connection conn = (Connection) getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
            System.out.println(count);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return count;
    }

    public static ArrayList<Integer> getPackages(int animalRegNumber){
        String SQL = "SELECT packageid FROM slaughterhouse.animalpackage WHERE animalid = " + animalRegNumber + ";";

        ArrayList<Integer> list = new ArrayList<Integer>();

        try (Connection conn = (Connection) getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            for(int i = 0;i < rs.getFetchSize();i++){
                list.add(rs.getInt(1));
                rs.next();
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return list;
    }

}
