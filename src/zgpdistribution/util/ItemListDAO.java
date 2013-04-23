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
import zgpdistribution.util.oops.ItemList;

/**
 *
 * @author John
 */
public class ItemListDAO {

    private Connection conn;

    public ItemListDAO() {
        try {
            conn = DataSourceConnection.initDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean save(ItemList data) {
        String sql = "insert into itemlist ( name, code, netUom, subUom, netWeight,"
                + " subWeight, netPrize, subPrize, subUnitInclude, category, supplier, netWeightM, subWeightM ) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data.getName());
            ps.setString(2, data.getCode());
            ps.setString(3, data.getNetUom());
            ps.setString(4, data.getSubUom());
            ps.setDouble(5, data.getNetWeight());
            ps.setDouble(6, data.getSubWeight());
            ps.setDouble(7, data.getNetPrize());
            ps.setDouble(8, data.getSubPrize());
            ps.setInt(9, data.getSubUnitInclude());
            ps.setString(10, data.getCategory());
            ps.setString(11, data.getSupplier());
            ps.setString(12, data.getNetWeightM());
            ps.setString(13, data.getSubWeightM());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemListDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public ArrayList<ItemList> queryAll() {
        String sql = "select * from itemlist order by name asc";
        ArrayList<ItemList> itemsList = null;
        try {
            itemsList = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                itemsList.add(new ItemList(rs.getString("name"), rs.getString("code"), rs.getString("netUom"),
                        rs.getString("subUom"), rs.getString("category"), rs.getString("supplier"), rs.getString("netWeightM"), rs.getString("subWeightM"), rs.getInt("subUnitInclude"), rs.getDouble("netWeight"),
                        rs.getDouble("subWeight"), rs.getDouble("netPrize"), rs.getDouble("subPrize")));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemListDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return itemsList;
    }
}
