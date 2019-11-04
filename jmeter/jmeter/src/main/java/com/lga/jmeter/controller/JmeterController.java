package com.lga.jmeter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmeterController {

    private int i = 1;
    private int j = 1;
    @GetMapping("/jmeter/wl")
    public synchronized String jmeterTest01(){

        System.out.println("i = " + i++);
        return "hello wl";
    }

    @PostMapping("/jmeter/lga")
    public synchronized String jmeterTest02(){

        System.out.println("post jmeter " + j++);
        return "hello lga";
    }
}
