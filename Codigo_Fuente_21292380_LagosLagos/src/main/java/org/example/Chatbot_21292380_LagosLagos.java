package org.example;

import java.util.ArrayList;
import java.util.List;

public class Chatbot_21292380_LagosLagos implements ChatbotComportamiento_21292380_LagosLagos {
    int chatbotID;
    String name;
    String welcomeMessage;
    int startFlowId;
    List<Flow_21292380_LagosLagos> flows;

    /**
     * Descripción: Método que permite crear un chatbot.
     * @param chatbotID
     * @param name
     * @param welcomeMessage
     * @param startFlowId
     * @param flows
     */
    public Chatbot_21292380_LagosLagos(int chatbotID, String name, String welcomeMessage, int startFlowId, List<Flow_21292380_LagosLagos> flows) {
        this.chatbotID = chatbotID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = removeDuplicateFlows(flows);
    }

    /**
     * Descripción: Método que permite remover flujos duplicados de una lista.
     * @param flows
     * @return
     */
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

    /**
     * Descripción: Método que permite obtener el id de un chatbot.
     * @return
     */
    public int getChatbotID() {
        return chatbotID;
    }

    /**
     * Descripción: Método que permite obtener el nombre de un chatbot.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Descripción: Método que permite obtener el welcomeMessage de un chatbot.
     * @return
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * Descripción: Método que permite obtener el startFlowId de un chatbot.
     * @return
     */
    public int getStartFlowId() {
        return startFlowId;
    }

    /**
     * Descripción: Método que permite obtener los flujos de un chatbot.
     * @return
     */
    public List<Flow_21292380_LagosLagos> getFlows() {
        return flows;
    }

    /**
     * Descripción: Método que permite agregar un flujo a un chatbot.
     * @param flow
     */
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

    /**
     * Descripción: Método que permite obtener un chatbot como string.
     * @return
     */
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
