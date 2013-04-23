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
import zgpdistribution.util.oops.UoMList;

/**
 *
 * @author John
 */
public class UoMListDAO {

    private Connection conn;

    public UoMListDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(UoMList data) {
        String sql = "insert into uomlist (uomLong, uomShort) value (?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, data.getUomLong());
            st.setString(2, data.getUomShort());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UoMListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<UoMList> queryAll() {
        ArrayList<UoMList> uomList = null;
        String sql = "select * from uomlist order by uomLong asc";
        try {
            uomList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                uomList.add(new UoMList(rs.getString("uomLong"), rs.getString("uomShort")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UoMListDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return uomList;
    }
}
