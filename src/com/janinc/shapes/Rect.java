package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;

import java.awt.*;

public class Rect extends Coord {
    int side = 0;

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX() - side / 2, getY() - side / 2, side, side);
    } // getBounds

    public Rect(int x, int y, int side) {
        super(x, y);
        this.side = side;
    }  // Rect

    @Override
    public String toString() {
        return String.format("Rect:\t\tid =%3d, x =%3d, y =%3d, side\t=%3d", getId(), getX(), getY(), side);
    } // toString
} // Class Rect
