package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu_21292380_LagosLagos {
    System_21292380_LagosLagos system;
    List<Option_21292380_LagosLagos> options;
    List<Flow_21292380_LagosLagos> flows;
    List<Chatbot_21292380_LagosLagos> cbs;

    /**
     * Descripcion: Contructor de un objeto menu.
     */
    public Menu_21292380_LagosLagos() {
    }

    /**
     * Descripción: Menu principal que permite comenzar a registrar o iniciar sesión.
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void mostrarMenuPrincipal(System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n------ Menu Principal ------");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Iniciar Sesion");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                registrarUsuario(system);
                mostrarMenuPrincipal(system, options, flows, cbs);
                break;
            case 2:
                iniciarSesion(system, options, flows, cbs);
                mostrarMenuPrincipal(system, options, flows, cbs);
                break;
            case 3:
                System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpción no válida. Intente nuevamente.");
                mostrarMenuPrincipal(system, options, flows, cbs);
        }

    }

    /**
     * Descripción: Registra a un usuario en el sistema.
     * @param system
     */
    public void registrarUsuario(System_21292380_LagosLagos system) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("\n1. Usuario Normal");
        System.out.println("2. Usuario Admin");
        System.out.print("Seleccione el tipo de usuario: ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        List<ChatHistory_21292380_LagosLagos> ch = new ArrayList<>();
        Usuario_21292380_LagosLagos nuevoUsuario = new Usuario_21292380_LagosLagos(tipoUsuario == 2, nombreUsuario, ch);
        system.systemAddUser(nuevoUsuario);
    }

    /**
     * Descripción: Permite que un usuario inicie sesión.
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void iniciarSesion(System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        system.systemLogin(nombreUsuario);

        for (Usuario_21292380_LagosLagos user : system.getUsuarios()) {
            if (user.getNameUser().equals(nombreUsuario)) {
                if (user.getIsAdmin()) {
                    menuAdmin(user, system, options, flows, cbs);
                } else {
                    menuNormal(user, system);
                }
            }
        }
    }

    /**
     * Descripción: Muestra el menú del usuario administrador.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void menuAdmin(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Menu Usuario Admin ------");
            System.out.println("1. Comenzar con la creacion de un nuevo sistema");
            System.out.println("2. Interactuar con el sistema");
            System.out.println("3. Visualizar historial");
            System.out.println("4. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuCrearsistema(user, system, options, flows, cbs);
                case 2:
                    interactuarConSistema(user, system);
                    break;
                case 3:
                    visualizarHistorial(user, system);
                    break;
                case 4:
                    cerrarSesion(system);
                    return;
                default:
                    System.out.println("\nOpcion no valida. Intente nuevamente.");
            }
        }

    }

    /**
     * Descripción: Muestra el menú del usuario normal.
     * @param user
     * @param system
     */
    public void menuNormal(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Menu Usuario Normal ------");
            System.out.println("1. Interactuar con el sistema");
            System.out.println("2. Visualizar historial");
            System.out.println("3. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    interactuarConSistema(user, system);
                    break;
                case 2:
                    visualizarHistorial(user, system);
                    break;
                case 3:
                    cerrarSesion(system);
                    return;
                default:
                    System.out.println("\nOpcion no valida. Intente nuevamente.");
            }
        }
    }

    /**
     * Descripción: Permite interactuar con el sistema.
     * @param user
     * @param system
     */
    public void interactuarConSistema(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese su mensaje para el sistema: ");
        String mensaje = scanner.nextLine();

        system.systemtalk(mensaje);
    }

    /**
     * Descripción: Permite ver el historial del usuario que tiene la sesión iniciada.
     * @param user
     * @param system
     */
    public void visualizarHistorial(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system) {
        system.systemsynthesis(user.getNameUser());
    }

    /**
     * Descripción: Permite cerrar la sesión en el sistema.
     * @param system
     */
    public void cerrarSesion(System_21292380_LagosLagos system) {
        system.systemLogout();
    }

    /**
     * Descripción: Muestra el menú para poder crear un nuevo sistema.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void menuCrearsistema(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Menu: Crear nuevo sistema ------");
            System.out.println("Para un correcto uso de este menu seleccione la opcion 1 cuantas veces desee, " +
                    "\ny al terminar de crear opciones, pase a crear el flujo, luego puede crear " +
                    "\notras opciones para un segundo flujo o puede crear el chatbot y finalmente el sistema.");
            System.out.println(("Al terminar con la creacion del sistema se abrira un menu que permitira interactuar con el nuevo sistema."));
            System.out.println("1. Crear opciones");
            System.out.println("2. Crear flujo con las opciones creadas");
            System.out.println("3. Agregar una opcion a un flujo creado");
            System.out.println("4. Crear chatbot con los flujos creados");
            System.out.println("5. Agregar un flujo a un chatbot creado");
            System.out.println("6. Crear sistema con los chatbots creados");
            System.out.println("7. Volver al menu Admin para interactuar con el sistema predefinido");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearOp(user, system, options, flows, cbs);
                    break;
                case 2:
                    crearFl(user, system, options, flows, cbs);
                    break;
                case 3:
                    agregarop(user, system, options, flows, cbs);
                case 4:
                    crearCb(user, system, options, flows, cbs);
                case 5:
                    agregarFl(user, system, options, flows, cbs);
                case 6:
                    crearSis(user, system, options, flows, cbs);
                case 7:
                    menuAdmin(user, system, options, flows, cbs);
                default:
                    System.out.println("\nOpcion no valida. Intente nuevamente.");
            }
        }
    }

    /**
     * Descripción: Permite crear una opción.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void crearOp(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el codigo para la opcion: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el mensaje para la opcion: ");
        String message = scanner1.nextLine();
        //scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del chatbot para la opcion: ");
        int cbCode = scanner2.nextInt();
        scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del flujo para la opcion: ");
        int flCode = scanner3.nextInt();
        scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.print("\nIngrese una keyword para la opcion: ");
        String key = scanner4.nextLine();
        //scanner4.nextLine();

        List<String> keys = new ArrayList<>();
        keys.add(key);

        Option_21292380_LagosLagos op = new Option_21292380_LagosLagos(code, message, cbCode, flCode, keys);
        options.add(op);

        menuCrearsistema(user, system, options, flows, cbs);
    }

    /**
     * Descripción: Permite crear un flujo
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void crearFl(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el codigo para el flujo: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el mensaje para el flujo: ");
        String message = scanner1.nextLine();
        //scanner1.nextLine();

        Flow_21292380_LagosLagos fL = new Flow_21292380_LagosLagos(code, message, options);
        flows.add(fL);

        options = new ArrayList<>();

        menuCrearsistema(user, system, options, flows, cbs);
    }

    /**
     * Descripción: Permite crear un chatbot.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void crearCb(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el ID para el chatbot: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el nombre para el chatbot: ");
        String name = scanner1.nextLine();
        //scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("\nIngrese el mensage de bienvenida para el chatbot: ");
        String message = scanner2.nextLine();
        //scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del flujo inicial para el chatbot: ");
        int flCode = scanner3.nextInt();
        scanner3.nextLine();

        Chatbot_21292380_LagosLagos cb = new Chatbot_21292380_LagosLagos(id, name, message, flCode, flows);
        cbs.add(cb);

        flows = new ArrayList<>();

        menuCrearsistema(user, system, options, flows, cbs);
    }

    /**
     * Descrpción: Permite crear un sistema.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void crearSis(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el nombre para el sistema: ");
        String name = scanner1.nextLine();
        //scanner1.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del chatbot inicial para el sistema: ");
        int cbCode = scanner3.nextInt();
        scanner3.nextLine();

        System_21292380_LagosLagos newSystem = new System_21292380_LagosLagos(name, cbCode, cbs);

        System.out.println("\nEl siguente menu le permite interactuar con el nuevo sistema");
        options = new ArrayList<>();
        flows = new ArrayList<>();
        cbs = new ArrayList<>();
        mostrarMenuPrincipal(newSystem, options, flows, cbs);

    }

    /**
     * Descripció: Permite agregar una nueva opcion a un flujo.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void agregarop(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese el codigo para la opcion: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el mensaje para la opcion: ");
        String message = scanner1.nextLine();
        //scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del chatbot para la opcion: ");
        int cbCode = scanner2.nextInt();
        scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del flujo para la opcion: ");
        int flCode = scanner3.nextInt();
        scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.print("\nIngrese una keyword para la opcion: ");
        String key = scanner4.nextLine();
        //scanner4.nextLine();

        List<String> keys = new ArrayList<>();
        keys.add(key);

        Option_21292380_LagosLagos op = new Option_21292380_LagosLagos(code, message, cbCode, flCode, keys);

        Scanner scanner5 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del flujo al que desea agregar la opcion: ");
        int flid = scanner5.nextInt();
        scanner5.nextLine();

        for (Flow_21292380_LagosLagos fl : flows) {
            if (fl.getId() == flid) {
                fl.flowAddOption(op);
            }
        }

        menuCrearsistema(user, system, options, flows, cbs);
    }

    /**
     * Descripción: Permite agregar un nuevo flujo a un chatbot.
     * @param user
     * @param system
     * @param options
     * @param flows
     * @param cbs
     */
    public void agregarFl(Usuario_21292380_LagosLagos user, System_21292380_LagosLagos system, List<Option_21292380_LagosLagos> options, List<Flow_21292380_LagosLagos> flows, List<Chatbot_21292380_LagosLagos> cbs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el codigo para el flujo: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nIngrese el mensaje para el flujo: ");
        String message = scanner1.nextLine();
        //scanner1.nextLine();

        Flow_21292380_LagosLagos fL = new Flow_21292380_LagosLagos(code, message, options);

        Scanner scanner5 = new Scanner(System.in);
        System.out.print("\nIngrese el codigo del chatbot al que desea agregar el flujo: ");
        int cbid = scanner5.nextInt();
        scanner5.nextLine();

        for (Chatbot_21292380_LagosLagos cb : cbs) {
            if (cb.getChatbotID() == cbid) {
                cb.chatbotAddFlow(fL);
            }
        }

        options = new ArrayList<>();

        menuCrearsistema(user, system, options, flows, cbs);
    }
}


