package ru.selestrel.learn.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.selestrel.learn.spring.dao.PersonDAO;
import ru.selestrel.learn.spring.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonDAO personDAO;


    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person")Person person) {
        model.addAttribute("people", personDAO.index());

        return "adminPage";
    }

    @PatchMapping("/add")
    public String addAdmin(@ModelAttribute("person") Person person) {
        System.out.printf("Id: %d%n", person.getId());

        return "redirect:/people";
    }
}
