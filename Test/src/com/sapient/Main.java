package com.sapient;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding investors, funds, and holdings
        graph.addInvestor("Inv1");
        graph.addInvestor("Inv2");

        graph.addFund("F1");
        graph.addFund("F2");
        graph.addFund("F3");

        graph.addHolding("H1", 10.0);
        graph.addHolding("H2", 20.0);
        graph.addHolding("H3", 15.0);
        graph.addHolding("H4", 10.0);

        // Establishing relationships
        graph.addInvestorFundRelationship("Inv1", "F1");
        graph.addInvestorFundRelationship("Inv1", "F2");
        graph.addInvestorFundRelationship("Inv2", "F2");
        graph.addInvestorFundRelationship("Inv2", "F3");

        graph.addFundHoldingRelationship("F1", "H1", 100);
        graph.addFundHoldingRelationship("F1", "H2", 100);
        graph.addFundHoldingRelationship("F1", "H4", 100);
        graph.addFundHoldingRelationship("F2", "H3", 100);
        graph.addFundHoldingRelationship("F2", "H1", 100);
        graph.addFundHoldingRelationship("F3", "H1", 100);
        graph.addFundHoldingRelationship("F3", "H4", 100);

        // Calculate market value
        Set<String> exclusions = new HashSet<>();
        exclusions.add("H1");
        double marketValueF1 = graph.calculateMarketValue("F1", exclusions);
        double marketValueInv1 = graph.calculateInvestorMarketValue("Inv1", new HashSet<>());

       System.out.println("Total Market value for F1 (excluding H1): " + marketValueF1);
       System.out.println("Total market value for Inv1 (Including H1): " + marketValueInv1);
    }
}