package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Apartment;
import edu.neu.csye7374.ApartmentCategory;

import edu.neu.csye7374.Factory.*;

import java.util.UUID;

public class ApartmentBuilder implements BuilderAPI {

    private UUID apartmentId;
    private String apartmentAddress;
    private double apartmentPrice;
    private ApartmentCategory apartmentCategory;
    private String apartmentManagement;

    public String getApartmentManagement() {
        return apartmentManagement;
    }

    public void setApartmentManagement(String apartmentManagement) {
        this.apartmentManagement = apartmentManagement;
    }

    public UUID getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(UUID apartmentId) {
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

    public void setApartmentPrice(double apartmentPrice) {
        this.apartmentPrice = apartmentPrice;
    }

    public ApartmentCategory getApartmentCategory() {
        return apartmentCategory;
    }

    public void setApartmentCategory(ApartmentCategory apartmentCategory) {
        this.apartmentCategory = apartmentCategory;
    }

    public ApartmentBuilder(UUID apartmentId, String apartmentAddress, double apartmentPrice, ApartmentCategory apartmentCategory,
                      String apartmentManagement) {
        super();
        this.apartmentId = apartmentId;
        this.apartmentAddress = apartmentAddress;
        this.apartmentPrice = apartmentPrice;
        this.apartmentCategory = apartmentCategory;
        this.apartmentManagement = apartmentManagement;
    }

    public ApartmentBuilder(String s) {
        String[] tokens = s.split(",");
        this.apartmentId = UUID.fromString(tokens[0]);
        this.apartmentAddress = tokens[1];
        this.apartmentPrice = Double.parseDouble(tokens[4]);
        this.apartmentCategory = ApartmentCategory.getApartmentCategory(tokens[2]);
        this.apartmentManagement = tokens[3];
    }

    @Override
    public Apartment build() {
        return ApartmentFactory.getInstance().getObject(this);
    }
}
