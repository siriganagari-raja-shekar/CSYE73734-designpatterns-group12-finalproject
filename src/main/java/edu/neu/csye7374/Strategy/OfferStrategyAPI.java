package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public interface OfferStrategyAPI {
	public double discountAmt(ApartmentAgreement apartmentAgreement);

	public String discountDesc(ApartmentAgreement apartmentAgreement);
}
