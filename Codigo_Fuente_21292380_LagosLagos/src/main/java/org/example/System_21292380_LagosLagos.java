package org.example;

import java.util.ArrayList;
import java.util.List;

public class System_21292380_LagosLagos implements SystemComportamiento_21292380_LagosLagos{
    String name;
    int InitialChatbotCodeLink;
    List<Chatbot_21292380_LagosLagos> chatbots;
    List<Usuario_21292380_LagosLagos> usuarios;

    public System_21292380_LagosLagos(String name, int initialChatbotCodeLink, List<Chatbot_21292380_LagosLagos> chatbots) {
        this.name = name;
        this.InitialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = removeDuplicateCBs(chatbots);
        this.usuarios = new ArrayList<>();
    }

    public List<Chatbot_21292380_LagosLagos> removeDuplicateCBs(List<Chatbot_21292380_LagosLagos> chatbots) {
        List<Chatbot_21292380_LagosLagos> chatbotsSinDup = new ArrayList<>();
        List<Integer> chatbotIDSinDup = new ArrayList<>();

        for (Chatbot_21292380_LagosLagos chatbot : chatbots) {
            int chatbotID = chatbot.getChatbotID();
            if (!chatbotIDSinDup.contains(chatbotID)) {
                chatbotIDSinDup.add(chatbotID);
                chatbotsSinDup.add(chatbot);
            }
        }
        return chatbotsSinDup;
    }

    public String getName() {
        return name;
    }

    public int getInitialChatbotCodeLink() {
        return InitialChatbotCodeLink;
    }

    public List<Chatbot_21292380_LagosLagos> getChatbots() {
        return chatbots;
    }

    public void systemAddChatbot(Chatbot_21292380_LagosLagos chatbot) {
        boolean chatbotExists = false;
        for (Chatbot_21292380_LagosLagos existingCB : this.chatbots) {
            if (existingCB.getChatbotID() == chatbot.getChatbotID()) {
                chatbotExists = true;
                break;
            }
        }
        if (!chatbotExists) {
            this.chatbots.add(chatbot);
        }
    }
}
