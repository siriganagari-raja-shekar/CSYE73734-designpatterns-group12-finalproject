package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public class PromotionalStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(ApartmentAgreement apartmentAgreement) {
		double rate = 0.10;
		double offer = (apartmentAgreement.getApartmentAgreementCost() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		apartmentAgreement.setOfferDiscount(offer);
		apartmentAgreement.getOffersApplied().add(this.discountDesc(apartmentAgreement));
		return offer;

	}

	@Override
	public String discountDesc(ApartmentAgreement apartment) {
		// TODO Auto-generated method stub
		return "10% promotinal discount offer added!";
	}
}
