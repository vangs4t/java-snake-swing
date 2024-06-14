package com.selawasna.entity;

public class Ulars {
    int speed, size;

    public Ulars() {
    }

    public Ulars(int size) {
        this.size = size;
    }

    public Ulars(int speed, int size) {
        this.speed = speed;
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
