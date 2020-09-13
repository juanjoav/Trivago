/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class SpecialMenu extends Menu{
    /**
     * Ingresa un menu especial
     */
    @Override
    protected void setMenu() {

    }

    /**
     * retorna el menu epecial
     * @return retorna el menú
     */
    @Override
    public String[] getMenu() {
        return new String[0];
    }

    /**
     * retorna el precio del menu especial
     * @return el precio del menú especial
     */
    @Override
    public double getPrice() {
        return 0;
    }
}
