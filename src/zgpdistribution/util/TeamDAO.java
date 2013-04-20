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
import zgpdistribution.util.oops.Team;

/**
 *
 * @author John
 */
public class TeamDAO {

    private Connection conn;

    public TeamDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(Team data) {
        String sql = "insert into team (name) value (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<Team> queryAll() {
        String sql = "select * from team order by name asc";
        ArrayList<Team> teamList = null;
        try {
            teamList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                teamList.add(new Team(rs.getString("name")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return teamList;
    }
}
