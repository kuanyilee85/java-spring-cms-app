package com.kennycode.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    // GET
    // URI - /hello-world
    // method - "Hello World"

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public com.kennycode.helloworld.HelloWorldBean helloWorldBean(){
        return new com.kennycode.helloworld.HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public com.kennycode.helloworld.HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new com.kennycode.helloworld.HelloWorldBean(String.format("Hello World, %s",name));
//        throw new RuntimeException("Something wrong");
    }
}
