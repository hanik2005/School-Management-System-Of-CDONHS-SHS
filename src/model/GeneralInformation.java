/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.MyConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class GeneralInformation extends Information{
    @Override
    public DefaultTableModel searchByName(String name) throws Exception {
        String sql = "SELECT s.user_id, CONCAT(s.first_name, ' ', s.middle_name, ' ', s.last_name) AS full_name, 'Student' AS role " +
                     "FROM student s " +
                     "WHERE CONCAT(s.first_name, ' ', s.middle_name, ' ', s.last_name) LIKE ? " +
                     "UNION " +
                     "SELECT t.user_id, CONCAT(t.first_name, ' ', t.middle_name, ' ', t.last_name) AS full_name, 'Teacher' AS role " +
                     "FROM teacher t " +
                     "WHERE CONCAT(t.first_name, ' ', t.middle_name, ' ', t.last_name) LIKE ?";

        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        String searchPattern = "%" + name + "%";
        ps.setString(1, searchPattern);
        ps.setString(2, searchPattern);

        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"User_ID", "Full Name", "Role"}, 0
        );

        while (rs.next()) {
            Object[] row = {
                rs.getInt("user_id"),
                rs.getString("full_name"),
                rs.getString("role")
            };
            model.addRow(row);
        }

        rs.close(); ps.close(); conn.close();
        return model;
    }
}
