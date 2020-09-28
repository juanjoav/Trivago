/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class TestReservatiom {
    private Admin hotel;
    private Scanner scanner;
    private Reservation reservation;

    public TestReservatiom() {
        scanner = new Scanner(System.in);
        hotel = new Admin(new Hotel());
        reservation = new Reservation();
    }
    public void  regular(){
        System.out.print("Digite cuantas habitaciones reguales quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.REGULAR);
        }
    }

    public void  premium(){
        System.out.print("Digite cuantas habitaciones premium quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.PREMIUM);
        }
    }

    public void  economic(){
        System.out.print("Digite cuantas habitaciones economicas quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            hotel.addRoom(Quality.ECONOMIC);
        }
    }

    public void choose(){
        System.out.print("Digite cuales habitaciones quiere (Calidad): ");
        String quality = scanner.nextLine();
        Room[] rooms = new Room[]{};
        if(quality.equalsIgnoreCase("Regular")){
            rooms = hotel.getAnyRoom(Quality.REGULAR);
        }else if(quality.equalsIgnoreCase("Premium")){
            rooms = hotel.getAnyRoom(Quality.PREMIUM);
        }else if(quality.equalsIgnoreCase("Ecomonico")||quality.equalsIgnoreCase("Economica")){
            rooms = hotel.getAnyRoom(Quality.ECONOMIC);
        }
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(rooms[i].getNumber()+" "+rooms[i].getQuality()+" "+(rooms[i].isOcupation()?"Ocuapdo" : "No ocupado"));
        }
    }
    public void principal(){
        System.out.print("Digite la habitacion a reservar: ");
        int numbRoom = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite la fecha de inicio a registrar (YYYY-MM-DD) :");
        String dateFirst = scanner.nextLine();
        System.out.println("Digite la fecha de final a registrar (YYYY-MM-DD):");
        String dateFinish = scanner.nextLine();
        //LocalDate localDateInitional = LocalDate.of(Integer.parseInt(dateFirst[2]), Month.of(Integer.parseInt(dateFirst[1])),Integer.parseInt(dateFirst[0]));
        LocalDate localDateInitional = LocalDate.parse(dateFirst);
        LocalDate localDateFinish = LocalDate.parse(dateFinish);
        boolean large = reservation.makeBooking(new Event(localDateInitional,localDateFinish,
                new User("Harrison",1l,2l,"123"),hotel.getRoom(numbRoom)));
        System.out.println("El proceso fue : "+(large?"Exitoso":"Fallido"));
    }
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
        new TestReservatiom().run();
    }
}
