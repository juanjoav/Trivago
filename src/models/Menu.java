/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.Arrays;
import java.util.LinkedList;

public class Menu {

    private LinkedList<String[]> normalMenu;
    private LinkedList<String[]> veganMenu;
    private LinkedList<String[]> specialMenu;
    private double normalPrice;
    private double veganPrice;
    private double specialPrice;

    /**
     * Metodo constructor parametrizado
     */
    public Menu() {
        normalMenu = new LinkedList<>();
        veganMenu = new LinkedList<>();
        specialMenu = new LinkedList<>();
    }

    /**
     * Metodo que nos permite agragar un nuevo menu normal
     * @param strings cadenas de catarteres que iran dentro del menu
     */
    public void addMenuNormal(String[] strings){
        normalMenu.add(strings);
    }

    /**
     * Metodo que nos permite agragar un nuevo menu vegano
     * @param strings cadenas de catarteres que iran dentro del menu
     */
    public void addMenuVegan(String[] strings){
        veganMenu.add(strings);
    }

    /**
     * Metodo que nos permite agragar un nuevo menu especial
     * @param strings cadenas de catarteres que iran dentro del menu
     */
    public void addMenuSpecial(String[] strings){
        specialMenu.add(strings);
    }

    /**
     * Este medoto nos devuelve el precio del un menu normal
     * @return el precio del menú
     */
    public double getPriceNormal(){
        return normalPrice;
    }
    /**
     * Este medoto nos devuelve el precio del un menu vegano
     * @return el precio del menú
     */
    public double getPriceVegan(){
        return veganPrice;
    }
    /**
     * Este medoto nos devuelve el precio del un menu especial
     * @return el precio del menú
     */
    public double getPriceSpecial(){
        return specialPrice;
    }

    /**
     * Este metodo nos permite darle un precio al menu normal
     * @param normalPrice precio del menu normal
     */
    public void setPriceNormal(double normalPrice){
        this.normalPrice = normalPrice;
    }

    /**
     * Este metodo nos permite darle un precio al menu vegano
     * @param veganPrice precio del menu vegano
     */
    public void setPriceVegan(double veganPrice){
        this.veganPrice = veganPrice;
    }

    /**
     * Este metodo nos permite darle un precio al menu normal
     * @param specialPrice precio del menu especial
     */
    public void setPriceSpecial(double specialPrice){
        this.specialPrice = specialPrice;
    }

    /**
     * Este metodo elimina el menu normal
     */
    public void removeMenuNormal(){
        normalMenu.remove();
    }

    /**
     * Este metodo elimina el menu vegano
     */
    public void removeMenuVegan(){
        veganMenu.remove();
    }

    /**
     * Este metodo elimina el menu especial
     */
    public void removeMenuSpecial(){
        specialMenu.remove();
    }

    /**
     * Metodo que nos permite mostrar el contenido del menu normal
     * @return
     */
    public String showNormalMenu(){
        String aux = "";
        for (String[] i: normalMenu) {
            aux += Arrays.toString(i);
        }
        return aux;
    }

    /**
     * Metodo que nos permite mostrar el contenido del menu normal
     * @return
     */
    public String showVeganMenu(){
        String aux = "";
        for (String[] i: veganMenu) {
            aux += Arrays.toString(i);
        }
        return aux;
    }

    /**
     * Metodo que nos permite mostrar el contenido del menu normal
     * @return
     */
    public String showSpecialMenu(){
        String aux = "";
        for (String[] i: specialMenu) {
            aux += Arrays.toString(i);
        }
        return aux;
    }
}
