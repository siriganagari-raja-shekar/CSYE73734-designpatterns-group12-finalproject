package edu.neu.csye7374.Facade;

public enum ApartmentHandoverMethod {
    Digital,
    In_Person;

    public static ApartmentHandoverMethod getApartmentHandoverMethod(String s) {
        switch (s.toLowerCase()) {
            case "handover":
                return ApartmentHandoverMethod.Digital;
            case "inperson":
                return ApartmentHandoverMethod.In_Person;
            default:
                return ApartmentHandoverMethod.In_Person;
        }
    }
}
