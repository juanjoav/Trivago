/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public abstract class Menu {


    /**
     * @return retorna el menú
     */
    public abstract String[] getMenu();

    /**
     * Este medoto nos devuelve el precio del un determinado menu
     * @return el precio del menú
     */
    public abstract double getPrice();



}
