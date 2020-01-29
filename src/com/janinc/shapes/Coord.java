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
    private float x;
    private float y;

    public Coord(float x, float y){
        id = ++Coord.counter;
        this.x = x;
        this.y = y;
    } // Coord

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 1, 1);
    } // getBounds

    public boolean isCollisionDetected(ICollide object){
        return getBounds().intersects(object.getBounds());
    } // isCollisionDetected

    public static float clamp(float value, float min, float max) {
        float x = value;
        if (x < min) {
            x = min;
        } else if (x > max) {
            x = max;
        }
        return x;
    } // clamp

    @Override
    public String toString() {
        return String.format("%-10s: id =%3d, x =%4.0f, y =%4.0f%14s", getClass().getSimpleName(), id, x, y, " ");
    } // toString
} // class Coord
