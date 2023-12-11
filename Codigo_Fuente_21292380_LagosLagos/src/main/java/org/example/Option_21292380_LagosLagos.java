package org.example;

import java.util.ArrayList;
import java.util.List;

public class Option_21292380_LagosLagos implements OptionComportamiento_21292380_LagosLagos {
    int code;
    String message;
    int chatbotCodeLink;
    int initialFlowCodeLink;
    List<String> keywords;

    /**
     * Descripción: Este método permite crear una opción.
     * @param code
     * @param message
     * @param chatbotCodeLink
     * @param initialFlowCodeLink
     * @param keywords
     */
    public Option_21292380_LagosLagos(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = upperCaseKeywords(keywords);
    }

    /**
     * Descripción: Este método permite que una lista de strings quede completamnete en mayuscula.
     * @param keywords
     * @return
     */
    public List<String> upperCaseKeywords(List<String> keywords) {
        List<String> filteredKeywords = new ArrayList<>();
        for (String keyword : keywords) {
            if (keyword != null) {
                filteredKeywords.add(keyword.toUpperCase());
            }
        }
        return filteredKeywords;
    }

    /**
     * Descripción: Este método permite obtener el código de una opción.
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * Descripción: Este método permite obtener el mensage de una opción.
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Descripción: Este método permite obtener el chatbotCodeLink de una opción.
     * @return
     */
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Descripción: Este método permite obtener el initialFlowCodeLink de una opción.
     * @return
     */
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    /**
     * Descripción: Este método permite obtener las keywords de una opción.
     * @return
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Descripción: Este método permite obtener la opción como string.
     * @return
     */
    @Override
    public String toString() {
        return "Option_21292380_LagosLagos{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", keywords=" + keywords +
                '}';
    }
}
