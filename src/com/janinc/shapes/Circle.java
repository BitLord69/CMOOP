package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICircleCollision;
import com.janinc.iface.ICollide;

import java.awt.*;

public class Circle extends Coord implements ICircleCollision {
    private float radius = 0;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }  // Circle

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(getX() - radius), (int)(getY() - radius), (int)radius * 2, (int)radius * 2);
    } // getBounds

    @Override
    public boolean isCollisionDetected(ICircleCollision circle) {
        System.out.println("isCollisionDetected(ICircleCollision circle)!!!");
        return super.isCollisionDetected(circle);
    } // isCollisionDetected

//    @Override
//    public boolean isCollisionDetected(ICollide object) {
//        System.out.println("isCollisionDetected(ICollide object)!!!");
//        return super.isCollisionDetected(object);
//    } // isCollisionDetected

    public float getRadius() {
        return radius;
    } // getRadius

    @Override
    public String toString() {
        return String.format("Circle:\tid =%3d, x =%3.0f, y =%3.0f, radius =%3.0f", getId(), getX(), getY(), radius);
    } // toString
} // Class Circle
