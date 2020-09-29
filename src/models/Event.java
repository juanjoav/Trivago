/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;

/**
 * Esta clase hace la implementacion de un objeto de Evento
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 12/09/2020
 */
public class Event {
    private LocalDate timeInitial;
    private LocalDate timeFinish;
    private User user;
    private Room room;

    /**
     * Metodo onstructo para introducir todos los datos
     * @param timeInitial tiempo inicial
     * @param timeFinish tiempo final
     * @param user un usuario
     * @param room una habitacion
     */
    public Event(LocalDate timeInitial, LocalDate timeFinish, User user, Room room) {
        this.timeInitial = timeInitial;
        this.timeFinish = timeFinish;
        this.user = user;
        this.room = room;
    }

    /**
     * Metodo constructor que resive el parametro par inicializar a patir de otro evento
     * @param event objecto de la misma clase
     */
    public Event(Event event){
        this.timeInitial = event.getTimeInitial();
        this.timeFinish = event.getTimeFinish();
        this.user = event.getUser();
        this.room = event.getRoom();
    }

    /**
     * Metodo constructor por defecto
     */
    public Event(){
    }
    /**
     * Metodo para asignar la entrada a la habitaciones
     * @param room para mirar cada habitacion
     */
   public void assingRoom(Room room){
      room.setOcupation(true);
   }

    /**
     * Metodo para asignar laas habitaciones
     * @param room para mirar cada habitacion
     */
    public void outRooms(Room room){
        room.setOcupation(false);
    }

    /**
     * Metodo que obtiene el dia de llegada
     * @return una fecha de llegada
     */
    public LocalDate getTimeInitial() {
        return timeInitial;
    }

    /**
     * Metodo que obtine el dia de salida
     * @return una fecha de salida
     */
    public LocalDate getTimeFinish() {
        return timeFinish;
    }

    /**
     * Metodo que obtiene un oibjeto de tipo usuario
     * @return objecto User
     */
    public User getUser() {
        return user;
    }

    /**
     * Metodo para obtener la habitacion
     * @return objeto de tipo habitacion
     */
    public Room getRoom() {
        return room;
    }

}
