package edu.neu.csye7374.Facade;

import edu.neu.csye7374.ApartmentAPI;
import edu.neu.csye7374.Decorator.ApartmentDecorator;
import edu.neu.csye7374.Decorator.InsuranceDecorator;
import edu.neu.csye7374.Observer.ApartmentAgreement;

public class ApartmentAgreementFacade {
	private ApartmentAPI apartment;

	public ApartmentAgreementFacade() {
		super();
	}

	public ApartmentAgreementFacade(ApartmentAPI apartment) {
		super();
		this.setApartment(apartment);
	}

	public ApartmentAgreementFacade setApartment(ApartmentAPI apartment) {
		this.apartment = apartment;
		return this;
	}

	public ApartmentAPI getApartment() {
		return apartment;
	}

	public ApartmentAgreement apartmentAgreement() {
            ApartmentAgreement agreement = new ApartmentAgreement();
            ApartmentDecorator insurance = new InsuranceDecorator(apartment);
            System.out.println(insurance);
            agreement.addApartment(insurance);
            return agreement;
	}

}
