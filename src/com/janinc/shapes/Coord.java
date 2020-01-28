package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICircleCollision;
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
            // Inte väldigt snyggt nedan, men vet inte hur jag annars ska lösa det med interfacet och bättre kollisionesdetektering.
            // Ser fram emot att få en bra genomgång på lektionen :)

//            if (this instanceof Circle || object instanceof Circle) {
//
//            }
//
//            if (object instanceof Coord) {
//                System.out.println("Circle colliding with '.'");
//                return Coord.circleCoordCollision((Circle)this, (Coord)object);
//            } // if object
//            else
//            if (object instanceof Circle){
//                System.out.println("Circles colliding...");
//                return Coord.circleCircleCollision((Circle)this, (Circle)object);
//            } // if object...
//            else
//            if (object instanceof Rect){
//                return false;
//            } else
        System.out.println("Coord::isCollisionDetected(ICollide object)!!!");
        return getBounds().intersects(object.getBounds());
    } // isCollisionDetected

    @Override
    public String toString() {
        return String.format("Coord:\tid =%3d, x =%3.0f, y =%3.0f\t\t\t", id, x, y);
    } // toString

    protected static boolean circleCoordCollision(Circle circle, Coord coord) {
        return (Math.abs(circle.getX() - coord.getX()) <= circle.getRadius() && Math.abs(circle.getY() - coord.getY()) <= circle.getRadius());
    } // circleCoordCollision

    protected static boolean circleCircleCollision(Circle c1, Circle c2) {
        return Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2) <= Math.pow(c1.getRadius() + c2.getRadius(), 2);
    } // circleCircleCollision

    protected static boolean circleRectCollision(Circle circle, Rect rect) {
        return false; //Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2) <= Math.pow(c1.getRadius() + c2.getRadius(), 2);
    } // circleRectCollision
} // class Coord
