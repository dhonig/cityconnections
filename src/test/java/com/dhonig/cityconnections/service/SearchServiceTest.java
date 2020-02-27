package com.dhonig.cityconnections.service;

import com.dhonig.cityconnections.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SearchServiceTest {


    @Autowired
    SearchService searchService;

    @Test
    public void givenAConnectedRoute_testTrue() {
        assertTrue(searchService.search("Boston", "New York"), "Should return true for connected");
    }


    @Test
    public void givenARouteNotConnected_testFalse() {
        assertFalse(searchService.search("Philadelphia", "Albany"), "Should return false when not connected");
    }

    @Test
    public void givenInvalidInput_anIllegalArgumentIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertFalse(searchService.search("Colorado", "Miami"), "Should raise IllegalArgumentException. if unknown data is entered.");
        });
    }


}