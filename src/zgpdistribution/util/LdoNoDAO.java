/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HWT
 */
public class LdoNoDAO {

    public LdoNoDAO() {
    }
    
    public int getLatestNo() {
        String sql = "select max(ldoNo) as ldoNo from ldo";
        int no = 0;
        try {
            Statement state = DataSourceConnection.initDB().createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs != null) {
                rs.next();
                no = rs.getInt("ldoNo");
            }
        }catch (Exception e ) {
            System.err.println(e.getMessage());
        }        
        return no;
    }
}
