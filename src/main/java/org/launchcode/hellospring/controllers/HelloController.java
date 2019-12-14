package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/hello")
public class HelloController {


    // Handles Requests at path  /hello (localhost:8080/hello/hellos)
    @ResponseBody
    @GetMapping("hellos")
    public String hello() {
        return "Hello, Spring";
    }

    // Handles Requests at path (localhost:8080/hello)
//    @GetMapping()
//    public String helloq() {
//        return "Hello, Spring No Path";
//    }

    // Handles Requests at path  /goodbye (localhost:8080/hello/goodbye)
    // now lives at (localhost:8080/hello/goodbye)
    @ResponseBody
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // Handles Requests at path  /dingo (localhost:8080/hello/dingo)
    // now @ hello/dingo
    @ResponseBody
    @GetMapping("dingo")
    public String dingo() {
        return "Beware!! Dingos Live Here!!";
    }

    // Handles Requests of the form /hello?name=LaunchCode (localhost:8080/hello?name=LaunchCode)
    // now lives @ hello?name=
    //@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, value= "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String lochello = "Hello " + name + "!";
        model.addAttribute("thhello", lochello);
        return "hello";
    }

    // Handles Requests of the form /hello/stringName (localhost:8080/hello/stringName)
    @GetMapping("{name}")
    //@GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String lochello = "Hello " + name + "!";
        model.addAttribute("thhello", lochello);
        return "hello";
    }

    // Handles Form Request
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    //@GetMapping("create")
    @RequestMapping(method = RequestMethod.POST, value= "create")
    //@RequestMapping(method = RequestMethod.POST)
    public static String createMessage(String language, String name) {
        if (language.equals("en")) {
            return "(" + language + ") " + "Hello " + name;
        } else if (language.equals("sp")) {
            return "(" + language + ") " + "Hola " + name;
        } else if (language.equals("fr")) {
            return "(" + language + ") " + "Bonjour " + name;
        } else if (language.equals("it")) {
            return "(" + language + ") " + "Ciao " + name;
        } else if (language.equals("gr")) {
            return "(" + language + ") " + "Hallo " + name;
        } else {
            return "(null) No Language Selected " + name;
        }
    }

    @GetMapping("hellonames")
    public String helloNames(Model model) {
    List<String> locnames = new ArrayList<>();
        locnames.add("Launch");
        locnames.add("CodeLaunch");
        locnames.add("LaunchCode");
        locnames.add("LaunchRockets");
        locnames.add("CodeRockets");
        locnames.add("Rocket Code");
        locnames.add("BlahBLAHBLAG");
        model.addAttribute("thnames", locnames);
        return "hellolist";
    }



}
