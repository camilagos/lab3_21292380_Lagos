package org.example;

import java.util.List;

public class Usuario_21292380_LagosLagos implements UsuarioComportamiento_21292380_LagosLagos{
    boolean isAdmin;
    String nameUser;
    List<ChatHistory_21292380_LagosLagos> history;

    /**
     * Descripción: Método que permite crear un usuario.
     * @param isAdmin
     * @param nameUser
     * @param history
     */
    public Usuario_21292380_LagosLagos(boolean isAdmin, String nameUser, List<ChatHistory_21292380_LagosLagos> history) {
        this.isAdmin = isAdmin;
        this.nameUser = nameUser;
        this.history = history;
    }

    /**
     * Descripción: Metodo que permite saber si un usuario es admin o no.
     * @return
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * Descripción: Método que permite obtener el nombre de un usuario.
     * @return
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Descripción: Método que permite obtener el historial de un usuario.
     * @return
     */
    public List<ChatHistory_21292380_LagosLagos> getHistory() {
        return history;
    }

    /**
     * Descripción: Método que permite agregar historial a un usuario.
     * @param ch
     */
    public void addChatHistory (ChatHistory_21292380_LagosLagos ch) {
        this.history.add(ch);
    }

    /**
     * Descripción: Método que permite obtener un usuario como string.
     * @return
     */
    @Override
    public String toString() {
        return "Usuario_21292380_LagosLagos{" +
                "isAdmin=" + isAdmin +
                ", nameUser='" + nameUser + '\'' +
                ", history=" + history +
                '}';
    }
}
