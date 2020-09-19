/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class Hotel {

    private Person [] personList;

    public Hotel() {
        personList = new Person[]{};
    }

    /**
     * Agrega Usuarios
     * @param user
     */
    public void addPerson(Person user){
        Person [] aux = new Person[personList.length + 1];
        System.arraycopy(personList,0,aux,0,personList.length);
        aux[personList.length - 1] = user;
        personList = aux;
    }

    public void viewUserInformation(){
                                            //revision de ubicacion
    }
}
