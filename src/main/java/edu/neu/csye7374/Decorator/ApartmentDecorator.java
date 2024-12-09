package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.*;;

public class ApartmentDecorator implements ApartmentAPI {
	protected ApartmentAPI decoratedApartment;

	public ApartmentDecorator(ApartmentAPI decoratedApartment) {
		this.decoratedApartment = decoratedApartment;
	}

	@Override
	public String apartmentDescription() {
		// TODO Auto-generated method stub
		return decoratedApartment.apartmentDescription();
	}

	@Override
	public int noOfApartmentsRented() {
		// TODO Auto-generated method stub
		return decoratedApartment.noOfApartmentsRented();
	}

	public ApartmentAPI getDecoratedApartment() {
		return this.decoratedApartment;
	}

	@Override
	public String toString() {
		return "ApartmentDecorator [ApartmentDecorator :" + apartmentDescription() + ", "
				+ " $ " + getDecoratedApartment() + " $";
	}

	@Override
	public Object getApartmentManagement() {
		return this.decoratedApartment.getApartmentManagement();
	}

	@Override
	public double getApartmentPrice() {
		// TODO Auto-generated method stub
		return this.decoratedApartment.getApartmentPrice();
	}

	@Override
	public void setApartmentManagement(String apartmentManagement) {

	}

    @Override
    public int getApartmentId() {
        return this.decoratedApartment.getApartmentId();
    }

    @Override
    public double getApartmentRentPrice() {
        return this.getApartmentRentPrice();
    }

    @Override
    public String getApartmentAddress() {
        return this.decoratedApartment.getApartmentAddress();
    }

    @Override
    public ApartmentCategory getApartmentCategory() {
        return this.decoratedApartment.getApartmentCategory();
    }
}
