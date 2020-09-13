package com.example.tinder.api;

import com.example.tinder.controller.AccountController;
import com.example.tinder.model.AccountEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
public class LoginAPI {
    //checked
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String checkLogin(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password){
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setUsername(username);
        accountEntity.setPassword(password);
        if(new AccountController().checkAccount(accountEntity)){
            return "Login succeed";
        }else {
            return "Login failed";
        }


    }
}
