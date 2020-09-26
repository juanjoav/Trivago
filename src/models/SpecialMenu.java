///*
// * Copyright (c) 12/9/2020.
// * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
// * All rights reserved
// */
//
//package models;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class SpecialMenu extends Menu{
//
//
//    public SpecialMenu() {
//    }
//
//
//    /**
//     * Metodo que nos permite agragar un nuevo menu
//     * @param strings cadenas de catarteres que iran dentro del menu
//     */
//    @Override
//    public void addMenu(String[] strings) {
//        menus.add(strings);
//    }
//
//    /**
//     * Metodo que nos retorna la lista
//     * @return retorna el menú
//     */
//    @Override
//    public List getMenu() {
//        return menus;
//    }
//
//    /**
//     * Metodo que nos muestra el menu
//     * @return una cadena de caracteres con los valores del menu
//     */
//    public String show (){
//        String aux = "";
//        for (String[] i: menus) {
//            aux += Arrays.toString(i);
//        }
//        return aux;
//    }
//
//
//    /**
//     * retorna el precio del menu especial
//     * @return el precio del menú especial
//     */
//    @Override
//    public double getPrice() {
//        return price;
//    }
//
//    /**
//     * Este metodo nos permite darle un precioa cada menu
//     * @param price precio de cada menu
//     */
//    @Override
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    /**
//     * Este metodo eliminar un menu
//     */
//    @Override
//    public void removeMenu() {
//        menus.clear();
//    }
//}
