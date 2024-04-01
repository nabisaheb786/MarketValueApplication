package com.sapient;

import java.util.HashMap;
import java.util.Map;

public class Fund {
	
    private String name;
    private Map<Holding, Integer> holdings;

    public Fund(String name) {
        this.name = name;
        this.holdings = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Holding, Integer> getHoldings() {
        return holdings;
    }

    public void addHolding(Holding holding, int quantity) {
        holdings.put(holding, quantity);
    }
}