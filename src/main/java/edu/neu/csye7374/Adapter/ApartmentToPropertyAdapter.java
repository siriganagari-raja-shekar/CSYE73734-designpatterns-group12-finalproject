package edu.neu.csye7374.Adapter;

import edu.neu.csye7374.ApartmentAPI;

public class ApartmentToPropertyAdapter implements PropertyAPI {
    private final ApartmentAPI apartment;

    // Constructor to accept the existing ApartmentAPI implementation
    public ApartmentToPropertyAdapter(ApartmentAPI apartment) {
        this.apartment = apartment;
    }

    @Override
    public String getPropertyDescription() {
        return apartment.apartmentDescription();
    }

    @Override
    public String getPropertyManager() {
        return apartment.getApartmentManagement().toString();
    }

    @Override
    public double calculateAnnualRent() {
        return apartment.getApartmentRentPrice() * 12; // Convert monthly rent to annual rent
    }

    @Override
    public String getPropertyAddress() {
        return apartment.getApartmentAddress();
    }

    @Override
    public String getPropertyType() {
        return apartment.getApartmentCategory().toString();
    }
}

