package com.example.calculator.controller;

import com.example.calculator.model.CalculationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {

    @GetMapping("add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed.");
        return a / b;
    }

    @PostMapping("add")
    public double addJson(@RequestBody CalculationRequest request) {
        return request.getA() + request.getB();
    }

    @PostMapping("subtract")
    public double subtractJson(@RequestBody CalculationRequest request) {
        return request.getA() - request.getB();
    }

    @PostMapping("multiply")
    public double multiplyJson(@RequestBody CalculationRequest request) {
        return request.getA() * request.getB();
    }

    @PostMapping("divide")
    public double divideJson(@RequestBody CalculationRequest request) {
        if (request.getB() == 0) throw new ArithmeticException("Division by zero not allowed.");
        return request.getA() / request.getB();
    }
}
