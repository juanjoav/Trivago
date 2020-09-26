/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.Arrays;
import java.util.List;

public class NormalMenu extends Menu {

    private  double priceNormalMenu;


    /**
     * Metodo que nos permite agragar un nuevo menu
     * @param strings cadenas de catarteres que iran dentro del menu
     */
    @Override
    public void addMenu(String[] strings) {
        menus.add(strings);
    }

    /**
     * Metodo que nos retorna el nemu
     * @return retorna el menú
     */
    @Override
    public List getMenu() {
        return menus;
    }

    /**
     * Metodo que nos retorna la lista para mostrarla por pantalla
     * @return
     */
    @Override
    public String show (){
        String aux = "";
        for (String[] i: menus) {
           aux += Arrays.toString(i);
        }
        return aux;
    }

    /**
     * Retorna el precio del menu normal
     * @return el precio del menú
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Este metodo nos permite darle un precioa cada menu
     * @param price precio de cada menu
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Este metodo eliminar un menu
     */
    @Override
    public void removeMenu() {
        menus.clear();
    }
}

