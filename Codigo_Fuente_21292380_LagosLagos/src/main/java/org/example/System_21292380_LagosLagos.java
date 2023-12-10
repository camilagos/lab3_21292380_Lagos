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
    }

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

    public String obtenerFecha() {
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        return dia + "-" + mes + "-" + year;
    }

    public String getName() {
        return name;
    }

    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    public List<Chatbot_21292380_LagosLagos> getChatbots() {
        return chatbots;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public List<Usuario_21292380_LagosLagos> getUsuarios() {
        return usuarios;
    }

    public String getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public String getEstado() {
        return estado;
    }

    public int getNewCodeCB() {
        return newCodeCB;
    }

    public int getNewCodeFl() {
        return newCodeFl;
    }


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
        }
    }

    public void systemAddUser(Usuario_21292380_LagosLagos usuario) {
        boolean userExists = false;
        for (Usuario_21292380_LagosLagos existingUser : this.usuarios) {
            if (existingUser.getNameUser().equals(usuario.getNameUser())) {
                userExists = true;
                break;
            }
        }
        if(!userExists) {
            this.usuarios.add(usuario);
        }
    }

    public void systemLogin(String user) {
        if (this.usuarioLogueado != null) {
        System.out.println("Ya hay una sesión abierta");
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
            System.out.println("Inicio de sesión exitoso");
        }
        else {
            System.out.println("El usuario ingresado no existe");
        }
    }

    public void systemLogout() {
        this.usuarioLogueado = null;
        System.out.println("Sesión cerrada exitosamente");
    }

    


}
