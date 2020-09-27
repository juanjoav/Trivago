/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Reservation{
    List<Event> events;

    public Reservation() {
        events = new LinkedList<>();
    }

    /**
     * Administra la reservacion
     * @param event
     * @return
     */
    public boolean makeBooking(Event event){
        events.add(event);
        int index = events.indexOf(event);
       if(LocalDate.now().isBefore(event.getTimeInitial())){
          new CheckIn(events.get(index)).assingRoom(events.get(index).getRoom());
       }else if(LocalDate.now().isAfter(event.getTimeFinish())){
           new CheckOut(events.get(index)).outRooms(events.get(index).getRoom());
       }else{
           return false;
       }
        return true;
    }

    /**
     * Remueve el evento
     * @param event
     * @return
     */
    public boolean removeBooking(Event event){
        return events.remove(event);
    }
}
