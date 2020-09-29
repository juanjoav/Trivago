/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import models.Admin;
import models.Hotel;

import java.util.Scanner;

/**
 * Esta clase el testeo de la clase admin
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 26/09/2020
 */
public class TestAdmin {
    Admin admin;
    Scanner scanner;

    /**
     * Constructor por defecto
     */
    public TestAdmin() {
        this.admin = new Admin(new Hotel());
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo para registrar el numevo usuario
     */
    public void modficeUser(){
        System.out.println("Digite el nuevo nombre de usuario: ");
        String aux = scanner.nextLine();
        admin.setAdminNickName(aux);
    }

    /**
     * Metodo para modificar la contraseña
     */
    public void modificePassword(){
        System.out.println("Digite la nueva contraseña: ");
        String aux = scanner.nextLine();
        admin.setAdminPassword(aux);
    }

    /**
     *metodo apra testear la verificacion
     */
    public void verify(){
        System.out.println("Digite usuario: ");
        String user = scanner.nextLine();
        System.out.println("Digite contraseña: ");
        String passsword = scanner.nextLine();
        if(admin.verifiqueIndenty(user,passsword)){
            System.out.println("Verificado");
        }else{
            System.out.println("No verificado");
        }
    }

    /**
     *Metodo que testea todos los anteriores
     */
    public void run(){
        System.out.println("1. Modificar usuario\n2. Modiicar contraseña\n3. Verficar usuario\n 4.Salir");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                modficeUser();
                break;
            case 2:
                modificePassword();
                break;
            case 3:
                verify();
                break;
            case 4:
                return;
            default:
                run();
        }
        run();
    }

    public static void main(String[] args) {
        new TestAdmin().run();
    }
}
