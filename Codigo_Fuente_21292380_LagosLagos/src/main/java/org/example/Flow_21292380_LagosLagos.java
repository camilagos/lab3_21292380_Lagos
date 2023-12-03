package org.example;

import java.util.List;

public class Flow_21292380_LagosLagos implements FlowComportamiento_21292380_LagosLagos {
    int id;
    String nameMsg;
    List<Option_21292380_LagosLagos> options;

    public Flow_21292380_LagosLagos(int id, String nameMsg, List<Option_21292380_LagosLagos> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.options = options;
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
        this.options.add(option);
    }
}
