package com.selawasna.gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{

    private static final long serialVersionUID = 1L;

    public Board(Color color) {
        this.setBackground(color);
    }


    public void changeColor(Color color) {
        this.setBackground(color);
        this.repaint();
    }

}
