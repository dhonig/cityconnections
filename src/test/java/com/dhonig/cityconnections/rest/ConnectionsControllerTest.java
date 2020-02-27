package com.dhonig.cityconnections.rest;

import com.dhonig.cityconnections.CityConnectionsApp;
import com.dhonig.cityconnections.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CityConnectionsApp.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConnectionsControllerTest {
    @LocalServerPort
    private int port;

    public final static String YES = "yes";
    public final static String NO = "no";

    @Autowired
    SearchService searchService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenAHealthCheckTest_returnsCorrectResponse() {
        String endpointUrl = "http://localhost:" + port + "/healthcheck";
        ResponseEntity<String> result = restTemplate.getForEntity(endpointUrl, String.class);
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void givenBostonAndNewark_returnsYes() {
        String endpointUrl = "http://localhost:" + port + "/connected?origin={origin}&destination={destination}";
        ResponseEntity<String> result = restTemplate.getForEntity(endpointUrl, String.class, "Boston", "Newark");
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(YES, result.getBody(), "Returned wrong answer");
    }

    @Test
    public void givenBostonAndPhiladelphia_returnsYes() {
        String endpointUrl = "http://localhost:" + port + "/connected?origin={origin}&destination={destination}";
        ResponseEntity<String> result = restTemplate.getForEntity(endpointUrl, String.class, "Philadelphia", "Boston");
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(YES, result.getBody(),"Returned wrong answer");

    }

    @Test
    public void givenPhiladelphiaAndAlbany_returnsNo() {
        String endpointUrl = "http://localhost:" + port + "/connected?origin={origin}&destination={destination}";
        ResponseEntity<String> result = restTemplate.getForEntity(endpointUrl, String.class, "Philadelphia", "Albany");
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(NO, result.getBody(), "Returned wrong answer.");
    }

    @Test
    public void givenUnkownInputs_returnsNo() {
        String endpointUrl = "http://localhost:" + port + "/connected?origin={origin}&destination={destination}";
        ResponseEntity<String> result = restTemplate.getForEntity(endpointUrl, String.class, "FLYME", "TOTHEMOON");
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(NO, result.getBody(), "Returned wrong answer.");
    }
}



