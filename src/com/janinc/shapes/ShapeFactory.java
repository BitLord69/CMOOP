package com.janinc.shapes;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public class ShapeFactory {
    private int playFieldSize;

    public ShapeFactory(int playFieldSize) {
        this.playFieldSize = playFieldSize;
    } // ShapeFactory

    public Coord createRandomCoord(){
        return new Coord((int)(Math.random() * playFieldSize), (int)(Math.random() * playFieldSize));
    } // createRandomCoord

    public Rect createRandomRect() {
        Coord c;
        int side;

        do {
            c = createRandomCoord();
            side = (int)(Math.random() * playFieldSize / 4);
        }
        while (c.getX() - side / 2 < 0 || c.getX() + side / 2 > playFieldSize ||
                c.getY() - side / 2 < 0 || c.getY() + side / 2 > playFieldSize);

        return new Rect(c.getX(), c.getY(), side);
    } // createRandomRect

    public Circle createRandomCircle() {
        Coord c;
        int radius;

        do {
            c = createRandomCoord();
            radius = (int)(Math.random() * playFieldSize / 4);
        }
        while (c.getX() - radius < 0 || c.getX() + radius > playFieldSize ||
                c.getY() - radius < 0 || c.getY() + radius > playFieldSize);

        return new Circle(c.getX(), c.getY(), radius);
    } // createRandomCircle
} // ShapeFactory
