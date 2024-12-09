package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.*;

public class DoorbellCameraDecorator extends ApartmentDecorator {

    public DoorbellCameraDecorator(ApartmentAPI decoratedApartment) {
        super(decoratedApartment);
    }

    @Override
    public String apartmentDescription() {
        return decoratedApartment.apartmentDescription() + ", Added Doorbell Camera to the apartment agreement";
    }

    @Override
    public Object getApartmentManagement() {
        return decoratedApartment.getApartmentManagement();
    }

    public double getApartmentPrice() {
        Apartment b = Apartment.class.cast(decoratedApartment);
        return b.getApartmentPrice() + 560;
    }

}
