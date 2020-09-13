/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class NormalMenu extends Menu {

    /**
     * Ingresa un menu normal
     */
    @Override
    protected void setMenu() {
        //por hacer...
    }

    /**
     * Metodo que retorna el menu normal
     * @return retorna el menú
     */
    @Override
    public String[] getMenu() {
        //por hacer..
        return new String[0];
    }

    /**
     * Retorna el precio del menu normal
     * @return el precio del menú
     */
    @Override
    public double getPrice() {
        return 0;
    }
}

