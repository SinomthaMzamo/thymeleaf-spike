package org.example.controller;

import org.example.model.ToyRobot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;


@Controller
public class RobotController {
    @GetMapping("/robot")
    public String robot(Model model) {
        ToyRobot robot = new ToyRobot("Fred", LocalDate.of(2022, 2, 2), 38);
        model.addAttribute("bot", robot);
        return "robot-template";
    }
}
