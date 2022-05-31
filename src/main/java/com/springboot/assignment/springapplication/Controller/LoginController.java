package com.springboot.assignment.springapplication.Controller;

import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.entity.User;
import com.springboot.assignment.springapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class LoginController {


    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(Principal principal){

        return "login";
    }



    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

}
