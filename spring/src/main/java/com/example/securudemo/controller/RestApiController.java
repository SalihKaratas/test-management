package com.example.securudemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securudemo.model.User;
import com.example.securudemo.service.UserService;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "http://localhost:3000")
public class RestApiController {
	
    @Autowired
    private UserService userService;
    

    //giriş yapmak yeterli. yetki istemiyor
    @GetMapping("test")
    public String test1(){
        return "calis artik";
    }

    // manager yetkisiyle gorunecek
    @GetMapping("management/reports")
    public String reports(){
        return "raporlarimiz buradadirke";
    }

    @GetMapping("user/blabla")
    public void irs() {
    	userService.irsat();
    }
    
    // admin olmayan goremez
    @GetMapping("admin/users")
    public List<User> users(){
        return userService.findAll();
        
        
    }
}
