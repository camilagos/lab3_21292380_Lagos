package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class System_21292380_LagosLagos implements SystemComportamiento_21292380_LagosLagos{
    String name;
    int initialChatbotCodeLink;
    List<Chatbot_21292380_LagosLagos> chatbots;
    String fechaActual;
    List<Usuario_21292380_LagosLagos> usuarios;
    String usuarioLogueado;
    String estado;
    int newCodeCB;
    int newCodeFl;


    /**
     * Descripción: Método que permite crear un sistema.
     * @param name
     * @param initialChatbotCodeLink
     * @param chatbots
     */
    public System_21292380_LagosLagos(String name, int initialChatbotCodeLink, List<Chatbot_21292380_LagosLagos> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = removeDuplicateCBs(chatbots);
        this.fechaActual = obtenerFecha();
        this.usuarios = new ArrayList<>();
        this.usuarioLogueado = null;
        this.estado = "Sin interacciones válidas";
        this.newCodeCB = 0;
        this.newCodeFl = 0;
        System.out.println("\nEl sistema ha sido creado");
    }

    /**
     * Descripción: Método que permite remover chatbots duplicados de una lista.
     * @param chatbots
     * @return
     */
    public List<Chatbot_21292380_LagosLagos> removeDuplicateCBs(List<Chatbot_21292380_LagosLagos> chatbots) {
        List<Chatbot_21292380_LagosLagos> chatbotsSinDup = new ArrayList<>();
        List<Integer> chatbotIDSinDup = new ArrayList<>();

        for (Chatbot_21292380_LagosLagos chatbot : chatbots) {
            int chatbotID = chatbot.getChatbotID();
            if (!chatbotIDSinDup.contains(chatbotID)) {
                chatbotIDSinDup.add(chatbotID);
                chatbotsSinDup.add(chatbot);
            }
        }
        return chatbotsSinDup;
    }

    /**
     * Descripción: Método que permite obtener la fecha actual.
     * @return
     */
    public String obtenerFecha() {
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        return dia + "-" + mes + "-" + year;
    }

    /**
     * Descripción: Método que permite obtener la lista de usuarios de un sistema.
     * @return
     */
    public List<Usuario_21292380_LagosLagos> getUsuarios() {
        return usuarios;
    }

    /**
     * Descripción: Método que permite agregar un chatbot a un sistema.
     * @param chatbot
     */
    public void systemAddChatbot(Chatbot_21292380_LagosLagos chatbot) {
        boolean chatbotExists = false;
        for (Chatbot_21292380_LagosLagos existingCB : this.chatbots) {
            if (existingCB.getChatbotID() == chatbot.getChatbotID()) {
                chatbotExists = true;
                break;
            }
        }
        if (!chatbotExists) {
            this.chatbots.add(chatbot);
            System.out.println("\nEl chatbot ha sigo agregado al sistema");
        }
        else {
            System.out.println("\nEl chatbot ya existe en el sistema");
        }
    }

    /**
     * Descripción: Método que permite agregar un usuario a un sistema.
     * @param usuario
     */
    public void systemAddUser(Usuario_21292380_LagosLagos usuario) {
        boolean userExists = false;
        for (Usuario_21292380_LagosLagos existingUser : this.usuarios) {
            if (existingUser.getNameUser().equals(usuario.getNameUser())) {
                userExists = true;
                System.out.println("\nEl usuario ya existe.");
                break;
            }
        }
        if(!userExists) {
            this.usuarios.add(usuario);
            System.out.println("\nUsuario registrado exitosamente.");
        }
    }

    /**
     * Descripción: Método que permite iniciar sesión en un sistema.
     * @param user
     */
    public void systemLogin(String user) {
        if (this.usuarioLogueado != null) {
        System.out.println("\nYa hay una sesion abierta");
        return;
        }
        boolean usuarioEncontrado = false;
        for (Usuario_21292380_LagosLagos usuario : this.usuarios) {
           if (usuario.getNameUser().equals(user)) {
               usuarioEncontrado = true;
               break;
           }
        }
        if (usuarioEncontrado) {
            this.usuarioLogueado = user;
            System.out.println("\nInicio de sesion exitoso");
        }
        else {
            System.out.println("\nEl usuario ingresado no existe");
        }
    }

    /**
     * Descripción: Método que permite cerrar sesión en un sistema.
     */
    public void systemLogout() {
        this.usuarioLogueado = null;
        System.out.println("\nSesion cerrada exitosamente");
    }

    /**
     * Descripción: Método que permite interactuar en un sistema.
     * @param message
     */
    public void systemtalk(String message) {
        if (this.usuarioLogueado == null) {
            System.out.println("\nNo hay una sesion abierta");
            return;
        }

        if (this.estado.equals("Sin interacciones válidas")) {
            for (Chatbot_21292380_LagosLagos cb : this.chatbots) {
                if (cb.getChatbotID() == this.initialChatbotCodeLink) {
                    for (Flow_21292380_LagosLagos flow : cb.getFlows()) {
                        if (cb.getStartFlowId() == flow.getId()) {
                            for (Option_21292380_LagosLagos option : flow.getOptions()) {
                                for (String keyword : option.getKeywords()) {
                                    if (keyword.equals(message.toUpperCase()) || Integer.toString(option.getCode()).equals(message)) {
                                        this.newCodeCB = option.getChatbotCodeLink();
                                        this.newCodeFl = option.getInitialFlowCodeLink();
                                        this.estado = "Con interacciones válidas";
                                        ChatHistory_21292380_LagosLagos ch = new ChatHistory_21292380_LagosLagos(this.fechaActual, message, cb.getName(), flow.getNameMsg(), flow.getOptions());
                                        for (Usuario_21292380_LagosLagos user : this.usuarios) {
                                            if (user.getNameUser().equals(this.usuarioLogueado)) {
                                                user.addChatHistory(ch);
                                                System.out.println("\nSe completo la interaccion");
                                                return;
                                            }
                                        }
                                    }
                                    else {
                                        ChatHistory_21292380_LagosLagos ch = new ChatHistory_21292380_LagosLagos(this.fechaActual, message, cb.getName(), flow.getNameMsg(), flow.getOptions());
                                        for (Usuario_21292380_LagosLagos user : this.usuarios) {
                                            if (user.getNameUser().equals(this.usuarioLogueado)) {
                                                user.addChatHistory(ch);
                                                System.out.println("\nNo se encontro la opcion, pero se guardo el historial");
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        else {
            for (Chatbot_21292380_LagosLagos cb : this.chatbots) {
                if (cb.getChatbotID() == this.newCodeCB) {
                    for (Flow_21292380_LagosLagos flow : cb.getFlows()) {
                        if (flow.getId() == this.newCodeFl) {
                            for (Option_21292380_LagosLagos option : flow.getOptions()) {
                                for (String keyword : option.getKeywords()) {
                                    if (keyword.equals(message.toUpperCase()) || Integer.toString(option.getCode()).equals(message)) {
                                        this.newCodeCB = option.getChatbotCodeLink();
                                        this.newCodeFl = option.getInitialFlowCodeLink();
                                        ChatHistory_21292380_LagosLagos ch = new ChatHistory_21292380_LagosLagos(this.fechaActual, message, cb.getName(), flow.getNameMsg(), flow.getOptions());
                                        for (Usuario_21292380_LagosLagos user : this.usuarios) {
                                            if (user.getNameUser().equals(this.usuarioLogueado)) {
                                                user.addChatHistory(ch);
                                                System.out.println("\nSe completo la interaccion");
                                                return;
                                            }
                                        }
                                    }
                                    else {
                                        ChatHistory_21292380_LagosLagos ch = new ChatHistory_21292380_LagosLagos(this.fechaActual, message, cb.getName(), flow.getNameMsg(), flow.getOptions());
                                        for (Usuario_21292380_LagosLagos user : this.usuarios) {
                                            if (user.getNameUser().equals(this.usuarioLogueado)) {
                                                user.addChatHistory(ch);
                                                System.out.println("\nNo se encontro la opcion, pero se guardo el historial");
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Descripción: Método que permite visualizar el historial de un usuario en el sistema.
     * @param usuario
     */
    public void systemsynthesis(String usuario) {
        for (Usuario_21292380_LagosLagos user : this.usuarios) {
            if (user.getNameUser().equals(usuario)) {
                List<ChatHistory_21292380_LagosLagos> history = user.getHistory();
                if (history.isEmpty()) {
                    System.out.println("El usuario " + usuario + " no tiene historial.");
                }
                else {
                    for (ChatHistory_21292380_LagosLagos chat : history) {
                        System.out.println("\n" + chat.getFecha() + " - " + usuario + ": " + chat.getMessage());
                        System.out.println(chat.getFecha() + " - " + chat.getNameCB() + ": " + chat.getNameFL());
                        for (Option_21292380_LagosLagos op : chat.getOptions()) {
                            System.out.println(op.getMessage());
                        }
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    /**
     * Descripción: Método que permite obtener el sistema como string.
     * @return
     */
    @Override
    public String toString() {
        return "System_21292380_LagosLagos{" +
                "name='" + name + '\'' +
                ", initialChatbotCodeLink=" + initialChatbotCodeLink +
                ", chatbots=" + chatbots +
                ", fechaActual='" + fechaActual + '\'' +
                ", usuarios=" + usuarios +
                ", usuarioLogueado='" + usuarioLogueado + '\'' +
                ", estado='" + estado + '\'' +
                ", newCodeCB=" + newCodeCB +
                ", newCodeFl=" + newCodeFl +
                '}';
    }

}
