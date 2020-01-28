package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;

import java.awt.*;

public class Rect extends Coord {
    float side;


    public Rect(float x, float y, float side) {
        super(x, y);
        this.side = side;
    }  // Rect

    public float getSide() {
        return side;
    } // getSide

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(getX() - side / 2), (int)(getY() - side / 2), (int)side, (int)side);
    } // getBounds

    @Override
    public String toString() {
        return String.format("%-10s: id =%3d, x =%4.0f, y =%4.0f, side =%6.0f", getClass().getSimpleName(), getId(), getX(), getY(), side);
    } // toString
} // Class Rect
