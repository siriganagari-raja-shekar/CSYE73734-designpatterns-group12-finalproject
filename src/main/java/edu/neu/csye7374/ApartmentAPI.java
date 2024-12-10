package edu.neu.csye7374;

import java.util.UUID;
public interface ApartmentAPI {
    String apartmentDescription();

    Object getApartmentManagement();

    void setApartmentManagement(String apartmentManagement);

    int noOfApartmentsRented();

    double getApartmentPrice();

    public UUID getApartmentId();
    
    public double getApartmentRentPrice();
    
    public String getApartmentAddress();
    
    public ApartmentCategory getApartmentCategory();
}
