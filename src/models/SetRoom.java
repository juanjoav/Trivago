/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * Clase para administrar la variedad de habitaiones
 */
public class SetRoom {
    private Room[][] rooms;

    public SetRoom() {
        rooms = new Room[10][10];
    }

    /**
     * Para encontrar el total de habitaciones
     * @return el numero total
     */
    public int getTotalRooms(){
        return rooms.length * rooms[0].length;
    }

    /**
     * mirar el total de habitaciones no ocupadas del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getAvailable(){
        int counter = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j].isOcupation()==false){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Para meterle los numero automaticamente los numeros de cada habitacion
     */
    private void SetNumberRooms(){
        int counter = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                counter++;
                rooms[i][j].setNumber(counter);
            }
        }
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param size para mirar que tamaño es la longitud de cada fila de matriz
     */
    public void setSize(int size){
        Room [] aux = new Room[size];
        for (int i = 0; i < rooms.length; i++) {
            System.arraycopy(rooms[i],0,aux,0,rooms[i].length);
            rooms[i] = aux;
        }
        SetNumberRooms();
    }
}
