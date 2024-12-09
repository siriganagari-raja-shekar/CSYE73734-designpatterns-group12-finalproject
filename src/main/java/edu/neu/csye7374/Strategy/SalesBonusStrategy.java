package edu.neu.csye7374.Strategy;

public class SalesBonusStrategy implements BonusStrategyAPI{

    @Override
    public double calculateBonus(double agreementCost) {
        return agreementCost * 0.1;
    }
    
}
