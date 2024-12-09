package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Apartment;
import edu.neu.csye7374.ApartmentAPI;

public class Insurance extends ApartmentDecorator {
    public Insurance(ApartmentAPI decoratedApartment) {
        super(decoratedApartment);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String apartmentDescription() {
        // TODO Auto-generated method stub
        return decoratedApartment.apartmentDescription() + ", Added Insurance to the Agreement";
    }

    @Override
    public Object getApartmentManagement() {
        // TODO Auto-generated method stub
        return decoratedApartment.getApartmentManagement();
    }

    public double getApartmentPrice() {
        Apartment b = Apartment.class.cast(decoratedApartment);
        return b.getApartmentPrice() + 250;
    }
}
