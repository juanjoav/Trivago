/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.*;

/**
 * clase usuario solo con los valores necesarios y getters
 */

public class User implements Comparable<User>{

    private String name;
    private long id;
    private long phone;
    private PayEvent cashPayEvent;
    private Entry entry;
//    private boolean condition = false;
  //  private TreeSet<User> userTreeSet;

    public User(String name, long id, long phone, PayEvent cashPayEvent, Entry entry) {
        //super(name, id);
            this.name = name;
            this.id = id;
            this.phone = phone;
            this.cashPayEvent = cashPayEvent;
            this.entry = entry;
    }

    public User() {
//        userTreeSet = new TreeSet<User>(new Comparator<User>() {
//            @Override
//            public int compare(User user, User t1) {
//                return (int)(user.getId() - t1.getId());
//            }
//        });
    }

    /**
     * agrega usuarios
     * @param user
     */
//    public void addUser(User user){
//        try {
//            userTreeSet.add(user);
//        }
//        catch (NullPointerException ex){
//            System.out.println("valor invalido");
//        }
//    }

    /**
     * retorna el nombre
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * retorna el id
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * retorna el telefono
     * @return
     */
    public long getPhone() {
        return phone;
    }

    /**
     * retorna la forma de pago
     * @return
     */
    public String getCashPayEvent() {
        return "" + cashPayEvent;
    }

    /**
     * retorna la condicion de entrada
     * @return
     */
    public String getEntry() {
        return "" + entry;
    }

    /**
     * indica en que condicion se encuentra el usuario
     * @return
     */
//    public String conditionStatus(){
//        return condition ? "En el hotel": "no esta en el hotel";
//    }

    /**
     * retorna una lista para que el admin la gestione
     * @return
     */
//    public List getUserList(){
//        List<User> userArrayList = new LinkedList<User>();
//        userArrayList.addAll(userTreeSet);
//        //userArrayList = (List) userTreeSet.clone();
////        for (User user: userArrayList) {
////            System.out.println(user.viewUser());
////        }
//        return userArrayList;
//    }

    /**
     * muestra los elementos en forma de String
     * @return
     */
    public String viewUser(){
        return name + "-" + id + "-" + phone + "-" + cashPayEvent + "-" + entry;
    }
    public User getUser(){
        return new User(name,id,phone,cashPayEvent,entry);
    }
    @Override
    public int compareTo(User user) {
        return (int) (this.getId() - user.getId());
    }

    /**
     * solo para pruebas
     */
//    public void viewList(){
//        for (User user: userTreeSet) {
//            System.out.println(user.viewUser());
//        }
//    }
}
