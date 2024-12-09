package edu.neu.csye7374;

import edu.neu.csye7374.Builder.BrokerBuilder;

public class Broker extends Person {

    private double wage;

    private double bonus;

    public Broker(BrokerBuilder builder) {
        super(builder.getId(), builder.getAge(), builder.getFirstName(), builder.getLastName());
        this.wage = builder.getWage();
        this.bonus = builder.getBonus();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return this.getId().toString() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getAge() + "," + this.getWage() + "," + this.getBonus();
    }
}
