package com.dhonig.cityconnections.rest;

import com.dhonig.cityconnections.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ConnectionsController {

    @Autowired
    SearchService searchService;

    @GetMapping("/healthcheck")
    public ResponseEntity<String> message() {//REST Endpoint.
        return ResponseEntity.ok("All Systems nominal.");
    }


    @GetMapping("/connected")
    public ResponseEntity<String> isConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
        boolean result=false;
        try {
            result = searchService.search(origin, destination);
        } catch (IllegalArgumentException e) {
            //User may have entered unexpected input
            result = false;
        } catch (Exception e) {
            System.out.println("Error executing graph traversal");
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Unknown error during graph traversal.");
        }

        String msg = (result == true) ?  "yes" : "no";
        return ResponseEntity.ok(msg);
    }
}