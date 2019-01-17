package com.example.demo3.Controller;

import com.example.demo3.Entity.Person;
import com.example.demo3.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PersonRepository personRepository;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<Person> all = personRepository.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getFullName() + "<br>"));

        return sb.toString();
    }

    @RequestMapping("/index")
    public String main() {
        return "index";
    }

    @ModelAttribute("persons")
    public List<Person> populatePersons() {
        Iterable<Person> all = personRepository.findAll();
        List<Person> list = new ArrayList<>();
        all.forEach(list::add);
        return list;
    }
    @RequestMapping("/team")
    public String team() {
        return "team";
    }
}