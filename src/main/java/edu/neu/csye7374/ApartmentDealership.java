package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import edu.neu.csye7374.Builder.ApartmentBuilder;
import edu.neu.csye7374.Builder.BrokerBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Decorator.ApartmentDecorator;
import edu.neu.csye7374.Decorator.CarpetingDecorator;
import edu.neu.csye7374.Decorator.InsuranceDecorator;
import edu.neu.csye7374.Facade.ApartmentHandoverMethod;
import edu.neu.csye7374.Facade.ApartmentAgreementFacade;
import edu.neu.csye7374.Factory.ApartmentFactory;
import edu.neu.csye7374.Factory.BrokerFactory;
import edu.neu.csye7374.Observer.ApartmentAgreement;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.fileUtil.FileUtil;

public class ApartmentDealership{

    private String name;
    private List<Apartment> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static OfferStrategy usingStrategy = OfferStrategy.NONE;
    private static final String FILE_NAME = "src/main/java/edu/neu/csye7374/datastore/ApartmentsData.csv";

    private static Map<OfferStrategy, OfferStrategyAPI> strategyMap = new HashMap<>();
    {
        strategyMap.put(OfferStrategy.StudentOfferStrategy, new StudentOfferStrategy());
        strategyMap.put(OfferStrategy.PromotionalStrategy, new PromotionalStrategy());
        strategyMap.put(OfferStrategy.FamilyOfferStrategy, new FamilyOfferStrategy());
        strategyMap.put(OfferStrategy.NewMemberOfferStrategy, new NewMemberOfferStrategy());
    }

    public ApartmentDealership(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Apartment> getItemList() {
        return itemList;
    }

    public void setItemList(List<Apartment> itemList) {
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public static OfferStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public static void setUsingStrategy(OfferStrategy usingStrategy) {
        ApartmentDealership.usingStrategy = usingStrategy;
    }

    public static Map<OfferStrategy, OfferStrategyAPI> getstrategyMap() {
        return strategyMap;
    }

    public static void setAlgorithmMap(Map<OfferStrategy, OfferStrategyAPI> strategyMap) {
        ApartmentDealership.strategyMap = strategyMap;
    }

    public static void demo() {

        FileUtil.getFileData(FILE_NAME);

        List<Apartment> apartmentList = new ArrayList<>();
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("------------ Builder ------- Eager Singleton ------- Factory Patterns used -------");
        ApartmentBuilder apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "111 Park Drive", 1150000, ApartmentCategory.STUDIO, "Skyline Builders");
        ApartmentAPI apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        apartmentList.add((Apartment) apartment);
        System.out.println("");
        System.out.println(apartment);
        FileUtil.appendEntryToFile(FILE_NAME, apartmentBuilder);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));

        System.out.println("\n");
        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Prototype ------------");
        System.out.println("");
        Management manufact = Management.getInstance();
        Management man = manufact.clone();
        man.setManagementName("DKR Builders");
        man.setManufacturingYear(2020);
        man.setNoOfPropertiesSoldOrRented(20);
        System.out.println(man);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Adapter Pattern using Apartment ------------");
        System.out.println("");
        ManagementObjectAdapter managementAdapter = new ManagementObjectAdapter(apartment, man);

        System.out.println(managementAdapter);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Facade ----------- Decorator ---------- Observer ------------");
        System.out.println("");
        ApartmentAgreementFacade agreementFacade = new ApartmentAgreementFacade(apartment);
        ApartmentAgreement agreement = agreementFacade.apartmentAgreement();
        System.out.println("");
        System.out.println(agreement);
        System.out.println("");
        agreement.setApartmentHandoverMethod(ApartmentHandoverMethod.Digital);

        apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "140 Washington Street", 400000.0, ApartmentCategory.FLAT, "Peterson Constructions");
        apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        ApartmentDecorator apartmentWithSeatDecorator = new CarpetingDecorator(apartment);
        System.out.println(apartmentWithSeatDecorator);
        agreement.addApartment(apartmentWithSeatDecorator);
        System.out.println("");
        System.out.println(agreement);
        System.out.println("");
        apartmentList.add((Apartment) apartment);
        FileUtil.appendEntryToFile(FILE_NAME, apartmentBuilder);

        apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "2408 Park Street", 490000.0, ApartmentCategory.TOWNHOUSE, "Jackson Buildings");
        apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        ApartmentDecorator apartmentWithInsurance = new InsuranceDecorator(apartment);
        System.out.println(apartmentWithInsurance);
        agreement.addApartment(apartmentWithInsurance);
        System.out.println("");
        System.out.println(agreement);
        System.out.println("");
        apartmentList.add((Apartment) apartment);
        FileUtil.appendEntryToFile(FILE_NAME, apartmentBuilder);

        apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "500 Yale Street", 600000.0, ApartmentCategory.PENTHOUSE, "Jackson Buildings");
        apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        agreement.addApartment(apartment);
        System.out.println(agreement);
        apartmentList.add((Apartment) apartment);
        FileUtil.appendEntryToFile(FILE_NAME, apartmentBuilder);

        apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "333 Moody Street", 145000.0, ApartmentCategory.CONDO, "Peterson Constructions");
        apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        agreement.addApartment(apartment);
        System.out.println(agreement);
        apartmentList.add((Apartment) apartment);

        apartmentBuilder = new ApartmentBuilder(UUID.randomUUID(), "1413 Carlson Street", 450000.0, ApartmentCategory.STUDIO, "Skyline Builders");
        apartment = ApartmentFactory.getInstance().getObject(apartmentBuilder);
        agreement.addApartment(apartment);
        System.out.println(agreement);
        apartmentList.add((Apartment) apartment);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Command Pattern ------------");
        System.out.println("");
        Invoker invoker = new Invoker();
        System.out.println("######## Sold Apartments #########");
        invoker.placeApartmentAgreements(apartmentList);
        System.out.println("");
        System.out.println("######## Rented Apartments #########");
        invoker.rentApartmentAgreements(apartmentList);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Factory ------------ Singleton ---------- BrokerBuilder ----------");
        System.out.println("");
        ApartmentDealership apartmentDealership = new ApartmentDealership("Super Apartments Store");
        BrokerBuilder brokerBuilder = new BrokerBuilder(UUID.randomUUID(), 27, "John", "Doe", 18.5);
        Broker broker = BrokerFactory.getInstance().getObject(brokerBuilder);
        System.out.println(broker);
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- State ------------");
        System.out.println("");
        
        agreement.confirmAgreement();
        System.out.println("Trying to confirm the agreement after the agreement is confirmed");
        agreement.apartmentConfirmed_state();
        System.out.println("Trying to deliver the agreement after the agreement is confirmed");
        agreement.apartmentHandovered_state();
        System.out.println("Trying to dispatch the agreement after the agreement is confirmed");
        agreement.apartmentHandoverStatus_state();
        System.out.println("Trying to deliver the agreement after the agreement is dispatched");
        agreement.apartmentHandovered_state();
        System.out.println("Trying to deliver the agreement after the agreement is handovered");
        agreement.apartmentHandovered_state();
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Strategy ------------");
        System.out.println("");
        System.out.println("Apartment before discount: \n" + apartment);
        double price = 0;
        for (OfferStrategy strategy : ApartmentDealership.getstrategyMap().keySet()) {
            agreement.setUsingStrategy(strategy);
            price = agreement.runStrategy();
            System.out.println("Apartment price after discount during sale: " + strategy + " Price :" + price);
        }
        System.out.println("");
        System.out.println("" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");
    }

}
