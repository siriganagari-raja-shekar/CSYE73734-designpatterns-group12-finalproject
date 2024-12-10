package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Broker;
import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.BrokerBuilder;

public class BrokerFactory implements FactoryAPI<Broker> {

    private static BrokerFactory instance; // Lazy Singleton Factory Class

    private BrokerFactory() {
        super();
        instance = null;
    }

    public static synchronized BrokerFactory getInstance() {
        if (instance == null) {
            instance = new BrokerFactory();
        }
        return instance;
    }

    @Override
    public Broker getObject(BuilderAPI<Broker> builder) {
        // TODO Auto-generated method stub
        BrokerBuilder brokerBuilder = (BrokerBuilder) builder;
        return new Broker(brokerBuilder);
    }

}
