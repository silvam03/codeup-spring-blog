package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

record Message(String message) {}

@Controller
public class HelloController {
    // Method will listen for GET requests at /hello
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "<h1>Hello from Spring!</h1>";
    }
    // Method will listen for GET request at /json and return application/json as the Content-Type
    // default Content-Type is text/html
    @GetMapping(path = "/json", produces = "application/json")
    @ResponseBody
    public Message returnMessage() {
        return new Message("Hello from Spring!!");
    }
    // RequestMapping is the parent of all other Mapping annotations and can be further customized
    @RequestMapping(path = "/color", method = RequestMethod.GET)
    @ResponseBody
    public String color() {
        return "Royal Blue!";
    }
    // Path variables are established in the URI mapping by curly braces
    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    // If using Path Variables, you must include the annotation in the method parameters
    public String sayHello(@PathVariable String firstName, @PathVariable String lastName) {
        return "<h1>Hello " + firstName + " " + lastName + "</h1>";
    }

//    Views lecture
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/dogpark")
    public String dogpark(Model model) {
        List<String> dogs = new ArrayList<>();
        dogs.add("Bubbles");
        dogs.add("Spot");
        dogs.add("Ezekial");

        model.addAttribute("dogs", dogs);
        return "dogPark";
    }

    @GetMapping("/roll-dice")
    public String rollDice(Model model) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        model.addAttribute("numbers", numbers);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/1")
    public String roll1() {
        var randomNum = Math.floor(Math.random() * 6) + 1;
        if (randomNum == 1) {
            return "roll1";
        }
        return "roll1";
    }
}
