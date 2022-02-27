package com.mojisilva.apivacinadoscovid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vaccine")
public class VacinneController {

    @GetMapping
    public String teste(){
        return "teste api";
    }


}
