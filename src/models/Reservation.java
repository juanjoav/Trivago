/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase hace la implementacion de reservas
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 12/09/2020
 */
public class Reservation{
    public List<Event> reservation;

    /**
     * Metodo constructor por defecto
     */
    public Reservation() {
        reservation = new LinkedList<>();
    }

    /**
     * Metodo que administra la reservacion
     * @param event un evento
     * @return si se efectua una reservacion o no
     */
    public boolean makeBooking(Event event){
        reservation.add(event);
        int index = reservation.indexOf(event);
       if(LocalDate.now().isAfter(event.getTimeInitial())){
         new Event(reservation.get(index)).assingRoom(reservation.get(index).getRoom());
       }else if(LocalDate.now().isBefore(event.getTimeFinish())){
           new Event(reservation.get(index)).outRooms(reservation.get(index).getRoom());
       }else{
           return false;
       }
        return true;
    }

    /**
     * Metodo que elimina una reservacion
     */
    public void removeBooking(Event event){
      reservation.remove(event);
    }

    /**
     * Metodo que retorna una reservacion
     * @param index numero de la reservacion
     * @return objeto de tipo Evento
     */
    public Event getReservation(int index){
        return reservation.get(index);
    }
}
