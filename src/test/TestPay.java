/*
 * Copyright (c) 28/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

import java.util.Scanner;

public class TestPay {

    private Pay pay;
    private Scanner scanner;
    private Admin admin;

    public TestPay() {
        pay = new Pay();
        scanner = new Scanner(System.in);
        admin = new Admin(new Hotel());
    }

    public void  regular(){
        System.out.print("Digite cuantas habitaciones reguales quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.REGULAR);
        }
    }

    public void  premium(){
        System.out.print("Digite cuantas habitaciones premium quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.PREMIUM);
        }
    }

    public void  economic(){
        System.out.print("Digite cuantas habitaciones economicas quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.ECONOMIC);
        }
    }
    public void type(){
        System.out.println("Tipo de pago(efectivo,tarjeta,virtual):");
        String string = scanner.nextLine();
        if(string.equalsIgnoreCase("virtual")){
            pay.setPayEvent(PayEvent.VIRTUAL);
        }else if(string.equalsIgnoreCase("tarjeta")){
            pay.setPayEvent(PayEvent.CARD);
        }else{
            pay.setPayEvent(PayEvent.CASH);
        }
        System.out.println("Tipo de entrada(walk,reserva)");
        String stringTwo = scanner.nextLine();
        if(stringTwo.equalsIgnoreCase("reserva")){
            pay.setEntry(Entry.BOOKING);
        }else{
            pay.setEntry(Entry.WALKING);
        }

    }
    public void choose(){

        System.out.println("Cuantas habitaciones quiere : ");
        int rounds = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[rounds];
        for (int i = 0; i < rounds; i++) {
            System.out.println("Digite el numero de la habitacion: ");
            numbers[i] = Integer.parseInt(scanner.nextLine());
            new Event().assingRoom(admin.getRoom(numbers[i]));
        }
    }
    public void pay(){
        Room[] room = admin.getAnyRoom(true);
        System.out.println("El total a pagar es de : $"+pay.getTotalRoom(room));
    }
    public void show(){
        for (int i = 0; i < admin.getTotalRooms(); i++) {
            System.out.println(admin.toStringRoom(i));
        }
    }
    public void season(){
        System.out.println("Digite la temprada(alta , baja)");
        String string = scanner.nextLine();
        if(string.equalsIgnoreCase("alta")){
            pay.setSeason(Season.HIGHER);
        }else{
            pay.setSeason(Season.LOWER);
        }
    }
    public void run(){
        season();
        economic();
        regular();
        premium();
        type();
        show();
        choose();
        pay();
    }

    public static void main(String[] args) {
        new TestPay().run();
    }
}
