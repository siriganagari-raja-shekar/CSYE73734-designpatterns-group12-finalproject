package edu.neu.csye7374;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ApartmentCategory {
    STUDIO,
    FLAT,
    TOWNHOUSE,
    PENTHOUSE,
    CONDO;

    public static List<String> getApartmentCategoryList() {

        return Stream.of(ApartmentCategory.values()).map(ApartmentCategory::name).collect(Collectors.toList());
    }

    public static String[] getApartmentCategoryArray() {
        return Arrays.stream(ApartmentCategory.values()).map(ApartmentCategory::name).toArray(String[]::new);
    }

    public static ApartmentCategory getApartmentCategory(String s) {
        ApartmentCategory result = null;
        switch (s.toLowerCase()) {
            case "studio":
                result = ApartmentCategory.STUDIO;
                break;
            case "flat":
                result = ApartmentCategory.FLAT;
                break;
            case "townhouse":
                result = ApartmentCategory.TOWNHOUSE;
                break;
            case "penthouse":
                result = ApartmentCategory.PENTHOUSE;
                break;
            default:
                result = ApartmentCategory.CONDO;
                break;
        }
        return result;
    }
}
