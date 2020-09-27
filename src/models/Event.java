/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;


public class Event {
    private LocalDate timeInitial;
    private LocalDate timeFinish;
    private User user;
    private Room room;

    public Event(LocalDate timeInitial, LocalDate timeFinish, User user, Room room) {
        this.timeInitial = timeInitial;
        this.timeFinish = timeFinish;
        this.user = user;
        this.room = room;
    }

    public LocalDate getTimeInitial() {
        return timeInitial;
    }

    public void setTimeInitial(LocalDate timeInitial) {
        this.timeInitial = timeInitial;
    }

    public LocalDate getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(LocalDate timeFinish) {
        this.timeFinish = timeFinish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
