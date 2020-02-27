package com.dhonig.cityconnections.rest;

import com.dhonig.cityconnections.model.Message;
import com.dhonig.cityconnections.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ConnectionsController {


    SearchService searchService;

    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.

        Message msg = new Message("Hello " + player);
        return msg;
    }


    @RequestMapping("/connected")
    public Message  isConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination){
        boolean result=searchService.search(origin,destination);
        if(result==true){
            return new Message("yes");
        }else{
            return new Message( "no");
        }


    }
}