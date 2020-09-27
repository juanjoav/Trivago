/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;

public class CheckOut extends Event {

    public CheckOut(LocalDate timeInitial, LocalDate timeFinish, User user, Room room) {
        super(timeInitial, timeFinish, user, room);
    }

    public CheckOut(Event event){
        super(event.getTimeInitial(),event.getTimeFinish(),event.getUser(), event.getRoom());
    }
    /**
     * Metodo para asignar laas habitaciones
     * @param room para mirar cada habitacion
     */
    public void outRooms(Room room){
        room.setOcupation(false);
    }
}
