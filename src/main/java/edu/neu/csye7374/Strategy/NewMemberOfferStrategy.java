package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public class NewMemberOfferStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(ApartmentAgreement apartmentAgreement) {
		double rate = 0.30;
		double offer = (apartmentAgreement.getApartmentAgreementCost() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		apartmentAgreement.setOfferDiscount(offer);
		apartmentAgreement.getOffersApplied().add(this.discountDesc(apartmentAgreement));
		return offer;
	}

	@Override
	public String discountDesc(ApartmentAgreement apartment) {
		return "30% discount for New member offer added!";
	}
}
