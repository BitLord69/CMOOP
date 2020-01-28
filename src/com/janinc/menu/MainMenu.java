package com.janinc.menu;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-27
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.CMOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainMenu extends Menu {
    private List<MenuChoice> mainMenu = new ArrayList<>();

    public MainMenu(@SuppressWarnings("rawtypes") Consumer statusMessageFunction, CMOOP app) {
        super(statusMessageFunction);

        mainMenu.add(new MenuChoice("Ändra antal punkter", '1', app::getNumPoints));
        mainMenu.add(new MenuChoice("Ändra antal cirklar", '2', app::getNumCircles));
        mainMenu.add(new MenuChoice("Ändra antal kvadrater", '3', app::getNumRectangles));
        mainMenu.add(new MenuChoice("Ändra fältets storlek", '4', app::getPlayfieldSize));
        mainMenu.add(new MenuChoice("Kör ordnad lista med nya objekt", '5', this::runOrderedList, app));
        mainMenu.add(new MenuChoice("Kör slumpad lista med nya objekt", '6', this::runScrambledList, app));
        mainMenu.add(new MenuChoice("Kör ordnad lista med samma objekt", '7', this::runOrderedListReused, app));
        mainMenu.add(new MenuChoice("Kör slumpad lista med samma objekt", '8', this::runScrambledListResued, app));
        mainMenu.add(new MenuChoice("Lista objekt från senaste körning", '9', app::listShapes));
        mainMenu.add(new MenuChoice("Avsluta", '0', null));
    } // MainMenu

    public void runOrderedList(Object o){
        ((CMOOP)o).start(true, true);
    } // runOrderedList

    public void runScrambledList(Object o){
        ((CMOOP)o).start(false, true);
    } // runOrderedList

    public void runOrderedListReused(Object o){
        ((CMOOP)o).start(true, false);
    } // runOrderedListReused

    public void runScrambledListResued(Object o){
        ((CMOOP)o).start(false, false);
    } // runScrambledListResued

    @Override
    public ArrayList<MenuChoice> setInitialMenu() {
        return (ArrayList<MenuChoice>) mainMenu;
    } // setInitialMenu
} // class Menu
