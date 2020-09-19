/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class NormalMenu extends Menu {

private static final double PRICE_NORMAL_MENU = 5.0;

private String[] inPutMenu;


    /**
     * Ingresa un menu normal
     */
    protected void setMenu(String[] inPutMenu) {
        this.inPutMenu = new String[]{};
    }

    /**
     * Metodo que retorna el menu normal
     * @return retorna el menú
     */
    @Override
    public String[] getMenu() {
        return inPutMenu;
    }

    /**
     * Retorna el precio del menu normal
     * @return el precio del menú
     */
    @Override
    public double getPrice() {
        return PRICE_NORMAL_MENU;
    }
}

