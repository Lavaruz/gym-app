package org.example;

import org.example.Model.Admin;
import org.example.Util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JPanel login_panel;
    private JTextField username_field;
    private JPasswordField password_field;
    private JButton login_btn;
    private JLabel wrong_label;

    static Admin admin;

    static JFrame frame = new JFrame();

    public Login() {

        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = username_field.getText();
                String password = String.valueOf(password_field.getPassword());

                if(getAuth(username, password) != null){
                    frame.dispose();
                    Dashboard dashboard = new Dashboard();
                }else{
                    wrong_label.setText("username or password inccoreact!");
                }

            }
        });
    }
    private Admin getAuth(String username, String password){
        Admin admin = null;
        try{
            Connection conn = ConnectionDB.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM admin WHERE name=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                admin = new Admin();
                admin.name = rs.getString("name");
                admin.password = rs.getString("password");
            }

            conn.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return admin;
    }



    public static void main(String[] args) {
        frame.setContentPane(new Login().login_panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }
}
