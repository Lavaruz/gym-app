package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JButton btn_login;
    private JPanel login_panel;
    private JTextField username_field;
    private JTextField password_field;
    private JButton login_btn;

    static JFrame frame = new JFrame();

    public Login() {

        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(username_field.getText());
                System.out.println(password_field.getText());
            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new Login().login_panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }
}
