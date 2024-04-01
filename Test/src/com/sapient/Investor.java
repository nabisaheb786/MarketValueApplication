package com.sapient;

import java.util.ArrayList;
import java.util.List;

public class Investor {
	
    private String name;
    private List<Fund> funds;

    public Investor(String name) {
        this.name = name;
        this.funds = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void addFund(Fund fund) {
        funds.add(fund);
    }
}
