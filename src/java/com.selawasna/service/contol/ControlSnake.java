package com.selawasna.service.contol;

import com.selawasna.service.SnakeServiceImpl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlSnake extends KeyAdapter {
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:	// -> Right
                //if it's not the opposite direction
                if(SnakeServiceImpl.directionSnake!=2)
                    SnakeServiceImpl.directionSnake=1;
                break;
            case 38:	// -> Top
                if(SnakeServiceImpl.directionSnake!=4)
                    SnakeServiceImpl.directionSnake=3;
                break;

            case 37: 	// -> Left
                if(SnakeServiceImpl.directionSnake!=1)
                    SnakeServiceImpl.directionSnake=2;
                break;

            case 40:	// -> Bottom
                if(SnakeServiceImpl.directionSnake!=3)
                    SnakeServiceImpl.directionSnake=4;
                break;

            default: 	break;
        }
    }
}
