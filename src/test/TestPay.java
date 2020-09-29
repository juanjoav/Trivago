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

    /**
     * Metodo constructor por defecto
     */
    public TestPay() {
        pay = new Pay();
        scanner = new Scanner(System.in);
        admin = new Admin(new Hotel());
    }

    /**
     * Metodo que testea las habiatciones regulares
     */
    public void  regular(){
        System.out.print("Digite cuantas habitaciones reguales quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.REGULAR);
        }
    }

    /**
     * Metodo que testea las habitaciones premium
     */
    public void  premium(){
        System.out.print("Digite cuantas habitaciones premium quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.PREMIUM);
        }
    }

    /**
     * Metodo que testeta las habitaciones economicas
     */
    public void  economic(){
        System.out.print("Digite cuantas habitaciones economicas quiere: ");
        int roundOne = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < roundOne; i++) {
            admin.addRoom(Quality.ECONOMICA);
        }
    }

    /**
     * Metodo que testea el tipo de pago
     */
    public void type(){
        System.out.println("Tipo de pago(efectivo,tarjeta,virtual):");
        String string = scanner.nextLine();
        if(string.equalsIgnoreCase("virtual")){
            pay.setPayEvent(PaymentType.VIRTUAL);
        }else if(string.equalsIgnoreCase("tarjeta")){
            pay.setPayEvent(PaymentType.TARJETA);
        }else{
            pay.setPayEvent(PaymentType.EFECTIVO);
        }
        System.out.println("Tipo de entrada(walk,reserva)");
        String stringTwo = scanner.nextLine();
        if(stringTwo.equalsIgnoreCase("reserva")){
            pay.setEntry(Entry.BOOKING);
        }else{
            pay.setEntry(Entry.WALKING);
        }

    }

    /**
     * Metodo testea la cantidad de habitaciones
     */
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

    /**
     * Metodo qeu testea el total a pagar
     */
    public void pay(){
        Room[] room = admin.getAnyRoom(true);
        System.out.println("El total a pagar es de : $"+pay.getTotal(room));
    }

    /**
     * Metodo que muestra el total a pagar
     */
    public void show(){
        for (int i = 0; i < admin.getTotalRooms(); i++) {
            System.out.println(admin.toStringRoom(i));
        }
    }

    /**
     * Metodo que testea el cambio de temporada
     */
    public void season(){
        System.out.println("Digite la temprada(alta , baja)");
        String string = scanner.nextLine();
        if(string.equalsIgnoreCase("alta")){
            pay.setSeason(Season.ALTA);
        }else{
            pay.setSeason(Season.BAJA);
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
