/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

import java.util.Scanner;
/**
 * Esta clase hace el testeo de la clase Room
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 26/09/2020
 */
public class TestRoom {
    private Scanner scanner;
    private Admin setRoom;

    /**
     * Metodo constructor por defecto
     */
    public TestRoom() {
        scanner = new Scanner(System.in);
        setRoom = new Admin(new Hotel());
    }

    /**
     * Metodo que testea la inicializacion de las habitaciones regualares
     */
    public void  regular(){
        System.out.print("Digite cuantas habitaciones reguales quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            setRoom.addRoom(Quality.REGULAR);
        }
    }

    /**
     * Metodo que testea la inicializacion de las habitaciones premium
     */
    public void  premium(){
        System.out.print("Digite cuantas habitaciones premium quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            setRoom.addRoom(Quality.PREMIUM);
        }
    }

    /**
     * Metodo que testea la inicializacion de las habitaciones economicas
     */
    public void  economic(){
        System.out.print("Digite cuantas habitaciones economicas quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            setRoom.addRoom(Quality.ECONOMICA);
        }
    }

    /**
     * Metodo que testea la ocupaciond de las habitaciones
     */
    public void ocupation(){
        System.out.print("Digite cuales habitaciones quiere (Calidad): ");
        String quality = scanner.nextLine();
        Room[] rooms = new Room[]{};
        if(quality.equalsIgnoreCase("Regular")){
            rooms = setRoom.getAnyRoom(Quality.REGULAR);
        }else if(quality.equalsIgnoreCase("Premium")){
            rooms = setRoom.getAnyRoom(Quality.PREMIUM);
        }else if(quality.equalsIgnoreCase("Ecomonico")||quality.equalsIgnoreCase("Economica")){
            rooms = setRoom.getAnyRoom(Quality.ECONOMICA);
        }
        for (int i = 0; i < setRoom.getTotalRooms(); i++) {
            System.out.println(setRoom.toStringRoom(i));
        }
        System.out.print("Cuantas habitaciones quiere ocupar: ");
        int rounds = Integer.parseInt(scanner.nextLine());
        int roomming = 0;
        for (int i = 0; i < rounds; i++) {
            System.out.print("Digite El numero de la habitacion: ");
            roomming = Integer.parseInt(scanner.nextLine());
            new Event().assingRoom(setRoom.getRoom(roomming));
            System.out.println(setRoom.getRoom(roomming).isOcupation()?"Exitoso":"Error");
        }
    }

    /**
     * Metodo que muestra los test realizados
     */
    public void showCount(){
        System.out.println("El numero de habitaciones disponibles: "+setRoom.getCounterOcupation(false));
        System.out.println("El numero de habitaciones no disponibles: "+setRoom.getCounterOcupation(true));
        System.out.println("El numero de habitaciones Regulares: "+setRoom.getQualityCounter(Quality.REGULAR));
        System.out.println("El numero de habitaciones Premium: "+setRoom.getQualityCounter(Quality.PREMIUM));
        System.out.println("El numero de habitaciones Economico: "+setRoom.getQualityCounter(Quality.ECONOMICA));

    }

    /**
     * Metodo que corre el test
     */
    public void run(){
        regular();
        economic();
        premium();
        ocupation();
        showCount();

    }
    public static void main(String[] args) {
        new TestRoom().run();
    }
}
