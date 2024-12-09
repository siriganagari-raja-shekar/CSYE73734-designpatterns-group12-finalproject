package edu.neu.csye7374.Strategy;

public class RentBonusStrategy implements BonusStrategyAPI{

    @Override
    public double calculateBonus(double agreementCost) {
        return agreementCost / 12;
    }
    
}
