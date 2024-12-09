package edu.neu.csye7374.Observer;

public class ApartmentPriceObserver implements CheckoutObserverAPI {

	@Override
	public void update(ApartmentAgreement apartmentagreement) {
		// TODO Auto-generated method stub
		double agreementTotal = apartmentagreement.getApartmentAgreementCost();
		if (agreementTotal >= 100000) {
			apartmentagreement.setOfferDiscount(apartmentagreement.getOfferDiscount() + 1000);
			apartmentagreement.getOffersApplied().add("1000$ discount applied as agreement cost is greater than 100000$");

		} else if (agreementTotal >= 50000) {
			apartmentagreement.setOfferDiscount(apartmentagreement.getOfferDiscount() + 500);
			apartmentagreement.getOffersApplied().add("500$ discount applied as agreement cost is greater than 50000$");
		}
	}

}
