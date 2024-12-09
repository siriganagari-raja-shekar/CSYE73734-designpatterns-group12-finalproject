package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public class ApartmentHandover implements ApartmentHandoverStateAPI {

    private ApartmentAgreement agreement;

    public ApartmentHandover(ApartmentAgreement agreement) {
        super();
        this.agreement = agreement;
    }

    @Override
    public void apartmentConfirmed_state() {
        System.out.println("Sorry, ApartmentAgreement already CONFIRMED");
    }

    @Override
    public void apartmentHandoverStatus_state() {
        System.out.println("Sorry,  ApartmentAgreement already in DISPATCH state");
    }

    @Override
    public void apartmentHandovered_state() {
        agreement.setState(agreement.getApartmentAgreementHandovered());
        System.out.println("Thank you for choosing us, ApartmentAgreement successfully DELIVERED");
    }
}
