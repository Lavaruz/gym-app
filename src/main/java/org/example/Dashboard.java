package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel panelMain;
    private JFrame frame = new JFrame();
    private JButton button1;

    public Dashboard() {
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);

//        ImageIcon signout = new ImageIcon("img/signout.png");
//        Image image = signout.getImage(); // transform it
//        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
//        signout = new ImageIcon(newimg);
//        button1.setIcon(signout);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This is message","title", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}

