package com.mytestproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    @GetMapping("")
    public String welcome() {
        return "Hey! My frist spring Boot application....";
    }

    @GetMapping("/add")
    public int add (@RequestParam("a") int a, @RequestParam("b") int b) {
        return a+b ;
    }

    @GetMapping("/sub")
    public int sub (@RequestParam("a") int a, @RequestParam("b") int b) {
        return a-b ;
    }

    @GetMapping("/mul")
    public int mul (@RequestParam("a") int a, @RequestParam("b") int b) {
        return a*b ;
    }

    @GetMapping("/div")
    public double div (@RequestParam("a") int a, @RequestParam("b") int b) throws Exception {
        double ans = 0.0 ;
        try {
            ans = (double) a/b ;
        } catch ( ArithmeticException e) {
            throw new Exception("Divided is not Possible");
        }
        return ans ;
    }
}
