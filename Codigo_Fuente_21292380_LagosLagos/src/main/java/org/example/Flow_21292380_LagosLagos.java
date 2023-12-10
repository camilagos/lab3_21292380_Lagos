package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flow_21292380_LagosLagos implements FlowComportamiento_21292380_LagosLagos {
    int id;
    String nameMsg;
    List<Option_21292380_LagosLagos> options;

    public Flow_21292380_LagosLagos(int id, String nameMsg, List<Option_21292380_LagosLagos> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.options = removeDuplicateOptions(options);
    }

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

    public int getId() {
        return id;
    }

    public String getNameMsg() {
        return nameMsg;
    }

    public List<Option_21292380_LagosLagos> getOptions() {
        return options;
    }

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

    @Override
    public String toString() {
        return "Flow_21292380_LagosLagos{" +
                "id=" + id +
                ", nameMsg='" + nameMsg + '\'' +
                ", options=" + options +
                '}';
    }
}
