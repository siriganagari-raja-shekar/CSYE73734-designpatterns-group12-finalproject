package edu.neu.csye7374.Builder;

import java.util.UUID;

import edu.neu.csye7374.Broker;
import edu.neu.csye7374.Factory.BrokerFactory;

public class BrokerBuilder implements BuilderAPI<Broker> {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private double wage;
    private double bonus;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public BrokerBuilder(UUID id, int age, String firstName, String lastName, double wage) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wage = wage;
        this.bonus = 0;
    }

    public BrokerBuilder(String s) {
        String[] tokens = s.split(",");
        this.id = UUID.fromString(tokens[0]);
        this.firstName = tokens[1];
        this.lastName = tokens[2];
        this.age = Integer.parseInt(tokens[3]);
        this.wage = Double.parseDouble(tokens[4]);
        this.bonus = Double.parseDouble(tokens[5]);
    }

    @Override
    public Broker build() {
        return BrokerFactory.getInstance().getObject(this);
    }
}
