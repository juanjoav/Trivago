/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


/**
 * Esta clase hace la implementacion de los menus del restaurante
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 19/09/2020
 */
public class Menu {

    String name;
    String characterises;
    double price;

    /**
     * Metodo constructor parametrizado
     * @param name nombre del menu
     * @param characterises platos que va llevar el menu del dia
     * @param price el precio del menu
     */
    public Menu(String name, String characterises, double price) {
        this.name = name;
        this.characterises = characterises;
        this.price = price;
    }

    /**
     * Metodo constructor por defecto
     */
    public Menu(){
    }

    /**
     * Metodo que nos permite darle formato a los menus
     * @return un formato para mostrar el menu
     */
    public String formatMenus() {
        return "Menu : " + getName() + " | Los platos del dia son: " + getCharacterises() + " | El precio es: " + getPrice() + " $";
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
    public String getCharacterises() {
        return characterises;
    }

    /**
     * Metodo para obtener el precio del menu
     * @return el precio del menu
     */
    public double getPrice() {
        return price;
    }
}