/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.MyConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class SensitiveInformation extends Information {

    @Override
    public DefaultTableModel searchByName(String name) throws Exception {
        String sql = "SELECT u.user_id, u.username, u.password, t.type_name, 'Student' AS role "
                + "FROM user u "
                + "JOIN type t ON u.type_id = t.type_id "
                + "JOIN student s ON u.user_id = s.user_id "
                + "WHERE CONCAT(s.first_name, ' ', s.middle_name, ' ', s.last_name) LIKE ? "
                + "UNION "
                + "SELECT u.user_id, u.username, u.password, t.type_name, 'Teacher' AS role "
                + "FROM user u "
                + "JOIN type t ON u.type_id = t.type_id "
                + "JOIN teacher te ON u.user_id = te.user_id "
                + "WHERE CONCAT(te.first_name, ' ', te.middle_name, ' ', te.last_name) LIKE ?";

        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        String searchPattern = "%" + name + "%";
        ps.setString(1, searchPattern);
        ps.setString(2, searchPattern);

        ResultSet rs = ps.executeQuery();

        // Build DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"User_ID", "Username", "Password", "Type", "Role"}, 0
        );

        while (rs.next()) {
            Object[] row = {
                rs.getInt("user_id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("type_name"),
                rs.getString("role")
            };
            model.addRow(row);
        }

        rs.close();
        ps.close();
        conn.close();

        return model;
    }
}
