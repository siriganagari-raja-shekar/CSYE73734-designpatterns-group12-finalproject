package edu.neu.csye7374.Strategy;

public enum OfferStrategy {
    NONE,
    StudentOfferStrategy,
    PromotionalStrategy,
    FamilyOfferStrategy,
    NewMemberOfferStrategy;
    
    public static OfferStrategy getOfferStrategyType(String s) {
        switch (s) {
            case "StudentOfferStrategy":
                return OfferStrategy.StudentOfferStrategy;
            case "FamilyOfferStrategy":
                return OfferStrategy.FamilyOfferStrategy;
            case "NewMemberOfferStrategy":
                return OfferStrategy.NewMemberOfferStrategy;
            case "PromotionalStrategy":
                return OfferStrategy.PromotionalStrategy;
            default:
                return OfferStrategy.NONE;
        }
    }
}
