/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * Esta clase administra la toda la parte operativa del hotel
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 12/09/2020
 */

public class Admin {

    private String adminNickName = "ADMIN";
    private String adminPassword = "1234";

    private Menu menu;
    private Hotel hotel;

    /**
     * Metodo constructor parametrizado
     * @param hotel el hotel a administrar
     */
    public Admin(Hotel hotel) {
        menu = new Menu();
        this.hotel = hotel;
    }

    /**
     * Metodo constructor por defecto
     */
    public Admin() {
    }

    /**
     * Metodo para modificar la contraseña del administrador
     * @param adminPassword recibe la nueva contraseña del administrador
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * Metodo para modificar el nombre del administrador
     * @param adminNickName el nombre del administrador
     */
    public void setAdminNickName(String adminNickName) {
        this.adminNickName = adminNickName;
    }

    /**
     * Metodo oara verificar la identidad del administrador
     * @param name el nombre del admin
     * @param passaword la contraseña del administrador
     * @return verdadero si la informacion es correcta falso si no
     */
    public boolean verifiqueIndenty(String name, String passaword){
        return name.equals(adminNickName) && passaword.equals(adminPassword);
    }

    /**
     * Metodo que le permite a un administrador añadir un menua una lista
     * @param menu menu que desea ingresar
     * @return un mensaje de confirmacion
     */
    public String addMenu(Menu menu){
        String message = "";
        hotel.menus.add(menu);
        return "Menu agregado";
    }

    /**
     *Metodo que le permite al administrador eliminar un menu
     * @param menuName el nombre del menu que se desea eliminar
     */
    public void removeMenu(String menuName){
        for (int i = 0; i < hotel.menus.size() ; i++) {
            if(hotel.menus.get(i).getName().equalsIgnoreCase(menuName)){
                hotel.menus.remove(i);
            }
        }
    }

    /**
     * Metodo que retorna todos la lista de usuarios
     * @return la lista de usuarios
     */
    public String[] showUser(){
        String[] aux = new String[hotel.userTreeSet.size()];
        int count = 0;
        for (User i: hotel.userTreeSet) {
            aux[count] = i.viewUser();
            count++;
        }
        return aux;
    }

    /**
     * Metodo que muestra el usuario consultado por ID
     * @param id id del ususario
     * @return la informacion del usuario
     */
    public String searchUser(long id){
        String info = "";
        for (User user: hotel.userTreeSet) {
            if (user.getId() == id){
                info = user.viewUser();
                return info;
            }
        }
        return info;
    }

    /**
     * Para encontrar el total de habitaciones
     * @return el numero total
     */
    public int getTotalRooms(){
        return hotel.getSizeRooms();
    }

    /**
     * Metodo para contar cuantas habitaciones hay en una calidad en especifico
     * @param quality calidad de una habitacion
     * @return el numerod e habitaciones
     */
    public int getQualityCounter(Quality quality){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Metodo para contar cuantas habitaciones estan disponibles hay en una calidad en especifico
     * @param quality calidad de una havbiatcion
     * @param ocupation si esta o no ocupada una habitacion
     * @return el numero de habitaciones
     */
    public int getAvariableQuality(Quality quality, boolean ocupation){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality && hotel.getRoom(i).isOcupation() == ocupation){
                counter++;
            }
        }
        return counter;
    }


    /**
     * Metodio para ver  el total de habitaciones no ocupadas del establecimiento
     * @param ocupation si esta ocupado o no
     * @return total de habitaciones disponibles
     */
    public int getCounterOcupation(boolean ocupation){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).isOcupation() == ocupation){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room una nueva habitacion
     */
    public void addRoom(Room room){
        hotel.addRoom(room);
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param quality calidad de una habitacion
     */
    public void addRoom(Quality quality){
        hotel.addRoom(quality);
    }

    /**
     * Metodo para decir que una habitacion esta fuera de serivicio
     * @param numb numero de habitacion
     * @param out si esta o no fuera de servicio
     */
    public void outOfService(int numb, boolean out){
        hotel.getRoom(numb).setOcupation(out);
    }

    /**
     *Metodo para obtener cualquier habitacion del arreglo
     * @param index el numero de la habitacion
     * @return una habitacion del arreglo
     */
    public Room getRoom(int index){
        return hotel.getRoom(index);
    }

    /**
     * Metodo para obtener las habitaciones a partir de la calidad de las mismas
     * @param quality calidad de una habitracion
     * @return as habitaciones
     */
    public Room[] getAnyRoom(Quality quality){
        Room[] aux = new Room[getQualityCounter(quality)];
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality){
                aux[counter] = hotel.getRoom(i);
                counter++;
            }
        }
        return aux;
    }

    /**
     * Metodo para obtener las habitaciones a partir de la calidad de las mismas
     * @param ocupation la ocupocion de una habitacion
     * @return l las habitaciones cada calidad
     */
    public Room[] getAnyRoom(boolean ocupation){
        Room[] aux = new Room[getCounterOcupation(ocupation)];
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).isOcupation() == ocupation){
                aux[counter] = hotel.getRoom(i);
                counter++;
            }
        }
        return aux;
    }

    /**
     * Metodo para obtener las habitaciones
     * @return la cantidad de habitaciones
     */
    public String[] showAllRooms(){
        String[] aux = new String[getTotalRooms()];
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            aux[i] = toStringRoom(i);
        }
        return aux;
    }

    /**
     * Metodo para mostrar la informacion de una habitacion en la posicion
     * @param index numero de la habitacion
     * @return mensaje completo
     */
    public String toStringRoom(int index){
        return "N°: "+hotel.getRoom(index).getNumber()+" Calidad: "+hotel.getRoom(index).getQuality()+"  Estado: "+(hotel.getRoom(index).isOcupation()?"Ocupado":"No ocuapdo");
    }
}
