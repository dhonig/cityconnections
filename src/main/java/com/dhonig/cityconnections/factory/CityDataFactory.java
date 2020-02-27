package com.dhonig.cityconnections.factory;

import com.dhonig.cityconnections.model.CityData;
import com.dhonig.cityconnections.util.FlattenUtil;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CityDataFactory implements FactoryBean<CityData> {


    @Value("classpath:data/cities.txt")
    Resource cityFile;

    @Override
    public CityData getObject() {
        ArrayList<String[]> cityData = readCityData();
        Set uniqueCities = uniqueCitiesForArrayList(cityData);
        return new CityData(uniqueCities, cityData);
    }

    private ArrayList<String[]> readCityData() {
        ArrayList<String[]> cityList = new ArrayList<String[]>();
        String line;
        BufferedReader reader=null;
        try {
            InputStream in = cityFile.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                cityList.add(line.split(","));
            }
        } catch (IOException ioe) {
            //Should use a logging framework
            System.out.println("Error reading file");
            ioe.printStackTrace();
        }
        return cityList;
    }


    private Set<String> uniqueCitiesForArrayList(ArrayList<String[]> cityData) {
        Set uniqueCities;
        //Build the list of unique cities by taking each city name and building a unique set
        uniqueCities = (Set) cityData.stream().flatMap(e -> {
            return Arrays.asList(e).stream();
        }).collect(Collectors.toSet());

        return uniqueCities;
    }


    @Override
    public Class<?> getObjectType() {
        return CityData.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
