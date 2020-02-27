package com.dhonig.cityconnections.factory;

import com.dhonig.cityconnections.model.CityData;
import com.dhonig.cityconnections.util.SetTestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CityDataFactoryTest {


    static Set<String> referenceSet;

    @BeforeAll
    public static void initializeReferenceSet(){
        referenceSet=new HashSet<String>();
        referenceSet.add("New York");
        referenceSet.add("Newark");
        referenceSet.add("Trenton");
        referenceSet.add("Philadelphia");
        referenceSet.add("Boston");
        referenceSet.add("Albany");
    }


    @Autowired
    private CityDataFactory factory;

    @Test
    @DisplayName("Check to make sure the unique cities are located correctly.")
    public  void testFactoryReadsUniqueCitiesCorrectly() throws Exception{
        Set uniqueCities=factory.getObject().getUniqueCities();
        assertTrue(SetTestUtil.equals(referenceSet,uniqueCities));
    }

    @Test
    @DisplayName("Check to make sure the city pairs from file is are as expected.")
    public void testFactoryPopulatesCityPairsInCorrectShape(){
        ArrayList<String[]> cityPairs=factory.getObject().getCityPairs();
        //Not the best assertions, but at least we can tell if the expected input test data changes
        assertEquals(cityPairs.size(),4);
        String[] pair=cityPairs.get(0);
        assertEquals(pair.length,2);
    }

}
