///*
// * Copyright (c) 12/9/2020.
// * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
// * All rights reserved
// */
//
//package models;
//
//import java.time.LocalDate;
//
//public class CheckIn extends Event {
//
//    public CheckIn(LocalDate timeInitial, LocalDate timeFinish, User user, Room room) {
//        super(timeInitial, timeFinish, user, room);
//    }
//
//    public CheckIn(Event event){
//        super(event.getTimeInitial(),event.getTimeFinish(),event.getUser(), event.getRoom());
//    }
//
//    /**
//     * Para asignar la entrada a la habitaciones
//     * @param room para mirar cada habitacion
//     */
//    public void assingRoom(Room room){
//        room.setOcupation(true);
//    }
//}
