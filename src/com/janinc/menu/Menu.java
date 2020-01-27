package com.janinc.menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

abstract public class Menu {
    protected ArrayList<MenuChoice> currentMenu;

    private Consumer statusMessageFunction;

    abstract public ArrayList<MenuChoice> setInitialMenu();

    public Menu(){
        statusMessageFunction = null;
    } // Menu

    public Menu(Consumer statusMessageFunction){
        super();
        this.statusMessageFunction = statusMessageFunction;
    } // Menu

    protected void setMenu(Object o) {
        currentMenu = (ArrayList<MenuChoice>) o;
    } // setMenu

    private void printMenu() {

        if (statusMessageFunction != null)
            statusMessageFunction.accept(null);
        else
            System.out.println("");

        for (MenuChoice m : currentMenu) System.out.printf("%s%n", m.getFullTitle());

        System.out.print("Ange ditt val: ");
    } // printMenu

    // Hämta användarens val
    private MenuChoice getMenuChoice() {
        String sChoice;
        Scanner scan = new Scanner(System.in);

        // Se till så att det finns ett menyval och inte en tomrad (blir så efter nextDouble)
        do
            sChoice = scan.nextLine();
        while (sChoice.length() == 0);

        // Loopa igenom och returnera rätt menyval
        for (MenuChoice m : currentMenu) {
            if (m.getKey() == sChoice.charAt(0))
                return m;
        } // for...
        return null;
    } // getMenuChoice

    public void handleMenu() {
        currentMenu = setInitialMenu();

        MenuChoice m;
        boolean bStop = false;
        while (!bStop) {
            printMenu();

            m = getMenuChoice();
            if (m == null)
                System.out.println("Felaktigt val, försök igen!");
            else {
                System.out.printf("Du valde: %s%n", m.getTitle());
                bStop = m.getFunctionToCall() == null;
                if (!bStop) {
                    m.getFunctionToCall().accept(m.getParameter());
                } // if bStop...
            } // else
        } // while
    } // handleMenu
} // class Menu
