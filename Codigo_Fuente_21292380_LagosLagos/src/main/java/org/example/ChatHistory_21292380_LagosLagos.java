package org.example;

import java.util.List;

public class ChatHistory_21292380_LagosLagos implements ChatHistoryComportamiento_21292380_LagosLagos {
    String fecha;
    String message;
    String nameCB;
    String nameFL;
    List<Option_21292380_LagosLagos> options;

    public ChatHistory_21292380_LagosLagos(String fecha, String message, String nameCB, String nameFL, List<Option_21292380_LagosLagos> options) {
        this.fecha = fecha;
        this.message = message;
        this.nameCB = nameCB;
        this.nameFL = nameFL;
        this.options = options;
    }
}
