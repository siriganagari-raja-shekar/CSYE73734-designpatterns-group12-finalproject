package edu.neu.csye7374.Command;

import edu.neu.csye7374.*;

public class BuyApartmentCommand implements CommandAPI {
    private static BuyApartmentCommand instance;
    private Apartment apartment;

    private BuyApartmentCommand() {
        super();
    }

    public static synchronized BuyApartmentCommand getInstance() {
        if (instance == null) {
            instance = new BuyApartmentCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return apartment.buyApartment();
    }

    public Apartment getApartment() {
        return apartment;
    }

    public BuyApartmentCommand setApartment(Apartment apartment) {
        this.apartment = apartment;
        return this;
    }
}