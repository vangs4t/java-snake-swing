package com.selawasna.repository;


import com.selawasna.gui.Board;

import java.awt.*;
import java.util.ArrayList;

public class ChacheData {

    ArrayList<Color> C = new ArrayList<>();
    // Data 0 == Kosong, 1 == Makanan, == 2 Ular
    int color;

    Board board;

    public ChacheData(int data) {
        C.add(Color.RED); //data 0
        C.add(Color.PINK); //data 1
        C.add(Color.BLACK); //data 2

        color = data;

        board = new Board(C.get(color));

    }

    public void lightMeUp(int c){
        board.changeColor(C.get(c));
    }
}
