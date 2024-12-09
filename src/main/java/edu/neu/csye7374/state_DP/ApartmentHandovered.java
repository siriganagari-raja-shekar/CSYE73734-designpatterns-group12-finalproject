package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public class ApartmentHandovered implements ApartmentHandoverStateAPI {
    private ApartmentAgreement agreement;

    public ApartmentHandovered(ApartmentAgreement agreement) {
        super();
        this.agreement = agreement;
    }

    @Override
    public void apartmentConfirmed_state() {
        System.out.println("Sorry, ApartmentAgreement already DELIVERED");
    }

    @Override
    public void apartmentHandoverStatus_state() {
        System.out.println("Sorry,  ApartmentAgreement already DELIVERED");
    }

    @Override
    public void apartmentHandovered_state() {
        System.out.println("Sorry, ApartmentAgreement already DELIVERED");
    }
}
