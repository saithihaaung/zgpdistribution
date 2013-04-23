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
import zgpdistribution.util.oops.TeamList;

/**
 *
 * @author John
 */
public class TeamListDAO {

    private Connection conn;

    public TeamListDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(TeamList data) {
        String sql = "insert into teamlist (name, code) value (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.setString(2, data.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<TeamList> queryAll() {
        String sql = "select * from teamlist order by name asc";
        ArrayList<TeamList> teamList = null;
        try {
            teamList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                teamList.add(new TeamList(rs.getString("name"), rs.getString("code")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamListDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teamList;
    }
}
