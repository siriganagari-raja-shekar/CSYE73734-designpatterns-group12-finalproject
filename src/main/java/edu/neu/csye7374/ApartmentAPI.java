package edu.neu.csye7374;

public interface ApartmentAPI {
    String apartmentDescription();

    Object getApartmentManagement();

    void setApartmentManagement(String apartmentManagement);

    int noOfApartmentsRented();

    double getApartmentPrice();

    public int getApartmentId();
    
    public double getApartmentRentPrice();
    
    public String getApartmentAddress();
    
    public ApartmentCategory getApartmentCategory();
}
