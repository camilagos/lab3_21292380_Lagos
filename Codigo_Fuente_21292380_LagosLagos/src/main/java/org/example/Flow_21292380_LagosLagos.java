package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flow_21292380_LagosLagos implements FlowComportamiento_21292380_LagosLagos {
    int id;
    String nameMsg;
    List<Option_21292380_LagosLagos> options;

    /**
     * Descripción: Método que permite crear un flujo.
     * @param id
     * @param nameMsg
     * @param options
     */
    public Flow_21292380_LagosLagos(int id, String nameMsg, List<Option_21292380_LagosLagos> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.options = removeDuplicateOptions(options);
    }

    /**
     * Descripción: Método que permite remover opciones duplicadas de una lista.
     * @param options
     * @return
     */
    public List<Option_21292380_LagosLagos> removeDuplicateOptions(List<Option_21292380_LagosLagos> options) {
        List<Option_21292380_LagosLagos> optionsSinDup = new ArrayList<>();
        List<Integer> codeSinDup = new ArrayList<>();

        for (Option_21292380_LagosLagos option : options) {
            int code = option.getCode();
            if (!codeSinDup.contains(code)) {
                codeSinDup.add(code);
                optionsSinDup.add(option);
            }
        }
        return optionsSinDup;
    }

    /**
     * Descripción: Método que permite obtener el código un flujo.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Descripción: Método que permite obtener el nameMsg un flujo.
     * @return
     */
    public String getNameMsg() {
        return nameMsg;
    }

    /**
     * Descripción: Método que permite obtener las opciones un flujo.
     * @return
     */
    public List<Option_21292380_LagosLagos> getOptions() {
        return options;
    }

    /**
     * Descripción: Método que permite agregar una opción a un flujo.
     * @param option
     */
    public void flowAddOption(Option_21292380_LagosLagos option) {
        boolean optionExists = false;
        for (Option_21292380_LagosLagos existingOption : this.options) {
            if (existingOption.getCode() == option.getCode()) {
                optionExists = true;
                break;
            }
        }
        if (!optionExists) {
            this.options.add(option);
        }
    }

    /**
     * Descripción: Método que permite obtener un flujo comp String.
     * @return
     */
    @Override
    public String toString() {
        return "Flow_21292380_LagosLagos{" +
                "id=" + id +
                ", nameMsg='" + nameMsg + '\'' +
                ", options=" + options +
                '}';
    }
}
