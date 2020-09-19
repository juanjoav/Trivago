/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * clase usuario solo con los valores necesarios y getters
 */

public class User extends Person {

    private long phone;
    private PayEvent cashPayEvent;
    private Entry entry;
    private boolean condition;

    public User(String name, long id, long phone, PayEvent cashPayEvent, Entry entry) {
        super(name, id);
        this.phone = phone;
        this.cashPayEvent = cashPayEvent;
        this.entry = entry;
    }

    public long getPhone() {
        return phone;
    }

    public PayEvent getCashPayEvent() {
        return cashPayEvent;
    }

    public Entry getEntry() {
        return entry;
    }
}
