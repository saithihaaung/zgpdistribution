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
import zgpdistribution.util.oops.CustType;

/**
 *
 * @author John
 */
public class CustTypeDAO {

    private Connection conn;

    public CustTypeDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(CustType data) {
        String sql = "insert into custtype(name)value(?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, data.getName().trim());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<CustType> queryAll() {
        String sql = "select * from custtype order by name asc";
        ArrayList<CustType> custTypeList = null;
        try {
            custTypeList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                custTypeList.add(new CustType(rs.getString("name")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return custTypeList;
    }
}
