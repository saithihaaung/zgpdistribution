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
import zgpdistribution.util.oops.ChannelList;

/**
 *
 * @author John
 */
public class ChannelListDAO {

    private Connection conn;

    public ChannelListDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(ChannelList data) {
        String sql = "insert into channellist(name, code)value(?,?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, data.getName().trim());
            ps.setString(2, data.getCode().trim());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChannelListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<ChannelList> queryAll() {
        String sql = "select * from channellist order by name asc";
        ArrayList<ChannelList> custTypeList = null;
        try {
            custTypeList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                custTypeList.add(new ChannelList(rs.getString("name"), rs.getString("code")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChannelListDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return custTypeList;
    }
}
