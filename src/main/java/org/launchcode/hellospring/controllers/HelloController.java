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
//    @GetMapping()
//    public String helloq() {
//        return "Hello, Spring No Path";
//    }

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
                "<form action= 'create' method= 'post'>" +
                "<input type= 'text' name= 'name'>" +
                "<select name=\"language\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"en\">English</option>\n" +
                "    <option value=\"sp\">Spanish</option>\n" +
                "    <option value=\"fr\">French</option>\n" +
                "    <option value=\"it\">Italian</option>\n" +
                "    <option value=\"gr\">German</option>\n" +
                "</select>\n" +
                "<input type= 'submit' value= 'Enter name!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    /*
    <form action="https://handlers.education.launchcode.org/request-parrot" method="POST">
   <label>Username <input type="text" name="username"></label>
   <label>Team Name <input type="text" name="team"></label>
   <button>Submit</button>
</form>

     */

//    @GetMapping("form")
//    public String helloForm() {
//        return createMessage("fr", "Zaphod");
//    }
//
    //@GetMapping("create")
    @RequestMapping(method = RequestMethod.POST, value = "create")
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

}
