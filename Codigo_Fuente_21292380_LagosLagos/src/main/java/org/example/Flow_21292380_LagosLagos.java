package org.example;

import java.util.List;

public class Flow_21292380_LagosLagos implements FlowComportamiento_21292380_LagosLagos {
    int id;
    String namemsg;
    List<Option_21292380_LagosLagos> options;

    public Flow_21292380_LagosLagos(int id, String namemsg, List<Option_21292380_LagosLagos> options) {
        this.id = id;
        this.namemsg = namemsg;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public String getNamemsg() {
        return namemsg;
    }

    public List<Option_21292380_LagosLagos> getOptions() {
        return options;
    }
}
