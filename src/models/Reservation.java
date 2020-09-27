/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Reservation{
    public List<Event> reservation;

    public Reservation() {
        reservation = new LinkedList<>();
    }

    /**
     * Administra la reservacion
     * @param event
     * @return
     */
    public boolean makeBooking(Event event){
        reservation.add(event);
        int index = reservation.indexOf(event);
       if(LocalDate.now().isAfter(event.getTimeInitial())){
         new CheckIn(reservation.get(index)).assingRoom(reservation.get(index).getRoom());
       }else if(LocalDate.now().isBefore(event.getTimeFinish())){
           new CheckOut(reservation.get(index)).outRooms(reservation.get(index).getRoom());
       }else{
           return false;
       }
        return true;
    }

    /**
     * Remueve el evento
     *
     */
//    public void removeBooking(Hotel hotel, long id){
//        reservation.remove(reservation.indexOf(hotel.searchUser(id)));
//    }
}
