package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import java.awt.*;

public class Circle extends Coord {
    int radius = 0;

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX() - radius, getY() - radius, radius * 2, radius * 2);
    } // getBounds

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }  // Circle

    @Override
    public String toString() {
        return String.format("Circle:\tid =%3d, x =%3d, y =%3d, radius =%3d", getId(), getX(), getY(), radius);
    } // toString
} // Class Circle
