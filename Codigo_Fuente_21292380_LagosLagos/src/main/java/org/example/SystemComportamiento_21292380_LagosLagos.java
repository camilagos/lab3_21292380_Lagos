package org.example;

public interface SystemComportamiento_21292380_LagosLagos {
    /**
     * Descripción: Permite agregar un chatbot a un sistema.
     * @param chatbot
     */
    void systemAddChatbot(Chatbot_21292380_LagosLagos chatbot);

    /**
     * Descripción: Permite agregar un usuario a un sistema.
     * @param usuario
     */
    void systemAddUser(Usuario_21292380_LagosLagos usuario);

    /**
     * Descripción: Permite iniciar sesión en un sistema.
     * @param user
     */
    void systemLogin(String user);

    /**
     * Descripción: Permite cerrar sesión en un sistema.
     */
    void systemLogout();

    /**
     * Descripción: Permite interactuar con un sistema.
     * @param message
     */
    void systemtalk(String message);
}
