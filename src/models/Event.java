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
     * Constructo para introducir todos los datos
     * @param timeInitial
     * @param timeFinish
     * @param user
     * @param room
     */
    public Event(LocalDate timeInitial, LocalDate timeFinish, User user, Room room) {
        this.timeInitial = timeInitial;
        this.timeFinish = timeFinish;
        this.user = user;
        this.room = room;
    }

    /**
     * Contructor que resive el parametro par inicializar a patir de otro evento
     * @param event objecto de la misma clase
     */
    public Event(Event event){
        this.timeInitial = event.getTimeInitial();
        this.timeFinish = event.getTimeFinish();
        this.user = event.getUser();
        this.room = event.getRoom();
    }

    /**
     * Clase default
     */
    public Event(){

    }
    /**
     * Para asignar la entrada a la habitaciones
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
     * obtiene el dia de llegada
     * @return
     */
    public LocalDate getTimeInitial() {
        return timeInitial;
    }

    /**
     * Modifica el timepo de llegada
     * @param timeInitial
     */
    public void setTimeInitial(LocalDate timeInitial) {
        this.timeInitial = timeInitial;
    }

    /**
     * obtine el dia de salida
     * @return
     */
    public LocalDate getTimeFinish() {
        return timeFinish;
    }

    /**
     * Modifica el dia de salida
     * @param timeFinish tiempo de ida
     */
    public void setTimeFinish(LocalDate timeFinish) {
        this.timeFinish = timeFinish;
    }

    /**
     * Obtiene un oibjeto de tipo usuario
     * @return onjecto User
     */
    public User getUser() {
        return user;
    }

    /**
     * Modifica el susario a partir de otroobjecto de tipo
     * usuario
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Metodo para obtener la habitacion
     * @return objeto de tipo habitacion
     */
    public Room getRoom() {
        return room;
    }

    /**
     * establece una habtacion
     * @param room un objeto de tipo habitacion
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}
