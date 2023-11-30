package org.example;

import java.util.List;

public class Chatbot_21292380_LagosLagos implements ChatbotComportamiento_21292380_LagosLagos {
    int chatbotID;
    String name;
    String welcomeMessage;
    int startFlowId;
    List<Flow_21292380_LagosLagos> flows;

    public Chatbot_21292380_LagosLagos(int chatbotID, String name, String welcomeMessage, int startFlowId, List<Flow_21292380_LagosLagos> flows) {
        this.chatbotID = chatbotID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = flows;
    }
}
