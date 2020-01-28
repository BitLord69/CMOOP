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

    private float getRandomNumber(){
        return (float)Math.random() * playFieldSize;
    } // getRandomNumber

    public Coord createRandomCoord(){
        return new Coord(getRandomNumber(), getRandomNumber());
    } // createRandomCoord

    public Rect createRandomRect() {
        float side;
        float x = getRandomNumber();
        float y = getRandomNumber();

        do {
            side = getRandomNumber() / MAX_SIDE_RADIUS_DIVISOR;
        }
        while (x - side / 2 < 0 || x + side / 2 > playFieldSize ||
                y - side / 2 < 0 || y + side / 2 > playFieldSize);

        return new Rect(x, y, side);
    } // createRandomRect

    public Circle createRandomCircle() {
        float radius;
        float x = getRandomNumber();
        float y = getRandomNumber();

        do {
            radius = getRandomNumber() / MAX_SIDE_RADIUS_DIVISOR;
        }
        while (x - radius < 0 || x + radius > playFieldSize ||
                y - radius < 0 || y + radius > playFieldSize);

        return new Circle(x, y, radius);
    } // createRandomCircle
} // ShapeFactory
