package edu.neu.csye7374.Command;

import java.util.*;

import edu.neu.csye7374.Apartment;

public class Invoker {
    private List<Apartment> agreementList = new ArrayList<>();

    public void takeApartmentAgreement(Apartment agreement) {
        agreementList.add(agreement);
    }

    public void placeApartmentAgreements() {
        BuyApartmentCommand buyApartmentCommand = BuyApartmentCommand.getInstance();
        for (Apartment agreement : agreementList) {
            System.out.println(buyApartmentCommand.setApartment(agreement).execute());
        }
        agreementList.clear();
    }

    public void placeApartmentAgreements(List<Apartment> apartmentList) {
        for (Apartment b : apartmentList) {
            agreementList.add(b);
        }
        placeApartmentAgreements();
    }

    public void rentApartmentAgreements() {
        RentApartmentCommand rentApartmentCommand = RentApartmentCommand.getInstance();
        for (Apartment agreement : agreementList) {
            System.out.println(rentApartmentCommand.setApartment(agreement)
                    .execute());
        }
        agreementList.clear();
    }

    public void rentApartmentAgreements(List<Apartment> apartmentList) {
        for (Apartment b : apartmentList) {
            agreementList.add(b);
        }
        rentApartmentAgreements();
    }

    public List<Apartment> getApartmentAgreementList() {
        return agreementList;
    }

    public void setApartmentAgreementList(List<Apartment> agreementList) {
        this.agreementList = agreementList;
    }

}
