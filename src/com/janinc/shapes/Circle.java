package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;


import java.awt.*;

public class Circle extends Coord {

    private float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }  // Circle

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(getX() - radius), (int)(getY() - radius), (int)radius * 2, (int)radius * 2);
    } // getBounds

    @Override
    public boolean isCollisionDetected(ICollide object) {
        // Inte väldigt snyggt nedan, men vet inte hur jag annars ska lösa det med interfacet och bättre kollisionesdetektering.
        // Ser fram emot att få en bra genomgång på lektionen :)
        if (object instanceof Circle)
            return Coord.circleCircleCollision(this, (Circle)object);
        else
        if (object instanceof Rect)
            return Coord.circleRectCollision(this, (Rect)object);
        else
        if (object instanceof Coord)
            return Coord.circleCoordCollision(this, (Coord)object);
        else
            return super.isCollisionDetected(object);
    } // isCollisionDetected


    public float getRadius() {
        return radius;
    } // getRadius

    @Override
    public String toString() {
        return String.format("%-10s: id =%3d, x =%4.0f, y =%4.0f, radius =%4.0f", getClass().getSimpleName(), getId() , getX(), getY(), radius);
    } // toString
} // Class Circle
