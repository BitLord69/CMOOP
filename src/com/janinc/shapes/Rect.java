package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;

import java.awt.*;

public class Rect extends Coord {
    float side = 0;

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(getX() - side / 2), (int)(getY() - side / 2), (int)side, (int)side);
    } // getBounds

    public Rect(float x, float y, float side) {
        super(x, y);
        this.side = side;
    }  // Rect

    @Override
    public String toString() {
        return String.format("Rect:\t\tid =%3d, x =%3.0f, y =%3.0f, side\t=%3.0f", getId(), getX(), getY(), side);
    } // toString
} // Class Rect
