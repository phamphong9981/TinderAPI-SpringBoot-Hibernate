package com.example.tinder.api;

import com.example.tinder.controller.AccountController;
import com.example.tinder.model.AccountEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SigninAPI {
    //checked
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String signIn(@RequestBody AccountEntity accountEntity){
        if(new AccountController().checkAccount(accountEntity)){
            return "Account had already existed";
        }else {
            if(accountEntity.getUsername().equals(null)||accountEntity.getPersonEntity().equals(null)||accountEntity.getPersonEntity().getAge()<=0){
                return "Your Information was not complete";
            }else{
                new AccountController().addAccount(accountEntity);
                return "Sign in succeed";
            }
        }
    }

}
