package org.example;

import java.util.ArrayList;
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
        this.flows = removeDuplicateFlows(flows);
    }

    public List<Flow_21292380_LagosLagos> removeDuplicateFlows(List<Flow_21292380_LagosLagos> flows) {
        List<Flow_21292380_LagosLagos> flowsSinDup = new ArrayList<>();
        List<Integer> idSinDup = new ArrayList<>();

        for (Flow_21292380_LagosLagos flow : flows) {
            int id = flow.getId();
            if (!idSinDup.contains(id)) {
                idSinDup.add(id);
                flowsSinDup.add(flow);
            }
        }
        return flowsSinDup;
    }

    public int getChatbotID() {
        return chatbotID;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public List<Flow_21292380_LagosLagos> getFlows() {
        return flows;
    }

    public void chatbotAddFlow(Flow_21292380_LagosLagos flow) {
        boolean flowExists = false;
        for (Flow_21292380_LagosLagos existingFlow : this.flows) {
            if (existingFlow.getId() == flow.getId()) {
                flowExists = true;
                break;
            }
        }
        if (!flowExists) {
            this.flows.add(flow);
        }
    }

    @Override
    public String toString() {
        return "Chatbot_21292380_LagosLagos{" +
                "chatbotID=" + chatbotID +
                ", name='" + name + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", startFlowId=" + startFlowId +
                ", flows=" + flows +
                '}';
    }
}
