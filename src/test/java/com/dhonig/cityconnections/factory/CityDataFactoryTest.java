package com.dhonig.cityconnections.factory;

import com.dhonig.cityconnections.model.CityData;
import com.dhonig.cityconnections.util.SetTestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CityDataFactoryTest {


    static Set referenceSet;

    @BeforeAll
    public static void initializeReferenceSet(){
        referenceSet=new HashSet<String[]>();
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
    public  void testFactoryReadsCitiesCorrectly() throws Exception{
        Set uniqueCities=factory.getObject().getUniqueCities();
        assertTrue(SetTestUtil.equals(referenceSet,uniqueCities));
    }
}
