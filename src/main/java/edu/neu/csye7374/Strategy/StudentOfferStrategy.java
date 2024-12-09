package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Apartment;
import edu.neu.csye7374.Observer.ApartmentAgreement;

public class StudentOfferStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(ApartmentAgreement apartmentAgreement) {
		// TODO Auto-generated method stub
		double rate = 0.50;
		double offer = (apartmentAgreement.getApartmentAgreementCost() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		apartmentAgreement.setOfferDiscount(offer);
		apartmentAgreement.getOffersApplied().add(this.discountDesc(apartmentAgreement));
		return offer;
	}

	@Override
	public String discountDesc(ApartmentAgreement apartment) {
		// TODO Auto-generated method stub
		return "50% discount for students added!";
	}
}
