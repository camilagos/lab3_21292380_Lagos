package org.example;

import java.util.ArrayList;
import java.util.List;

public class Option_21292380_LagosLagos implements OptionComportamiento_21292380_LagosLagos {
    int code;
    String message;
    int chatbotCodeLink;
    int initialFlowCodeLink;
    List<String> keywords;

    public Option_21292380_LagosLagos(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = upperCaseKeywords(keywords);
    }

    public List<String> upperCaseKeywords(List<String> keywords) {
        List<String> filteredKeywords = new ArrayList<>();
        for (String keyword : keywords) {
            if (keyword != null) {
                filteredKeywords.add(keyword.toUpperCase());
            }
        }
        return filteredKeywords;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }

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
