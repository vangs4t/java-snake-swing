package com.selawasna.entity;

public class Cordinate {
    private Integer X;
    private Integer Y;
    private Integer XF;
    private Integer XY;

    public Cordinate(Integer X, Integer Y) {
        this.X = X;
        this.Y = Y;
    }
    public void changeData(Integer X, Integer Y) {
        this.X = X;
        this.Y = Y;
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public Integer getXF() {
        return XF;
    }

    public void setXF(Integer XF) {
        this.XF = XF;
    }

    public Integer getXY() {
        return XY;
    }

    public void setXY(Integer XY) {
        this.XY = XY;
    }
}

