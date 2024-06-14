package com.selawasna.main;


import com.selawasna.entity.Ulars;
import com.selawasna.repository.Windows;
import com.selawasna.service.SnakeServiceImpl;

import javax.swing.*;
import java.awt.*;

public class App extends JButton{

    public static void main(String[] args) {
        Ulars butos = new Ulars(70,3);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        frame.setSize(400, 400);
        frame.setLayout(null);
        panel.setSize(400, 400);
        JButton button = new JButton("Start Game");
        button.setBounds(150, 100, 100, 30);
        button.setBackground(Color.white);
        JButton button1 = new JButton("Leatherboard");
        button1.setBounds(150, 140, 100, 30);
        button1.setBackground(Color.white);
        JButton button2 = new JButton("Difficulty");
        button2.setBounds(150, 180, 100, 30);
        button2.setBackground(Color.white);
        button1.addActionListener(e -> System.out.println(new SnakeServiceImpl().getFinalSize()));
        button2.addActionListener(e -> {
            boolean will = true;
            while (will){
                if (butos.getSpeed() > 20){
                    butos.setSpeed(butos.getSpeed() - 10);
                    System.out.println(butos.getSpeed());
                    break;
                } else if (butos.getSpeed() == 20) {
                    butos.setSpeed(butos.getSpeed() + 80);
                    break;
                } else {
                    will = false;
                }
            }
        });
        JButton button3 = new JButton("Quit");
        button3.setBounds(150, 220, 100, 30);
        button3.setBackground(Color.white);
        button3.addActionListener(e -> frame.dispose());
        button.addActionListener(e -> {
            Windows f1 = new Windows();

            f1.setTitle("Snake Games");
            f1.setSize(400, 400);
            f1.setVisible(true);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
        frame.add(panel);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
