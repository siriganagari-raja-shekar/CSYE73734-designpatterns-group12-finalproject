package edu.neu.csye7374.Strategy;

public enum BonusStrategy {

    RentBonusStrategy,
    SalesBonusStrategy;

    public static BonusStrategy getBonusStrategyType(String s){
        switch (s) {
            case "RentBonusStrategy":
                return BonusStrategy.RentBonusStrategy; 
            case "SalesBonusStrategy":
                return BonusStrategy.SalesBonusStrategy;
            default:
                return BonusStrategy.RentBonusStrategy;
        }
    }
    
}