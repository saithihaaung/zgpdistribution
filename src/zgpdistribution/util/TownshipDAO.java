/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zgpdistribution.util.oops.Township;

/**
 *
 * @author John
 */
public class TownshipDAO {

    private Connection conn;

    public TownshipDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(Township data) {
        String sql = "insert into township(name, code)value(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.setString(2, data.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TownshipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<Township> queryAll() {
        String sql = "select * from township order by name asc";
        ArrayList<Township> townshipList = null;
        Statement st;
        try {
            townshipList = new ArrayList<>();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                townshipList.add(new Township(rs.getString("name"), rs.getString("code")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TownshipDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return townshipList;
    }
}
