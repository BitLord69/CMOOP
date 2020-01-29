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
            return circleCircleCollision(this, (Circle)object);
        else
        if (object instanceof Rect)
            return circleRectCollision(this, (Rect)object);
        else
        if (object instanceof Coord)
            return circleCoordCollision(this, (Coord)object);
        else
            return super.isCollisionDetected(object);
    } // isCollisionDetected


    public float getRadius() {
        return radius;
    } // getRadius

    protected static boolean circleCoordCollision(Circle circle, Coord coord) {
        return (Math.abs(circle.getX() - coord.getX()) <= circle.getRadius() && Math.abs(circle.getY() - coord.getY()) <= circle.getRadius());
    } // circleCoordCollision

    protected static boolean circleCircleCollision(Circle c1, Circle c2) {
        return Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2) <= Math.pow(c1.getRadius() + c2.getRadius(), 2);
    } // circleCircleCollision

    protected static boolean circleRectCollision(Circle circle, Rect rect) {
        float closestX = Coord.clamp(circle.getX(), rect.getX(), rect.getX() + rect.getSide() / 2);
        float closestY = Coord.clamp(circle.getY(), rect.getY() - rect.getY() - rect.getSide() / 2, rect.getY());

        return Math.pow(circle.getX() - closestX, 2) + Math.pow(circle.getY() - closestY, 2) < Math.pow(circle.getRadius(), 2);
    } // circleRectCollision

    @Override
    public String toString() {
        return String.format("%-10s: id =%3d, x =%4.0f, y =%4.0f, radius =%4.0f", getClass().getSimpleName(), getId() , getX(), getY(), radius);
    } // toString
} // Class Circle
