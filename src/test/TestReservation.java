/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * Esta clase hace lel testeo de la clase Reservation
 * @author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @date 12/09/2020
 */
public class TestReservation {

    private Admin hotel;
    private Scanner scanner;
    private Reservation reservation;

    /**
     * Metodo constructor poor defecto
     */
    public TestReservation() {
        scanner = new Scanner(System.in);
        hotel = new Admin(new Hotel());
        reservation = new Reservation();
    }

    /**
     * Metodo que testea lacantidad de habitaciones regulares a reservar
     */
    public void  regular(){
        System.out.print("Digite cuantas habitaciones reguales quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.REGULAR);
        }
    }

    /**
     * Metodo que testea lacantidad de habitaciones premium a reservar
     */
    public void  premium(){
        System.out.print("Digite cuantas habitaciones premium quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.PREMIUM);
        }
    }

    /**
     * Metodo que testea lacantidad de habitaciones economicas a reservar
     */
    public void  economic(){
        System.out.print("Digite cuantas habitaciones economicas quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.ECONOMICA);
        }
    }

    /**
     * Metodo que testea la calidad de habitaciones a elegir
     */
    public void choose(){
        System.out.print("Digite cuales habitaciones quiere (Calidad): ");
        String quality = scanner.nextLine();
        Room[] rooms = new Room[]{};
        if(quality.equalsIgnoreCase("Regular")){
            rooms = hotel.getAnyRoom(Quality.REGULAR);
        }else if(quality.equalsIgnoreCase("Premium")){
            rooms = hotel.getAnyRoom(Quality.PREMIUM);
        }else if(quality.equalsIgnoreCase("Ecomonico")||quality.equalsIgnoreCase("Economica")){
            rooms = hotel.getAnyRoom(Quality.ECONOMICA);
        }
        for (int i = 0; i < rooms.length; i++) {
            System.out.println();
        }
    }

    /**
     * Metodo que testea el proceso completo de la reserva
     */
    public void principal(){
        System.out.print("Digite la habitacion a reservar: ");
        int numbRoom = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite la fecha de inicio a registrar (YYYY-MM-DD) :");
        String dateFirst = scanner.nextLine();
        System.out.println("Digite la fecha de final a registrar (YYYY-MM-DD):");
        String dateFinish = scanner.nextLine();
        LocalDate localDateInitional = LocalDate.parse(dateFirst);
        LocalDate localDateFinish = LocalDate.parse(dateFinish);
        boolean large = reservation.makeBooking(new Event(localDateInitional,localDateFinish,
                new User(" ",1l,2l,"123"),hotel.getRoom(numbRoom)));
        System.out.println("El proceso fue : "+(large?"Exitoso":"Fallido"));
    }

    /**
     * Metodo que llama los demas test
     */
    public void run(){
        regular();
        premium();
        economic();
        choose();
        System.out.print("Cuantas habitaciones quiere reservar: ");
        int round = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < round; i++) {
            principal();
        }
    }
    public static void main(String[] args) {
        new TestReservation().run();
    }
}
