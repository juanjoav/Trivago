/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * Esta clase hace la implementacion de los pagos
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 27/09/2020
 */
public class Pay {
    private PaymentType paymentType;
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

    /**
     * Metodo constructor parametrizado
     * @param entry Tipo de entrada
     */
    public Pay(Entry entry) {
        this.paymentType = PaymentType.EFECTIVO;
        this.entry = entry;
        this.season = Season.BAJA;
    }

    /**
     * Metodo constructor por defecto
     */
    public Pay(){
    }

    /**
     * Metodo me retorna el valor exacto segun la calidad de la habitacion y la temporada que sea
     * @param room una habitacion
     * @return el valor exacto segun la calidad de la habitacion y la temporada que sea
     */
    public double getSeasonRoomPay(Room room){
        if(getSeason() == Season.ALTA && room.getQuality() == (Quality.ECONOMICA)){
            return PRICE_ROOM_ECONOMIC * 2;
        }else if(getSeason() == (Season.BAJA) && room.getQuality() == (Quality.ECONOMICA)){
            return PRICE_ROOM_ECONOMIC;
        }else if(getSeason() == (Season.ALTA) && room.getQuality() == (Quality.REGULAR)){
            return PRICE_ROOM_REGULAR * 2;
        }else if(getSeason() ==(Season.BAJA) && room.getQuality() == (Quality.REGULAR)){
            return PRICE_ROOM_REGULAR;
        }else if(getSeason() == (Season.ALTA) && room.getQuality() == (Quality.PREMIUM)){
            return PRICE_ROOM_PREMIUM * 2;
        }else{
            return PRICE_ROOM_PREMIUM;
        }
    }

    /**
     * Metodo para automatizar el descuento o el aumento
     * @return el descuento o aumento de cada pago
     */
    public double getIncreaseDiscount(){
        return getEntry() == (Entry.BOOKING)?INCREASE_DISCOUNT*-1:INCREASE_DISCOUNT;
    }

    /**
     * Metodo para ver el descuento del tipo de pago
     * @return el descuento del tipo de pago
     */
    public double discountPay(){
        if(paymentType == (PaymentType.TARJETA)){
            return DISCOUNT_CARD;
        }else if(paymentType == (PaymentType.VIRTUAL)){
            return DISCOUNT_VIRTUAL;
        }else{
            return DISCOUNT_CASH;
        }
    }

    /**
     * Metodo que obtiene el valor final del pago del mismo
     * @param include si es todo incluido o no
     * @param room una habitacion
     * @return  el valor final de la cuenta
     */
    public double getTotalFinal(boolean include, Room[] room){
        if(include){
            return getTotal(room) + ALLINCLUDE;
        }else{
            return getTotal(room) + NORMALINCLUDE;
        }
    }

    /**
     * Metodo que obtiene el valor total de cierto numero de habitaciones
     * @param rooms un arreglo de habitaciones
     * @return  el valor total de cierto numero de habitaciones
     */
    public double getTotal(Room[] rooms){
        return getTotalRoom(rooms) + (getTotalRoom(rooms)* discountPay()) + (getTotalRoom(rooms)*getIncreaseDiscount());
    }

    /**
     * Metodo para obtener el valor total de cierto numero de habitaciones
     * @param rooms todas las habitaciones
     * @return el valor total de cierto numero de habitaciones
     */
    public double getTotalRoom(Room[] rooms){
        double total = 0;
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i].isOcupation()) {
                total += getSeasonRoomPay(rooms[i]);
            }
        }
        return total;
    }

    /**
     *Metodo que obtiene el valor total para una reservacion
     * @param reservation una reservacion
     * @param index numero de la reservacion
     * @return el valor total a pagar por una reservacion
     */
    public double getTotalDays(Reservation reservation, int index){
        double buy = getSeasonRoomPay(reservation.getReservation(index).getRoom());
        int diferent = reservation.getReservation(index).getTimeFinish().getDayOfYear() - reservation.getReservation(index).getTimeInitial().getDayOfYear();

        return buy * diferent;
    }

    /**
     * Metodo que obtiene el valor del plan todo incluido
     * @return el valor del plan todo incluido
     */
    public static double getAllInclude() {
        return ALLINCLUDE;
    }

    /**
     * Metodo que obtiene el valor normal
     * @returnel valor del plan normal
     */
    public double getNormalinclude(){
        return  NORMALINCLUDE;
    }

    /**
     * Metodo que obtiene el m,etodo de pago
     * @return
     */
    public PaymentType getPayEvent() {
        return paymentType;
    }

    /**
     * Metodo que modifica el metodo de pago
     * @param paymentType
     */
    public void setPayEvent(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    /**
     *Metodo que obtiene la entrada de usuario
     * @returnla entrada del usuario
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     *Metodo que modifica la entrada del usuario
     * @param entry el tipo de entrada
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    /**
     *Metodo que obtiene la temporada
     * @return la temporada que se esta usando
     */
    public Season getSeason() {
        return season;
    }

    /**
     * Metodo que modifica la temporada
     * @param season
     */
    public void setSeason(Season season) {
        this.season = season;
    }
}
