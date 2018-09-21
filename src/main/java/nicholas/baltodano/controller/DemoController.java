package nicholas.baltodano.controller;

import lombok.extern.slf4j.Slf4j;
import nicholas.baltodano.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // Fields
    private final DemoService demoService;

    // Constructors
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    // Request Methods
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello (){
        return "Hello, My friends";
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=???
    @GetMapping("welcome")
    public String welcome(@RequestParam String user,@RequestParam int age,  Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome";
    }

    // Model Attributes
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("Welcome Message called");
        return demoService.getWelcomeMessage();
    }



}
