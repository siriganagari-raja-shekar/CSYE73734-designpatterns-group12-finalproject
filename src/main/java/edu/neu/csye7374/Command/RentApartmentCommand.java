package edu.neu.csye7374.Command;

import edu.neu.csye7374.Apartment;

public class RentApartmentCommand implements CommandAPI {
    private static RentApartmentCommand instance;
    private Apartment apartment;

    private RentApartmentCommand() {
        super();
    }

    public static synchronized RentApartmentCommand getInstance() {
        if (instance == null) {
            instance = new RentApartmentCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return apartment.rentApartment();
    }

    public Apartment getApartment() {
        return apartment;
    }

    public RentApartmentCommand setApartment(Apartment apartment) {
        this.apartment = apartment;
        return this;
    }

}
