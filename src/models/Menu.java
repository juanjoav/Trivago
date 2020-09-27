/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class Menu {

    String name;
    String characterics;
    double price;

    /**
     * Metodo constructor parametrizado
     * @param name nombre del menu
     * @param characterics platos que va llevar el menu del dia
     * @param price el precio del menu
     */
    public Menu(String name, String characterics, double price) {
        this.name = name;
        this.characterics = characterics;
        this.price = price;
    }

    /**
     * Metodo que nos permite darle formalo a los menus
     * @return un formato para mostrar el menu
     */
    public String showMenus() {
        return "Menu : " + getName() + " | Los platos del dia son: " + getCharacterics() + " | El precio es: " + getPrice() + " $";
    }

    /**
     * Metodo para obtener el nombre del menu
     * @return el nombre de un menu
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para obtener las caracteristicas del menu
     * @return las caracteristicas del menu
     */
    public String getCharacterics() {
        return characterics;
    }

    /**
     * Metodo para obtener el precio del menu
     * @return el preci del menu
     */
    public double getPrice() {
        return price;
    }
}