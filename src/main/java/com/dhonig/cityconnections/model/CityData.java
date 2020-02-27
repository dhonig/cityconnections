package com.dhonig.cityconnections.model;

import java.util.ArrayList;
import java.util.Set;

public class CityData {
    Set<String> uniqueCities;
    ArrayList<String[]> cityPairs;

    public CityData(Set<String> uniqueCities, ArrayList<String[]> cityPairs) {
        this.uniqueCities = uniqueCities;
        this.cityPairs = cityPairs;
    }

    public Set<String> getUniqueCities() {
        return uniqueCities;
    }

    public void setUniqueCities(Set<String> uniqueCities) {
        this.uniqueCities = uniqueCities;
    }

    public ArrayList<String[]> getCityPairs() {
        return cityPairs;
    }

    public void setCityPairs(ArrayList<String[]> cityPairs) {
        this.cityPairs = cityPairs;
    }
}
