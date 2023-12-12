package org.example;

import java.util.List;

public interface OptionComportamiento_21292380_LagosLagos {
    /**
     * Descripción: Permite obtener el código de una opción.
     * @return
     */
    int getCode();

    /**
     * Descripción: Permite obtener el mensage de una opción.
     * @return
     */
    String getMessage();

    /**
     * Descripción: Permite obtener el código del chatbot de una opción.
     * @return
     */
    int getChatbotCodeLink();

    /**
     * Descripción: Permite obtener el código del flujo de una opción.
     * @return
     */
    int getInitialFlowCodeLink();

    /**
     * Descripción: Permite obtener las keywords de una opción.
     * @return
     */
    List<String> getKeywords();
}
