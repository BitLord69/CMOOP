package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public class ShapeFactory {
    public static final int MAX_SIDE_RADIUS_DIVISOR = 4;

    private int playFieldSize;

    public ShapeFactory(int playFieldSize) {
        this.playFieldSize = playFieldSize;
    } // ShapeFactory

    public Coord createRandomCoord(){
        return new Coord((float)Math.random() * playFieldSize, (float)Math.random() * playFieldSize);
    } // createRandomCoord

    public Rect createRandomRect() {
        Coord c;
        float side;

        do {
            c = createRandomCoord();
            side = (float)(Math.random() * playFieldSize / MAX_SIDE_RADIUS_DIVISOR);
        }
        while (c.getX() - side / 2 < 0 || c.getX() + side / 2 > playFieldSize ||
                c.getY() - side / 2 < 0 || c.getY() + side / 2 > playFieldSize);

        return new Rect(c.getX(), c.getY(), side);
    } // createRandomRect

    public Circle createRandomCircle() {
        Coord c;
        float radius;

        do {
            c = createRandomCoord();
            radius = (float)(Math.random() * playFieldSize / MAX_SIDE_RADIUS_DIVISOR);
        }
        while (c.getX() - radius < 0 || c.getX() + radius > playFieldSize ||
                c.getY() - radius < 0 || c.getY() + radius > playFieldSize);

        return new Circle(c.getX(), c.getY(), radius);
    } // createRandomCircle
} // ShapeFactory
