package com.selawasna.main;

import com.selawasna.repository.Windows;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Windows f1 = new Windows();

        f1.setTitle("Snake Games");
        f1.setSize(400, 400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
