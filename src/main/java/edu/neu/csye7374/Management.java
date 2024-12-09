package edu.neu.csye7374;

//import edu.neu.csye7374.Factory_Pattern.BrokerFactory;

public class Management implements Cloneable {
    private String managementName;
    private int manufacturingYear;
    private int noOfApartmentsSold;
    private static Management instance;

    public Management() {
        super();
    }

    public static synchronized Management getInstance() {
        if (instance == null) {
            instance = new Management();
        }
        return instance;
    }

    private Management(String managementName, int manufacturingYear, int noOfApartmentsSold) {
        super();
        this.managementName = managementName;
        this.manufacturingYear = manufacturingYear;
        this.noOfApartmentsSold = noOfApartmentsSold;
    }

    public void setValues(String line) {
        String[] values = line.split(",");
        this.setManagementName(values[0]);
        this.setNoOfApartmentsReleased(Integer.parseInt(values[1]));
        this.setManufacturingYear(Integer.parseInt(values[2]));
    }

    public String getManagementName() {
        return managementName;
    }

    public Management setManagementName(String managementName) {
        this.managementName = managementName;
        return this;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public Management setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
        return this;
    }

    public int getNoOfApartmentsSold() {
        return noOfApartmentsSold;
    }

    public Management setNoOfApartmentsReleased(int noOfApartmentsReleased) {
        this.noOfApartmentsSold = noOfApartmentsReleased;
        return this;
    }

    @Override
    public String toString() {
        return managementName + "," + manufacturingYear + "," + noOfApartmentsSold;
    }

    @Override
    public Management clone() {
        Management clone = null;

        try {
            clone = (Management) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
