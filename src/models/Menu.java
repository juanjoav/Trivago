/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public abstract class Menu {

    private String[] inPutMenu;

    /**
     * Ingresa un menu
     */
    protected abstract void setMenu();

    /**
     *
     * @return retorna el menú
     */
    public abstract String[] getMenu();

    /**
     *
     * @return el precio del menú
     */
    public abstract double getPrice();



}
