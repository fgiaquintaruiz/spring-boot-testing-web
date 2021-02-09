package com.example.testingweb.springboottestingweb;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @Autowired
    private GreetingService service;

    @RequestMapping("/greeting")
    public @ResponseBody String greeting(){
        return service.greet();
    }


}
