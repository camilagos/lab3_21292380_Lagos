package org.example;

import java.util.List;

public interface ChatHistoryComportamiento_21292380_LagosLagos {
    /**
     * Descripción: Permite obtener la fecha de un chathistory.
     * @return
     */
    String getFecha();

    /**
     * Descripción: Permite obtener el mensage de un chathistory.
     * @return
     */
    String getMessage();

    /**
     * Descripción: Permite obtener el nombre del chatbot de un chathistory.
     * @return
     */
    String getNameCB();

    /**
     * Descripción: Permite obtener el nombre del flujo de un chathistory.
     * @return
     */
    String getNameFL();

    /**
     * Descripción: Permite obtener las opciones de un chathistory.
     * @return
     */
    List<Option_21292380_LagosLagos> getOptions();
}
