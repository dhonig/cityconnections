package com.dhonig.cityconnections.rest;

import com.dhonig.cityconnections.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectionsController {


    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.

       Message msg = new Message(player, "Hello " + player);
        return msg;
    }
}