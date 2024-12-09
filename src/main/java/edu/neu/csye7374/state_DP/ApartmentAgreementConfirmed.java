package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.ApartmentAgreement;

public class ApartmentAgreementConfirmed implements ApartmentHandoverStateAPI {

    private ApartmentAgreement apartmentagreement;

    public ApartmentAgreementConfirmed(ApartmentAgreement apartmentagreement) {
        super();
        this.apartmentagreement = apartmentagreement;
    }

    @Override
    public void apartmentConfirmed_state() {
        System.out.println("Sorry,  ApartmentAgreement already in CONFIRMED State");
    }

    @Override
    public void apartmentHandoverStatus_state() {
        apartmentagreement.setState(apartmentagreement.getApartmentAgreementDispatched());
        System.out.println("Thank you for the confirmation, ApartmentAgreement DISPATCHED");
    }

    @Override
    public void apartmentHandovered_state() {
        System.out.println("Sorry,  ApartmentAgreement not yet DISPATCHED");
    }

}
