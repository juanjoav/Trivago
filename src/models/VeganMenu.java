///*
// * Copyright (c) 12/9/2020.
// * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
// * All rights reserved
// */
//
//package models;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//public class VeganMenu extends Menu {
//
//    public VeganMenu() {
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
//     * Metodo que retorna el menu vegano
//     * @return retorna el menú
//     */
//    @Override
//    public List getMenu() {
//      return menus;
//    }
//
//    /**
//     * Metodo que muestra el menu vegano
//     * @return una cadena de caracteres con el menu
//     */
//    @Override
//    public String show (){
//        String aux = "";
//        for (String[] i: menus) {
//            aux += Arrays.toString(i);
//        }
//        return aux;
//    }
//
//    /**
//     * Retorna el precio del menu vegano
//     * @return el precio del menú
//     */
//    @Override
//    public double getPrice() {
//        return price;
//    }
//
//    /**
//     * Este metodo nos deja ingresar un precio a cada menu
//     * @param price el precio del menu vegano
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
