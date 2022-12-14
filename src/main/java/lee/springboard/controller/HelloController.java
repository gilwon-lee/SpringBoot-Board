package lee.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller -> Annotation(Controller)
@Controller
public class HelloController
{
    //get 형식의 요청에대한 매핑
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        //resources/templates/hello(.html)에 매핑
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name ="name",required = false) String name,Model model){
        model.addAttribute("name",name);
        return "hello-templates";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "Hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
