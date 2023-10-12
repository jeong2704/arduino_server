package com.example.arduinoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArduinoController {

    private boolean buttonPressed = false;

    @GetMapping("/buttonPressed")
    public String buttonPressed(Model model) {
        buttonPressed = true;
        System.out.println("Received signal from Arduino");
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("buttonPressed", buttonPressed);
        if (buttonPressed) {
            buttonPressed = false;
        }
        return "index";
    }
}
