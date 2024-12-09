package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Facade.ApartmentHandoverMethod;

public class InventoryObserver implements CheckoutObserverAPI {

	@Override
	public void update(ApartmentAgreement apartmentagreement) {
		// TODO Auto-generated method stub
		if (apartmentagreement.getApartmentHandoverMethod() == ApartmentHandoverMethod.Digital) {
			if (apartmentagreement.getTotal() <= 10000) {
				apartmentagreement.setHandoverCost(50);
			} else {
				apartmentagreement.setHandoverCost(200);
			}   
		}
	}
}
