package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    // Handles Requests at path  /hello (localhost:8080/hello/hellos)
    @GetMapping("hellos")
    public String hello() {
        return "Hello, Spring";
    }

    // Handles Requests at path (localhost:8080/hello)
    @GetMapping()
    public String helloq() {
        return "Hello, Spring No Path";
    }

    // Handles Requests at path  /goodbye (localhost:8080/hello/goodbye)
    // now lives at (localhost:8080/hello/goodbye)
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // Handles Requests at path  /dingo (localhost:8080/hello/dingo)
    // now @ hello/dingo
    @GetMapping("dingo")
    public String dingo() {
        return "Beware!! Dingos Live Here!!";
    }

    // Handles Requests of the form /hello?name=LaunchCode (localhost:8080/hello/hello?name=LaunchCode)
    // now lives @ hello/hello?name=
    //@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, value= "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name;
    }

    // Handles Requests of the form /hello/stringName (localhost:8080/hello/stringName)
    @GetMapping("{name}")
    //@GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name;
    }


    // Handles Form Request
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action= 'hello' method= 'post'>" +
                "<input type= 'text' name= 'name'>" +
                "<input type= 'submit' value= 'Enter name!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
