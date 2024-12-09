package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Apartment;
import edu.neu.csye7374.ApartmentAPI;

public class CarpetingDecorator extends ApartmentDecorator {

    public CarpetingDecorator(ApartmentAPI decoratedApartment) {
        super(decoratedApartment);
    }

    @Override
    public String apartmentDescription() {
        return decoratedApartment.apartmentDescription() + ", Added seat covers to the apartment agreement";
    }

    @Override
    public Object getApartmentManagement() {
        return decoratedApartment.getApartmentManagement();
    }

    public double getApartmentPrice() {
        Apartment b = Apartment.class.cast(decoratedApartment);
        return b.getApartmentPrice() + 200;
    }

}
