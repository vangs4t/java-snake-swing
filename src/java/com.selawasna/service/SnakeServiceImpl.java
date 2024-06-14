package com.selawasna.service;

import com.selawasna.entity.Cordinate;
import com.selawasna.gui.Buttons;
import com.selawasna.repository.ChacheData;
import com.selawasna.repository.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakeServiceImpl extends Thread implements SnakeService{
    ArrayList<ArrayList<ChacheData>> square;
    Cordinate headSnakePos;
    public int sizeSnake = 3;
    public static StringBuilder str = new StringBuilder();
    public static Timer timer = new Timer(1000, new ActionListener() {
        int counter = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
        }
    });

    public static int directionSnake ;

    ArrayList<Cordinate> positions = new ArrayList<Cordinate>();
    Cordinate foodPosition;

    public SnakeServiceImpl() {
    }

    public SnakeServiceImpl(Cordinate positionDepart) {

        square = Windows.grid;

        headSnakePos = new Cordinate(positionDepart.getX(), positionDepart.getY());
        directionSnake = 1;

        Cordinate headPos = new Cordinate(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos);

        foodPosition = new Cordinate(Windows.height -1, Windows.WIDTH -1);
        spawnFood(foodPosition);

    }

    public void run(){
        while (true){
            timer.start();
            moveInternel(directionSnake);
            checkTabrakan();
            moveExternel();
            deleteTail();
            pauser();
        }
    }

    /**
     * Mengatur delay dan kecepatan ular
     */
    @Override
    public void pauser() {
        try {
            sleep(new Buttons().getSpeeds());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Membuat fungsi untuk mengecek tabrakan dan makanan
     */
    @Override
    public void checkTabrakan() {
        Cordinate posCritique = positions.get(positions.size()-1);
        for(int i = 0;i<=positions.size()-2;i++){
            boolean biteItself = posCritique.getX() == positions.get(i).getX() && posCritique.getY() == positions.get(i).getY();
            if(biteItself){

                stopGame();
            }
        }

        boolean eatingFood = posCritique.getX() == foodPosition.getY() && posCritique.getY() == foodPosition.getX();
        if(eatingFood){
            System.out.println("Yummy!");
            sizeSnake = sizeSnake + 1;
            foodPosition = getArea();
            spawnFood(foodPosition);
        }
    }

    @Override
    public void stopGame() {
        System.out.println("COLISION! \n");
        while(true){
            timer.stop();
            pauser();
        }
    }

    @Override
    public void spawnFood(Cordinate cordinate) {
        square.get(cordinate.getX()).get(cordinate.getY()).lightMeUp(1);
    }

    @Override
    public void moveInternel(int dir) {
        switch(dir){
            case 4:

                headSnakePos.changeData(headSnakePos.getX(),(headSnakePos.getY()+1)%20);
                positions.add(new Cordinate(headSnakePos.getX(),headSnakePos.getY()));
                break;
            case 3:
                if(headSnakePos.getY()-1<0){
                    headSnakePos.changeData(headSnakePos.getX(),19);
                }
                else{
                    headSnakePos.changeData(headSnakePos.getX(),Math.abs(headSnakePos.getY()-1)%20);
                }
                positions.add(new Cordinate(headSnakePos.getX(),headSnakePos.getY()));
                break;
            case 2:
                if(headSnakePos.getX()-1<0){
                    headSnakePos.changeData(19,headSnakePos.getY());
                }
                else{
                    headSnakePos.changeData(Math.abs(headSnakePos.getX()-1)%20,headSnakePos.getY());
                }
                positions.add(new Cordinate(headSnakePos.getX(),headSnakePos.getY()));

                break;
            case 1:
                headSnakePos.changeData(Math.abs(headSnakePos.getX()+1)%20,headSnakePos.getY());
                positions.add(new Cordinate(headSnakePos.getX(),headSnakePos.getY()));
                break;
        }
    }

    @Override
    public void moveExternel() {
        for(Cordinate t : positions){
            int y = t.getX();
            int x = t.getY();
            square.get(x).get(y).lightMeUp(0);

        }
    }

    @Override
    public void deleteTail() {
        int cmpt = sizeSnake;
        for(int i = positions.size()-1;i>=0;i--){
            if(cmpt==0){
                Cordinate t = positions.get(i);
                square.get(t.getY()).get(t.getX()).lightMeUp(2);
            }
            else{
                cmpt--;
            }
        }
        cmpt = sizeSnake;
        for(int i = positions.size()-1;i>=0;i--){
            if(cmpt==0){
                positions.remove(i);
            }
            else{
                cmpt--;
            }
        }
    }

    @Override
    public Cordinate getArea() {
        Cordinate p ;
        int ranX= 0 + (int)(Math.random()*19);
        int ranY= 0 + (int)(Math.random()*19);
        p=new Cordinate(ranX,ranY);
        for(int i = 0 ; i <= positions.size() - 1 ; i++){
            if(p.getY()==positions.get(i).getX() && p.getX()==positions.get(i).getY()){
                ranX= 0 + (int)(Math.random()*19);
                ranY= 0 + (int)(Math.random()*19);
                p=new Cordinate(ranX,ranY);
                i=0;
            }
        }
        return p;
    }

    @Override
    public void mainMenus() {

    }
}
