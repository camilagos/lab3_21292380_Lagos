package org.example;

import java.util.List;

public class Usuario_21292380_LagosLagos implements UsuarioComportamiento_21292380_LagosLagos{
    boolean isAdmin;
    String nameUser;
    List<ChatHistory_21292380_LagosLagos> history;

    public Usuario_21292380_LagosLagos(boolean isAdmin, String nameUser, List<ChatHistory_21292380_LagosLagos> history) {
        this.isAdmin = isAdmin;
        this.nameUser = nameUser;
        this.history = history;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getNameUser() {
        return nameUser;
    }

    public List<ChatHistory_21292380_LagosLagos> getHistory() {
        return history;
    }
}
