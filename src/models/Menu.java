/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.LinkedList;
import java.util.List;

public abstract class Menu {

    LinkedList<String[]> menus;
    double price;

    /**
     * Metodo constructor por defecto
     */
    public Menu() {
        menus = new LinkedList<>();
    }

    /**
     * Metodo que nos permite agragar un nuevo menu
     * @param strings cadenas de catarteres que iran dentro del menu
     */
    public abstract void addMenu(String[] strings);

    /**
     * metodo que nos retorna la lista
     * @return retorna el menú
     */
    public abstract List getMenu();

    /**
     * Este medoto nos devuelve el precio del un determinado menu
     * @return el precio del menú
     */
    public abstract double getPrice();

    /**
     * Este metodo nos permite darle un precioa cada menu
     * @param price precio de cada menu
     */
    public abstract void setPrice(double price);

    /**
     * Este metodo eliminar un menu
     */
    public abstract void removeMenu();
}
