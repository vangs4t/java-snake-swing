package com.selawasna.gui;


import com.selawasna.entity.Cordinate;
import com.selawasna.repository.Windows;
import com.selawasna.service.SnakeServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Buttons extends JButton{
    int speeds = 70;
    String name;

    public Buttons() {

    }

    public int getSpeeds() {
        return speeds;
    }

    public void setSpeeds(int speeds) {
        this.speeds = speeds;
    }

    public static void main(String[] args) {
        Buttons butos = new Buttons();
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean will = true;
                while (will){
                    if (butos.getSpeeds() > 20){
                        butos.setSpeeds(butos.getSpeeds() - 10);
                        System.out.println(butos.getSpeeds());
                        break;
                    } else if (butos.getSpeeds() == 20) {
                        butos.setSpeeds(butos.getSpeeds() + 80);
                        break;
                    } else {
                        will = false;
                    }
                }
            }
        });
        JButton button3 = new JButton("Quit");
        button3.setBounds(150, 220, 100, 30);
        button3.setBackground(Color.white);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows f1 = new Windows();

                f1.setTitle("Snake Games");
                f1.setSize(400, 400);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        frame.add(panel);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

//        Timer timer = new Timer(1000, new ActionListener() {
//            int counter = 0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            counter++;
//                if (frame.isVisible()) System.out.println(counter + " detik");
//            }
//        });
//        if (frame.isVisible()){
//            timer.start();
//        } else {
//            timer.stop();
//        }
    }

}
