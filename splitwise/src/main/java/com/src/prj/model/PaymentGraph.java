package com.src.prj.model;

import java.util.Map;

public class PaymentGraph {
    private final Map<String, BalanceMap> graph;

    public PaymentGraph(Map<String, BalanceMap> graph2) {
        this.graph = graph2;
    }

    public Map<String, BalanceMap> getGraph() {
        return graph;
    }
}
