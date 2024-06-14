package com.selawasna.service;

import com.selawasna.entity.Cordinate;
import com.selawasna.entity.Ulars;
import com.selawasna.repository.ChacheData;
import com.selawasna.repository.Windows;

import java.util.ArrayList;
import java.util.Objects;

public class SnakeServiceImpl extends Thread implements SnakeService{
    ArrayList<ArrayList<ChacheData>> square;
    Cordinate headSnakePos;
    public static Ulars snikes = new Ulars(70,3);
    private int finalSize;

    public static int directionSnake ;

    ArrayList<Cordinate> positions = new ArrayList<>();
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
            sleep(snikes.getSpeed());
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
            boolean biteItself = Objects.equals(posCritique.getX(), positions.get(i).getX()) && Objects.equals(posCritique.getY(), positions.get(i).getY());
            if(biteItself){
                stopGame();
            }
        }

        boolean eatingFood = Objects.equals(posCritique.getX(), foodPosition.getY()) && Objects.equals(posCritique.getY(), foodPosition.getX());
        if(eatingFood){
            System.out.println("Yummy!");
            snikes.setSize(snikes.getSize() + 1);
            foodPosition = getArea();
            spawnFood(foodPosition);
        }
    }

    @Override
    public void stopGame() {
        finalSize = snikes.getSize();
        System.out.println("COLISION! \n ");
        while(true){
            pauser();
        }
    }
    public int getFinalSize(){
        return finalSize;
    }

    @Override
    public void spawnFood(Cordinate cordinate) {
        square.get(cordinate.getX()).get(cordinate.getY()).lightMeUp(1);
    }

    @Override
    public void moveInternel(int dir) {
        switch (dir) {
            case 4 -> {
                headSnakePos.changeData(headSnakePos.getX(), (headSnakePos.getY() + 1) % 20);
                positions.add(new Cordinate(headSnakePos.getX(), headSnakePos.getY()));
            }
            case 3 -> {
                if (headSnakePos.getY() - 1 < 0) {
                    headSnakePos.changeData(headSnakePos.getX(), 19);
                } else {
                    headSnakePos.changeData(headSnakePos.getX(), Math.abs(headSnakePos.getY() - 1) % 20);
                }
                positions.add(new Cordinate(headSnakePos.getX(), headSnakePos.getY()));
            }
            case 2 -> {
                if (headSnakePos.getX() - 1 < 0) {
                    headSnakePos.changeData(19, headSnakePos.getY());
                } else {
                    headSnakePos.changeData(Math.abs(headSnakePos.getX() - 1) % 20, headSnakePos.getY());
                }
                positions.add(new Cordinate(headSnakePos.getX(), headSnakePos.getY()));
            }
            case 1 -> {
                headSnakePos.changeData(Math.abs(headSnakePos.getX() + 1) % 20, headSnakePos.getY());
                positions.add(new Cordinate(headSnakePos.getX(), headSnakePos.getY()));
            }
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
        int cmpt = snikes.getSize();
        for(int i = positions.size()-1;i>=0;i--){
            if(cmpt==0){
                Cordinate t = positions.get(i);
                square.get(t.getY()).get(t.getX()).lightMeUp(2);
            }
            else{
                cmpt--;
            }
        }
        cmpt = snikes.getSize();
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
        int ranX= (int) (Math.random() * 19);
        int ranY= (int) (Math.random() * 19);
        p=new Cordinate(ranX,ranY);
        for(int i = 0 ; i <= positions.size() - 1 ; i++){
            if(Objects.equals(p.getY(), positions.get(i).getX()) && Objects.equals(p.getX(), positions.get(i).getY())){
                ranX= (int) (Math.random() * 19);
                ranY= (int) (Math.random() * 19);
                p=new Cordinate(ranX,ranY);
                i=0;
            }
        }
        return p;
    }

}
