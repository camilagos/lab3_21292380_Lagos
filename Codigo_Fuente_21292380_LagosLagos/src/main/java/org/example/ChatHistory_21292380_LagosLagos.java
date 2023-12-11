package org.example;

import java.util.List;

public class ChatHistory_21292380_LagosLagos implements ChatHistoryComportamiento_21292380_LagosLagos {
    String fecha;
    String message;
    String nameCB;
    String nameFL;
    List<Option_21292380_LagosLagos> options;

    /**
     * Descripción: Método que permite crear el historial.
     * @param fecha
     * @param message
     * @param nameCB
     * @param nameFL
     * @param options
     */
    public ChatHistory_21292380_LagosLagos(String fecha, String message, String nameCB, String nameFL, List<Option_21292380_LagosLagos> options) {
        this.fecha = fecha;
        this.message = message;
        this.nameCB = nameCB;
        this.nameFL = nameFL;
        this.options = options;
    }

    /**
     * Descripción: Método que permite obtener la fecha del historial.
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Descripción: Método que permite obtener el message del historial.
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Descripción: Método que permite obtener el nombre del chatbot del historial.
     * @return
     */
    public String getNameCB() {
        return nameCB;
    }

    /**
     * Descripción: Método que permite obtener el nombre del flujo del historial.
     * @return
     */
    public String getNameFL() {
        return nameFL;
    }

    /**
     * Descripción: Método que permite obtener las opciones del historial.
     * @return
     */
    public List<Option_21292380_LagosLagos> getOptions() {
        return options;
    }

    /**
     * Descripción: Método que permite obtener el historial como string.
     * @return
     */
    @Override
    public String toString() {
        return "ChatHistory_21292380_LagosLagos{" +
                "fecha='" + fecha + '\'' +
                ", message='" + message + '\'' +
                ", nameCB='" + nameCB + '\'' +
                ", nameFL='" + nameFL + '\'' +
                ", options=" + options +
                '}';
    }
}
