/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.time.LocalDate;


public abstract class Event {
    private LocalDate time;
    private User user;
    private Room room;

    /**
     * GetTime nos retorna el dia del evento
     * @return localdate value
     */
    public LocalDate getTime() {
        return time;
    }
}
