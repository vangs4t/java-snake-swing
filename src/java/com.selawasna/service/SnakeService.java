package com.selawasna.service;


import com.selawasna.entity.Cordinate;


public interface SnakeService {

    void pauser();

    void checkTabrakan();

    void stopGame();

    void spawnFood(Cordinate cordinate);

    void moveInternel(int dir);

    void moveExternel();

    void deleteTail();

    Cordinate getArea();

}
