package edu.neu.csye7374;

//import edu.neu.csye7374.Factory_Pattern.BrokerFactory;

public class Management implements Cloneable {
    private String managementName;
    private int manufacturingYear;
    private int noOfPropertiesSoldOrRented;
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

    private Management(String managementName, int manufacturingYear, int noOfPropertiesSoldOrRented) {
        super();
        this.managementName = managementName;
        this.manufacturingYear = manufacturingYear;
        this.noOfPropertiesSoldOrRented = noOfPropertiesSoldOrRented;
    }

    public void setValues(String line) {
        String[] values = line.split(",");
        this.setManagementName(values[0]);
        this.setManufacturingYear(Integer.parseInt(values[1]));
        this.setNoOfPropertiesSoldOrRented(Integer.parseInt(values[2]));
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

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getNoOfPropertiesSoldOrRented() {
        return noOfPropertiesSoldOrRented;
    }

    
    public void setNoOfPropertiesSoldOrRented(int noOfPropertiesSoldOrRented) {
        this.noOfPropertiesSoldOrRented = noOfPropertiesSoldOrRented;
    }

    @Override
    public String toString() {
        return managementName + "," + manufacturingYear + "," + noOfPropertiesSoldOrRented;
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
