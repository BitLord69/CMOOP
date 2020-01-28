package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.iface.ICollide;
import com.janinc.menu.MainMenu;
import com.janinc.shapes.Circle;
import com.janinc.shapes.Coord;
import com.janinc.shapes.ShapeFactory;

import java.util.*;

public class CMOOP {
    private int playfieldSide = 100;
    private int numPoints = 5;
    private int numCircles = 5;
    private int numRectangles = 5;

    private List<Coord> shapes = new ArrayList<>();

    public CMOOP() {
        new MainMenu(this::printStatusMsg, this).handleMenu();
        System.out.println("Tack för idag och hej då!");
    } // CMOOP

    private void printStatusMsg(Object o) {
        System.out.printf("%nNuvarande inställningar: %d punkter, %d cirklar, %d rektanglar, spelfältets storlek %d X %d%n",
                numPoints, numCircles, numRectangles, playfieldSide, playfieldSide);
    } // printStatusMsg

    private int getInput(String prompt, int oldVal) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt + " [" + oldVal + "]: ");

        int tal = 0;
        boolean bBadInput = true;

        do {
            try {
                tal = scan.nextInt();
                if (scan.nextLine().equals(""))
                    bBadInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Hoppsan, det var visst inte ett heltal. Försök igen!");
                scan.nextLine();
            } // catch
        } while (bBadInput);
        return tal;
    } // getInput

    public void getNumPoints(Object o) {
        numPoints = getInput("Vänligen mata in antal punkter", numPoints);
    }  // getNumPoints

    public void getNumCircles(Object o) {
        numCircles = getInput("Vänligen mata in antal cirklar", numCircles);
    }  // getNumCircles

    public void getNumRectangles(Object o) {
        numRectangles = getInput("Vänligen mata in antal rektanglar", numRectangles);
    }  // getNumRectangles

    public void getPlayfieldSize(Object o) {
        playfieldSide = getInput("Vänligen mata in spelfältets storlek", playfieldSide);
    }  // getPlayfieldSize

    public void start(boolean useUnscrambledList, boolean createNewList) {
        List<Coord> runList;
        int numHits = 0;
        int checks = 0;

        if (createNewList) {
            shapes = new ArrayList<>();
            ShapeFactory sf = new ShapeFactory(playfieldSide);
            for (int i = 0; i < numPoints; i++) shapes.add(sf.createRandomCoord());
            for (int i = 0; i < numCircles; i++) shapes.add(sf.createRandomCircle());
            for (int i = 0; i < numRectangles; i++) shapes.add(sf.createRandomRect());
        } // if createNewList
        else
            if (shapes.size() == 0){
                System.out.println("Du måste köra en omgång innan du kan återanvända objekten!");
                return;
            } // else

        if (useUnscrambledList)
            runList = shapes;
        else{
            runList = new ArrayList<>(shapes);
            Collections.shuffle(runList);
        } // else

        for (int i = 0; i < runList.size(); i++) {
            for (int j = i + 1; j < runList.size(); j++) {
                checks++;
                if (isCollision(runList.get(i), runList.get(j))){
                    numHits++;
                    System.out.printf("Collision! => %s\t\tcollided with\t\t%s%n", runList.get(i), runList.get(j));
                } // if shapes...
            } // for j...
        } // for i...

        System.out.printf("%nAntal kollisioner: %d av %d möjliga%n", numHits, checks);
    } // start

    private boolean isCollision(ICollide iCollide1, ICollide iCollide2) {
        // Make sure that the circle always is called upon when detecting for collision
        // This makes the code less messy in the shapes classes, but perhaps not better...
        if (iCollide2 instanceof Circle) {
            ICollide iTemp = iCollide1;
            iCollide1 = iCollide2;
            iCollide2 = iTemp;
        } // isCollide2...
        return iCollide1.isCollisionDetected(iCollide2);
    } // isCollision

    public void listShapes(Object o){
        if (shapes.size() == 0)
            System.out.println("Du måste köra en omgång innan du kan lista objekten!");
        else
            for (Coord c: shapes) System.out.println(c);
    } // listShapes
} // class CMOOP
