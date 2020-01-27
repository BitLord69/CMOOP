package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;

import java.awt.Rectangle;

public class Coord implements ICollide {
    private static int counter = 0;

    private int id;
    private int x = 0;
    private int y = 0;

    public Coord(int x, int y){
        id = ++Coord.counter;
        this.x = x;
        this.y = y;
    } // Coord

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 1, 1);
    } // getBounds

    public boolean collision(ICollide object){
        return getBounds().intersects(object.getBounds());
    } // collision

    @Override
    public String toString() {
        return String.format("Coord:\tid =%3d, x =%3d, y =%3d\t\t\t\t", id, x, y);
    } // toString
} // class Coord
