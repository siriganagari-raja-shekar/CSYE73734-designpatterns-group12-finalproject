package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Apartment;
import edu.neu.csye7374.Builder.ApartmentBuilder;
import edu.neu.csye7374.Builder.BuilderAPI;

public class ApartmentFactory implements ApartmentFactoryAPI<Apartment> {

	private static ApartmentFactory instance = new ApartmentFactory(); // Eager Singleton Factory Class

	private ApartmentFactory() {
		super();
	}

	public synchronized static ApartmentFactory getInstance() {
		return instance;
	}

	@Override
	public Apartment getObject(BuilderAPI<Apartment> builder) {
		// TODO Auto-generated method stub
		ApartmentBuilder apartmentBuilder = (ApartmentBuilder) builder;
		return new Apartment(apartmentBuilder);
	}

}
