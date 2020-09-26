/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.Entry;
import models.Hotel;
import models.PayEvent;
import models.User;

public class TestUser {

    public static void main(String[] args) {
        User user = new User();

        user.addUser(new User("Mateo",2019,999999, PayEvent.EFECTIVO, Entry.valueOf("WALKING")));
        user.addUser(new User("juan",2009,999999, PayEvent.EFECTIVO, Entry.valueOf("holi")));
        user.addUser(new User("ateo",2019,999999, PayEvent.EFECTIVO, Entry.valueOf("WALKING")));
        user.addUser(null);
        user.viewList();
    }
}
