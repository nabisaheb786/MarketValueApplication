package com.sapient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, Investor> investors;
    private Map<String, Fund> funds;
    private Map<String, Holding> holdings;

    public Graph() {
        investors = new HashMap<>();
        funds = new HashMap<>();
        holdings = new HashMap<>();
    }

    public void addInvestor(String investorName) {
        investors.put(investorName, new Investor(investorName));
    }

    public void addFund(String fundName) {
        funds.put(fundName, new Fund(fundName));
    }

    public void addHolding(String holdingName, double value) {
        holdings.put(holdingName, new Holding(holdingName, value));
    }

    public void addInvestorFundRelationship(String investorName, String fundName) {
        Investor investor = investors.get(investorName);
        Fund fund = funds.get(fundName);
        if (investor != null && fund != null) {
            investor.addFund(fund);
        }
    }

    public void addFundHoldingRelationship(String fundName, String holdingName, int quantity) {
        Fund fund = funds.get(fundName);
        Holding holding = holdings.get(holdingName);
        if (fund != null && holding != null) {
            fund.addHolding(holding, quantity);
        }
    }
  
    public double calculateMarketValue(String fundName, Set<String> exclusions) {
        Fund fund = funds.get(fundName);
        if (fund == null) {
            return 0.0;
        }

        double marketValue = 0.0;
        for (Map.Entry<Holding, Integer> entry : fund.getHoldings().entrySet()) {
            Holding holding = entry.getKey();
            int quantity = entry.getValue();
            if (!exclusions.contains(holding.getName())) {
                marketValue += holding.getValue() * quantity;
            }
        }
        return marketValue;
    }

    public double calculateInvestorMarketValue(String investorName, Set<String> exclusions) {
        Investor investor = investors.get(investorName);
        if (investor == null) {
            return 0.0;
        }

        double marketValue = 0.0;
        for (Fund fund : investor.getFunds()) {
        	marketValue += calculateMarketValue(fund.getName(), exclusions);
        }
        return marketValue;
    }
}
