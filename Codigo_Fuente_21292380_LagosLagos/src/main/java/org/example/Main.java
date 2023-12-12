package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<String> keywords1 = new ArrayList<>();
        keywords1.add("deporte");
        keywords1.add("ejercitarse");

        List<String> keywords2 = new ArrayList<>();

        List<String> keywords3 = new ArrayList<>();
        keywords3.add("comer");

        Option_21292380_LagosLagos op1 = new Option_21292380_LagosLagos(1, "1) Hacer deporte", 1, 1, keywords1);
        Option_21292380_LagosLagos op2 = new Option_21292380_LagosLagos(2, "2) Trabajar", 0, 1, keywords2);
        Option_21292380_LagosLagos op3 = new Option_21292380_LagosLagos(3, "3) Salir a comer", 0, 1, keywords3);


        List<Option_21292380_LagosLagos> ops1 = new ArrayList<>();
        ops1.add(op1);
        ops1.add(op2);
        ops1.add(op2);


        Flow_21292380_LagosLagos f1 = new Flow_21292380_LagosLagos(1, "Flujo principal Chatbot 1: ¿Que te gustaría hacer?", ops1);
        f1.flowAddOption(op3);
        f1.flowAddOption(op1);

        List<Flow_21292380_LagosLagos> flows1 = new ArrayList<>();

        Chatbot_21292380_LagosLagos cb0 = new Chatbot_21292380_LagosLagos(0, "Inicial", "Bienvenido: ¿Qué te gustaría hacer?", 1, flows1);
        cb0.chatbotAddFlow(f1);
        cb0.chatbotAddFlow(f1);


        List<String> keywords4 = new ArrayList<>();
        keywords4.add("equipo");

        List<String> keywords5 = new ArrayList<>();
        keywords5.add("solitario");
        keywords5.add("solo");

        List<String> keywords6 = new ArrayList<>();
        keywords6.add("atras");

        Option_21292380_LagosLagos op4 = new Option_21292380_LagosLagos(1, "1) En equipo", 1, 2, keywords4);
        Option_21292380_LagosLagos op5 = new Option_21292380_LagosLagos(2, "2) En solitario", 1, 1, keywords5);
        Option_21292380_LagosLagos op6 = new Option_21292380_LagosLagos(3, "3) Volver", 0, 1, keywords6);

        List<Option_21292380_LagosLagos> ops2 = new ArrayList<>();
        ops2.add(op4);
        ops2.add(op4);
        ops2.add(op5);

        Flow_21292380_LagosLagos f2 = new Flow_21292380_LagosLagos(1, "Flujo 1 Chatbot 1: ¿Cómo te gusta hacer deporte?", ops2);
        f2.flowAddOption(op5);
        f2.flowAddOption(op6);

        List<String> keywords7 = new ArrayList<>();
        keywords7.add("fut");

        List<String> keywords8 = new ArrayList<>();

        Option_21292380_LagosLagos op7 = new Option_21292380_LagosLagos(1, "1) Fútbol", 1, 2, keywords7);
        Option_21292380_LagosLagos op8 = new Option_21292380_LagosLagos(2, "2) Baloncesto", 1, 2, keywords8);

        List<Option_21292380_LagosLagos> ops3 = new ArrayList<>();
        ops3.add(op7);
        ops3.add(op8);

        Flow_21292380_LagosLagos f3 = new Flow_21292380_LagosLagos(2, "Flujo 2 Chatbot 1: ¿Qué deporte prefieres?", ops3);

        List<Flow_21292380_LagosLagos> flows2 = new ArrayList<>();
        flows2.add(f2);
        flows2.add(f2);

        Chatbot_21292380_LagosLagos cb1 = new Chatbot_21292380_LagosLagos(1, "Coach Deportivo", "Bienvenido: ¿Qué deporte quieres practicar?", 1, flows2);
        cb1.chatbotAddFlow(f2);
        cb1.chatbotAddFlow(f3);

        List<Chatbot_21292380_LagosLagos> cbs = new ArrayList<>();
        cbs.add(cb0);
        cbs.add(cb0);

        System_21292380_LagosLagos s0 = new System_21292380_LagosLagos("Chatbots de Prueba", 0, cbs);
        s0.systemAddChatbot(cb1);
        s0.systemAddChatbot(cb1);

        List<ChatHistory_21292380_LagosLagos> chs1 = new ArrayList<>();
        List<ChatHistory_21292380_LagosLagos> chs2 = new ArrayList<>();
        List<ChatHistory_21292380_LagosLagos> chs3 = new ArrayList<>();

        Usuario_21292380_LagosLagos user1 = new Usuario_21292380_LagosLagos(true, "user1", chs1);
        Usuario_21292380_LagosLagos user2 = new Usuario_21292380_LagosLagos(false, "user2", chs2);
        Usuario_21292380_LagosLagos user21 = new Usuario_21292380_LagosLagos(true, "user2", chs2);
        Usuario_21292380_LagosLagos user3 = new Usuario_21292380_LagosLagos(false, "user3", chs3);

        s0.systemAddUser(user1);
        s0.systemAddUser(user2);
        s0.systemAddUser(user21);
        s0.systemAddUser(user3);

        //s0.systemLogin("user2");
        //s0.systemtalk("hola");
        //s0.systemtalk("deporte");
        //s0.systemtalk("equipo");
        //s0.systemtalk("fut");

        List<Option_21292380_LagosLagos> newops = new ArrayList<>();
        List<Flow_21292380_LagosLagos> newFlows = new ArrayList<>();
        List<Chatbot_21292380_LagosLagos> newCbs = new ArrayList<>();

        Menu_21292380_LagosLagos menu = new Menu_21292380_LagosLagos();
        menu.mostrarMenuPrincipal(s0, newops, newFlows, newCbs);

    }
}