package com.example.tinder.api;

import com.example.tinder.controller.AccountController;
import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateAPI {
    //checked
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public void update(@RequestParam int id,
                       @RequestParam String password){
        new AccountController().updatePassword(id,password);
    }

    //checked
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public void update(@RequestParam int id,
                       @RequestBody PersonEntity personEntity){
        new AccountController().updateInfo(id,personEntity);
    }
}
