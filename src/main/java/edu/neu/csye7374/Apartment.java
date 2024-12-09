package edu.neu.csye7374;

import edu.neu.csye7374.Builder.ApartmentBuilder;
import edu.neu.csye7374.Strategy.OfferStrategy;

public class Apartment implements ApartmentAPI {

    public int apartmentId;
    public String apartmentAddress;
    public double apartmentPrice;
    public ApartmentCategory apartmentCategory;
    public Object apartmentManagement;

    public Apartment(ApartmentBuilder builder) {
        super();
        this.apartmentId = builder.getApartmentId();
        this.apartmentAddress = builder.getApartmentAddress();
        this.apartmentPrice = builder.getApartmentPrice();
        this.apartmentCategory = builder.getApartmentCategory();
        this.apartmentManagement = builder.getApartmentManagement();
    }

    public Object getApartmentManagement() {
        return String.class.cast(apartmentManagement);
    }

    @Override
    public void setApartmentManagement(String ApartmentManagement) {
        this.apartmentManagement = ApartmentManagement;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public double getApartmentPrice() {
        return apartmentPrice;
    }

    public void setApartmentPrice(double ApartmentkPrice) {
        this.apartmentPrice = apartmentPrice;
    }

    public ApartmentCategory getApartmentCategory() {
        return apartmentCategory;
    }

    public void setApartmentCategory(ApartmentCategory apartmentCategory) {
        this.apartmentCategory = apartmentCategory;
    }

    @Override
    public String apartmentDescription() {
        return this.apartmentAddress + ", category : " + this.apartmentCategory;
    }

    @Override
    public int noOfApartmentsRented() {
        return (int) Math.random() * 5;
    }
    
    public double getApartmentRentPrice(){
        double rentPrice = this.apartmentPrice * 0.05;
        rentPrice = Math.round(rentPrice * 100.0) / 100.0;
        return rentPrice;
    }

    @Override
    public String toString() {
        return apartmentId + "," + apartmentAddress + "," + apartmentCategory + "," + apartmentManagement + "," + apartmentPrice;
    }

    

    public String buyApartment() {
        return this.toString() + " is bought!!!!";
    }

    public String rentApartment() {
        double rentPrice = this.apartmentPrice * 0.05;
        rentPrice = Math.round(rentPrice * 100.0) / 100.0;
        this.apartmentPrice = rentPrice;
        return this.toString() + " is rented!!";
    }
}
