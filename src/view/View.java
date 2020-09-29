/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package view;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Esta clase hace comunicacion entre el usuario y el controlador
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 27/09/2020
 */
public class View {

    private Scanner scanner;

    public static final int MENU_OPTION_ONE = 1;
    public static final int MENU_OPTION_TWO = 2;
    public static final int MENU_OPTION_TRHEE = 3;
    public static final int MENU_OPTION_FOUR = 4;
    public static final int MENU_OPTION_FIVE = 5;
    public static final int MENU_OPTION_SIX = 6;
    public static final int MENU_OPTION_SEVEN = 7;

    public static final String MESSAGE_FORMAR_EX = "PARAMETROS INVALIDOS";
    public static final String WELCOME_ASCCI = "°·.¸.·°¯°·.¸.·°¯°·.¸.-> ░H░o░t░e░l░ ░A░s░c░e░n░t░ <-·.¸.·°¯°·.¸.·°¯°·.¸.°";
    public static final String LINE = "-------------------------------------------";
    public static final String SELECTION_MENU = "Por favor elija el tipo de acceso que desea al sitema\n1.)Administrador\n2.)Usuarios ";
    public static final String REQUEST_NAME = "Por favor ingrese el nombre del usuario: ";
    public static final String REQUEST_PASSWORD = "Por favor ingrese una contraseña: ";
    public static final String TITTLE_ADMIN = "MENU DEL ADMINISTRADOR";
    public static final String TITTLE_USER = "MENU DEL USUARIO";
    public static final String NAME_MENU = "Por favor ingrese el tipo de menu que desea agregar: ";
    public static final String REMOVE_MENU = "Por favor ingrese el nombre del menu que desea eliminar:";
    public static final String CONTAINS_MENU = "Por favor en una sola linea agregue los elementos que va a tener el menu del dia: ";
    public static final String PRICE_MENU = "Agregue el precio que tendra el menu: ";
    public static final String OPTIONS_USER = "1.) Registrarse \n2.) Iniciar secion\n3.) Regresar";
    public static final String OPTION_MENU_ADMIN = "1.) Administrar menus\n2.) Administrar usuarios \n3.) Administrar habitaciones\n4.) Cambiar nombre de admin\n5.) Cambiar contraseña\n6.) Gestar Eventos\n7). Generar pago\n8.) Cerrar seccion";
    public static final String OPTION_MENU = "1.) Agregar menu\n2.) Retirar un menu\n3.) Modificar un menu\n4.) Mostrar menus\n5.) Para volver";
    public static final String OPTION_ADMIN_USER = "1.) Agregar un usuario\n2.) Ver lista de usuarios\n3.) Buscar un usuario\n4.) Para volver";
    public static final String OPTION_ADMIN_USER_ROOM = "1.)Control de habitaciones\n2.)Modificar habitaciones\n3.)Cambiar estado de una habitacion\n4.)Añadir habitaciones\n5.) Mirar todas las habitaciones\n6.)Regresar";
    public static final String OPTION_MENU_ROOM = "1.)Estado de habitaciones\n2.)Cantidad de habitaciones segun la calidad\n3.) Cantidad de habitaciones disponibles segun la calidad\n4.) Regresar";
    public static final String OPTION_RESERVATION = "Elija una opcion para ver:\n1.)Habitaciones ocupadas \n2.)Habitaciones No ocupadas" ;
    public static final String OPTION_EVENTS_MENU= "Eventos:\n1.)Entra de cliente\n2.)Salida del cliente\n3.)Hacer reservacion\n4.)Cambiar temporada\n5.)Regresar" ;
    public static final String USER_ID = "Ingrese el ID de usuario";
    public static final String INITIAL_DATE = "Ingrese la fecha inicial en el siguiente formato\nAAAA-MM-DD (NOTA! Recuerde separar las fechas con un guion '-'";
    public static final String USER_PHONE = "Ingrese el telefono del usuario";
    public static final String USER_PASSWORD = "Por favor ingrese su contraseña";
    public static final String ENDING_DATE = "Ingrese la fecha final en el siguiente formato\nAAAA-MM-DD (NOTA! Recuerde separar las fechas con un guion '-'";
    public static final String SEARCH_MESSAGE = "Busqueda por ID de usuarios";
    public static final String ERROR_VALUES = "ADVERTENCIA! A ingresado un valor invalido";
    public static final String CHANGES_MESSAGE = "Cambios realizados con exitos";
    public static final String OBTAIN_QUALITY = "Ingrese una de las siguientes categorias \nECONOMICA~REGULAR~PREMIUM";
    public static final String ROOM_OCUPATED_MESSAGE = "Habitaciones ocupadas";
    public static final String NUMBER_ROOM = "Ingrese el numero de la habitacion: ";
    public static final String ROOM_FREE_MESSAGE = "HabitacioneS desocupadas";
    public static final String ROOM_PER_QUALITY = "Las cantidad de habitaciones encontradas son ";
    public static final String DISABLE_ROOM = "Elija una de las siguientes opciones\n1.)Para desabilitar una habitacion\n2.)Para habilitar una habitacion";
    public static final String ROOM_ERROR_MESSAGE = "Advertencia! La habitacion buscada no existe";
    public static final String ACCESS_GRANTED_MESSAGE = "Acceso concedido";
    public static final String ACCESS_DENIED_MESSAGE = "Usuario y/o contraseña incorrectos";
    public static final String MESSAGE_EVENT_CHECK_IN = "Ingreso registrado";
    public static final String MESSAGE_EVENT_CHECK_OUT = "Retiro registrado";
    public static final String MESSAGE_ITERATIONS = "¿Cuantas habitaciones fueron?";
    public static final String MESSAGE_ICLUDE = "Obtuvo el plan todo incuido\n1.Si\n2.No";
    public static final String RESERVATION_MESSAGE = "Reservacion realizada con exito";
    public static final String MESSAGE_PAY = "El total a pagar es :$";
    public static final String MESSAGE_PAYMENTTYPE = "Tipo de pago(Efectivo,Tarjeta,Virtual): ";
    public static final String USER_MENU_OPTION = "1.) Consultar menus\n2.) Consula habitaciones\n3.) Crear reservacion\n4.) Pagar\n5.) Cerrar secion";
    public static final String CHANGE_SEASON = "Temporada(Alta, Baja): ";
    public static final String MESSAGE_CHANGE_SEASON = "Cambio efectuado correctamente";

    public View() {
        scanner = new Scanner(System.in);
    }

    /**
     * Menu de opciones para elegir usuarios
     * @return
     */
    public int selectionMenu() {
        System.out.println(WELCOME_ASCCI);
        System.out.println(LINE);
        System.out.println(SELECTION_MENU);
        System.out.println(LINE);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que permite enviar el nickName de usuario y/o admin
     * @return el nombre del usuario
     */
    public String nickName(){
        System.out.println(LINE);
        System.out.println(REQUEST_NAME);
        System.out.println(LINE);
        return scanner.nextLine();
    }

    /**
     * Metodo que permite enviar la contraseña respectiva
     * @return la contraseña respectiva
     */
    public String password(){
        System.out.println(LINE);
        System.out.println(REQUEST_PASSWORD);
        System.out.println(LINE);
        return scanner.nextLine();
    }
///////////////////////////ADMINS//////////////////////////////////////////

    /**
     * Metodo que permite enviar la seleccion de opciones del admin
     * @return un entero con la opvion del usuario
     */
    public int adminOption(){
        System.out.println(LINE + TITTLE_ADMIN + LINE);
        System.out.println(OPTION_MENU_ADMIN);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que permite el ingreso de una de las opciones que dispone el usuario sobre la clase menu
     * @return un entero con la opcion elejida
     */
    public int adminMenuOption(){
        System.out.println(OPTION_MENU);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo para elejir una opcion del manejo de usuarios por el administrador
     * @return un entero con la opcion elejida
     */
    public int adminUserMenu(){
        System.out.println(OPTION_ADMIN_USER);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo para elejir una opcion sobre le manejo de las habitaciones
     * @return un entero con las opciones elejidas
     */
    public int adminUserRoom(){
        System.out.println(OPTION_ADMIN_USER_ROOM);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     *
     * @return
     */
    public int viewRoomsMenu(){
        System.out.println(OPTION_MENU_ROOM);
        return Integer.parseInt(scanner.nextLine());
    }

    /////////////////////////////MENUS/////////////////////////////////////////////////

    /**
     * Metodo que permite enviar el nombre
     * @return el nombre 
     */
    public String menuName(){
        System.out.println(NAME_MENU);
        return scanner.nextLine();
    }

    /**
     * Metodo que nso permite recibiel el tipo de menu que desea eliminar
     * @return un scanner para recibir el valor
     */
    public String deleteMenu(){
        System.out.println(REMOVE_MENU);
        return scanner.nextLine();
    }

    /**
     * Metodo que envia los datos que contiene cada menu
     * @return el contenido de cada menu
     */
    public String menuContains(){
        System.out.println(CONTAINS_MENU);
        return scanner.nextLine();
    }

    /**
     * Metodo que envia los datos del precio de cada menu
     * @return el precio de cada maenu
     */
    public double menuPrice(){
        System.out.println(PRICE_MENU);
        return Double.parseDouble(scanner.nextLine());
    }
    /////////////////////////////////////////////////////USER//////////////////////////////////////////////////////////////

    /**
     * Metodo que permite elejir una opcion por parte del usuario
     * @return la opcion elejida por el usuario
     */
    public int userMenu(){
        System.out.println(LINE + TITTLE_USER + LINE);
        System.out.println(OPTIONS_USER);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Menu con las opciones de usuario
     * @return
     */
    public int menuUser(){
        System.out.println(USER_MENU_OPTION);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     *Metodo que permite obtener el ID
     * @return el id del usuario
     */
    public long getId(){
        System.out.println(USER_ID);
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * Metodo que envia el telefono del usuario
     * @return el telefono ingresado
     */
    public long getphone(){
        System.out.println(USER_PHONE);
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * Metodo que permite solicitar una contraseña
     * @return la contraseña solicitada
     */
    public String getPassaword(){
        System.out.println(USER_PASSWORD);
        return scanner.nextLine();
    }

/**
 //    public String getCashEvent(){
 //        System.out.println("Agregar la forma de pago");
 //        System.out.println("1.) EFECTIVO \n2.) TARJETA \n3.) VIRTUAL");
 //        return (scanner.nextLine());
 //    }
 //                                                                                  //revision pendiente para la eliminacion
 //    public String entryCondition(){
 //        System.out.println("Agregar la forma de registro");
 //        System.out.println("1.) WALKING \n 2.) BOOKING");
 //        return scanner.nextLine();
 //    }
 */

/////////////////////////////////////////////////ROOMS//////////////////////////////////////////////////////////////

    /**
     * Metodo para hacer el criterio de busqueda de usuario
     * @return
     */
    public boolean reservationOption(){
        System.out.println(OPTION_RESERVATION);
        return Integer.parseInt(scanner.nextLine()) == MENU_OPTION_ONE;
    }

    /**
     * Metodo que permite ingresar el numero de una habitacion
     * @return un entero ingresado por el usuario
     */
    public int numberRoom(){
        System.out.println(NUMBER_ROOM);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que permite ingresar la calidad de la habitacion
     * @return la calidad de la habitacion ingresada por el usuario
     */
    public String obtainQuality(){
        System.out.println(OBTAIN_QUALITY);
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Metodo que permite elegir la condicion de una habitacion
     * @return un boolean con la opcion dada
     */
    public boolean disablesRoom(){
        System.out.println(DISABLE_ROOM);
        return Integer.parseInt(scanner.nextLine()) == 1;
    }

    //////////////////////////////////////////EVENTOS/////////////////////////////////////////////////////////////

    /**
     * Metodo que permite elegir entre las opciones de los eventos para el administrador
     * @return
     */
    public int adminEventsMenu(){
        System.out.println(OPTION_EVENTS_MENU);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que permite ingresar una fecha inicial
     * @return la fecha ingresada por el usuario o administrador
     */
    public String addInitialDate(){
        System.out.println(INITIAL_DATE);
        return scanner.nextLine();
    }

    /**
     * Metodo que permite ingresar una fecha inicial
     * @return la fecha ingresada por el usuario o administrador
     */
    public String addIEndingDate(){
        System.out.println(ENDING_DATE);
        return scanner.nextLine();
    }

    /**
     * Metodo para ingresar la temporada
     * @return la temporada que ingresa el susario
     */
    public String changeSeason(){

        return scanner.nextLine();
    }

    //////////////////////////////////////////////////////PAGO/////////////////////////////////////////////////////////////

    /**
     * Para demostrar si un plan es el normal o el todo incluido
     * @return
     */
    public int allInclude(){
        System.out.println(MESSAGE_ICLUDE);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * para mostrar el total de pago
     * @param pay el pago completo
     */
    public void showPay(double pay){
        System.out.println(MESSAGE_PAY + pay);
    }

    public String getPaymentType(){
        System.out.println(MESSAGE_PAYMENTTYPE);
        return scanner.nextLine().toUpperCase();
    }
    /////////////////////////////////////////////////////RETORNOS//////////////////////////////////////////////////////////

    /**
     * Metodo que recibe Elementos para mostrar al admin y/o usuarios
     * @param message el parametro que desea mostrar
     */
    public void viewMessages(String message){
        System.out.println( message);
    }

    /**
     * Metodo que recibe una lista de elementos para mostrar
     * @param lists la lista que desea mostrar
     */
    public void viewList(String [] lists){
        for (String string:lists) {
            System.out.println(string);
        }
    }

    public int getInt(){
        return Integer.parseInt(scanner.nextLine());
    }
}
