package com.selawasna.repository;

import com.selawasna.entity.Cordinate;
import com.selawasna.service.SnakeServiceImpl;
import com.selawasna.service.contol.ControlSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Windows extends JFrame {
    public static ArrayList<ArrayList<ChacheData>> grid;
    public static int width = 20;
    public static int height = 20;
    public Windows(){


        grid = new ArrayList<>();
        ArrayList<ChacheData> data;

        for (int i = 0; i < width; i++) {
            data = new ArrayList<>();

            for (int j = 0; j < height; j++) {
                ChacheData c = new ChacheData(2);
                data.add(c);
            }

            grid.add(data);
        }

        getContentPane().setLayout(new GridLayout(width,height,0,0));

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getContentPane().add(grid.get(i).get(j).board);
            }
        }

        Cordinate position = new Cordinate(10, 10);
        SnakeServiceImpl snake = new SnakeServiceImpl(position);

        snake.start();

        this.addKeyListener((KeyListener) new ControlSnake());

    }
}















