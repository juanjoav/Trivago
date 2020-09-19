/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class VeganMenu extends Menu {

    private static final double PRICE_VEGAN_MENU = 10.0;
    private String[] inPutMenu;

    /**
     * Ingresa un menu vegano
     */
    protected void setMenu(String[] inPutMenu) {
        this.inPutMenu = new String[]{};
    }

    /**
     * Metodo que retorna el menu vegano
     * @return retorna el menú
     */
    @Override
    public String[] getMenu() {
      return inPutMenu;
    }

    /**
     * Retorna el precio del menu vegano
     * @return el precio del menú
     */
    @Override
    public double getPrice() {
        return PRICE_VEGAN_MENU;
    }
}
