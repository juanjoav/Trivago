/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class SpecialMenu extends Menu{

    private static final double PRICE_SPECIAL_MENU = 15.0;
    private String[] inPutMenu;

    /**
     * Ingresa un menu especial
     */
    protected void setMenu(String[] inPutMenu) {
        this.inPutMenu = new String[]{};
    }

    /**
     * retorna el menu epecial
     * @return retorna el menú
     */
    @Override
    public String[] getMenu() {
        return inPutMenu;
    }

    /**
     * retorna el precio del menu especial
     * @return el precio del menú especial
     */
    @Override
    public double getPrice() {
        return PRICE_SPECIAL_MENU;
    }
}
