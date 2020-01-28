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

    public MainMenu(Consumer statusMessageFunction, CMOOP app) {
        super(statusMessageFunction);

        mainMenu.add(new MenuChoice("Ändra antal punkter", '1', app::getNumPoints));
        mainMenu.add(new MenuChoice("Ändra antal cirklar", '2', app::getNumCircles));
        mainMenu.add(new MenuChoice("Ändra antal kvadrater", '3', app::getNumRectangles));
        mainMenu.add(new MenuChoice("Ändra fältets storlek", '4', app::getPlayfieldSize));
        mainMenu.add(new MenuChoice("Slumpa objekt (kör)", '5', app::start));
        mainMenu.add(new MenuChoice("Lista alla objekt", '6', app::listShapes));
        mainMenu.add(new MenuChoice("Avsluta", '0', null));
    } // MainMenu

    @Override
    public ArrayList<MenuChoice> setInitialMenu() {
        return (ArrayList<MenuChoice>) mainMenu;
    } // setInitialMenu
} // class Menu
