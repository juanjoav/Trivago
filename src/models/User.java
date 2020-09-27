/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * clase usuario solo con los valores necesarios y getters
 */

public class User implements Comparable<User>{

    private String name;
    private long id;
    private String password;
    private long phone;

    public User(String name, long phone, long id,String passaword) {
        this.name = name;
            this.id = id;
            this.phone = phone;
            this.password = passaword;
    }

    public User() {
    }

    /**
     * Metodo que retorna el nombre del usuario solicitado
     * @return el nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que retorna el id del usuario seleccionado
     * @return el id del usuario
     */
    public long getId() {
        return id;
    }

    /**
     * Metodo que retorna el telefono del usuario indicado
     * @return el telefono del usuario
     */
    public long getPhone() {
        return phone;
    }

    /**
     * Metodo que permite retornar la contraseña de un usuario dado
     * @return la contraseña
     */
    protected String getPassword() {
        return password;
    }

    /**
     * Metodo que permite ver toda la informacion del usuario
     * @return la informacion del usuario
     */
    public String viewUser(){
        return "| Nombre: " + name + " | Identificacion: " + id + " | Telefono: " + phone ;
    }


    @Override
    public int compareTo(User user) {
        return (int) (this.getId() - user.getId());
    }

}
