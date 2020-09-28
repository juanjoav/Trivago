/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * Clase para gestiodar el pago
 */
public class Pay {
    private PayEvent payEvent;
    private Entry entry;
    private Season season;
    private static final double PRICE_ROOM_REGULAR = 50;
    private static final double PRICE_ROOM_ECONOMIC = 30;
    private static final double PRICE_ROOM_PREMIUM = 80;
    private static final double INCREASE_DISCOUNT = 0.15;
    private static final double ALLINCLUDE = 60;
    private static final double NORMALINCLUDE = 40;
    private static final double DISCOUNT_CASH = 0;
    private static final double DISCOUNT_CARD = -0.05;
    private static final double DISCOUNT_VIRTUAL = -0.1;

    public Pay(PayEvent payEvent, Entry entry) {
        this.payEvent = payEvent;
        this.entry = entry;
        this.season = Season.LOWER;
    }

    public Pay(){
    }

    /**
     * Metodo me retorna el valor exacto segun la calidad
     * de la habitacion y la temporada que sea
     * @param room
     * @return
     */
    public double getSeasonRoomPay(Room room){
        if(season.equals(Season.HIGHER) && room.getQuality().equals(Quality.ECONOMIC)){
            return PRICE_ROOM_ECONOMIC * 2;
        }else if(season.equals(Season.LOWER) && room.getQuality().equals(Quality.ECONOMIC)){
            return PRICE_ROOM_ECONOMIC;
        }else if(season.equals(Season.HIGHER) && room.getQuality().equals(Quality.REGULAR)){
            return PRICE_ROOM_REGULAR * 2;
        }else if(season.equals(Season.LOWER) && room.getQuality().equals(Quality.REGULAR)){
            return PRICE_ROOM_REGULAR;
        }else if(season.equals(Season.HIGHER) && room.getQuality().equals(Quality.PREMIUM)){
            return PRICE_ROOM_PREMIUM * 2;
        }else{
            return PRICE_ROOM_PREMIUM;
        }
    }

    /**
     * Para automatizar el descuento o el aumento
     * @return
     */
    public double getIncreaseDiscount(){
        return entry.equals(Entry.BOOKING)?INCREASE_DISCOUNT*-1:INCREASE_DISCOUNT;
    }

    /**
     * Para ver el descuento del tipo de pago
     * @return
     */
    public double getdiscountPay(){
        if(payEvent.equals(PayEvent.CARD)){
            return DISCOUNT_CARD;
        }else if(payEvent.equals(PayEvent.VIRTUAL)){
            return DISCOUNT_VIRTUAL;
        }else{
            return DISCOUNT_CASH;
        }
    }
    public static double getAllInclude() {
        return ALLINCLUDE;
    }

    public double getNormalinclude(){
        return  NORMALINCLUDE;
    }

    public PayEvent getPayEvent() {
        return payEvent;
    }

    public void setPayEvent(PayEvent payEvent) {
        this.payEvent = payEvent;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
