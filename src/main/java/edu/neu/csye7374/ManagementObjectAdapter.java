package edu.neu.csye7374;

public class ManagementObjectAdapter implements ApartmentAPI {

    private Management management;
    private ApartmentAPI apartment;

    public ManagementObjectAdapter(ApartmentAPI apartment, Management adaptee) {
        this.apartment = apartment;
        this.management = adaptee;
        setApartmentManagement(adaptee.getManagementName());
    }

    @Override
    public String apartmentDescription() {
        // TODO Auto-generated method stub
        return apartment.apartmentDescription();
    }

    @Override
    public Object getApartmentManagement() {
        // TODO Auto-generated method stub
        return Management.class.cast(management);
    }

    @Override
    public String toString() {
        return "###### " + management + "#####, ##### Apartment :" + apartment + "#####";
    }

    @Override
    public double getApartmentPrice() {
        // TODO Auto-generated method stub
        return apartment.getApartmentPrice();
    }

    @Override
    public int noOfApartmentsRented() {
        // TODO Auto-generated method stub
        return apartment.noOfApartmentsRented();
    }

    @Override
    public void setApartmentManagement(String apartmentManagement) {
        // TODO Auto-generated method stub
        this.apartment.setApartmentManagement(apartmentManagement);
    }

    @Override
    public int getApartmentId() {
        return this.apartment.getApartmentId();
    }

    @Override
    public double getApartmentRentPrice() {
        return this.getApartmentRentPrice();
    }

    @Override
    public String getApartmentAddress() {
        return this.apartment.getApartmentAddress();
    }

    @Override
    public ApartmentCategory getApartmentCategory() {
        return this.apartment.getApartmentCategory();
    }

}
