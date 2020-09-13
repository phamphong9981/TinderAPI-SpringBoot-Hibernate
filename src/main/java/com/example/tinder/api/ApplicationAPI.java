package com.example.tinder.api;

import com.example.tinder.controller.AccountController;
import com.example.tinder.controller.AdminController;
import com.example.tinder.controller.ApplicationController;
import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class ApplicationAPI {
    //checked
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public List<AccountEntity> list(@RequestParam(name = "page",defaultValue = "1") int page){
        List<AccountEntity> list=new AdminController().getAccountFrom((page-1)*4,4);
        return list;
    }

    //checked
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PersonEntity get(@PathVariable("id")int id){
        return new ApplicationController().getRandomPerson(id);
    }

    //checked
    @RequestMapping(value = "/{id}/like/{target}",method = RequestMethod.POST)
    public String likeTarget(@PathVariable("id")int id,
                             @PathVariable("target") int target){
        PersonEntity personEntity1=new PersonEntity();
        PersonEntity personEntity2=new PersonEntity();
        personEntity1.setId(id);
        personEntity2.setId(target);
        if (new ApplicationController().like(personEntity1,personEntity2)){
            return "Success";
        }
        return "Error to like API";
    }

    //checked
    @RequestMapping(value = "/{id}/superLike/{target}",method = RequestMethod.POST)
    public String superLikeTarget(@PathVariable("id")int id,
                             @PathVariable("target") int target){
        PersonEntity personEntity1=new PersonEntity();
        PersonEntity personEntity2=new PersonEntity();
        personEntity1.setId(id);
        personEntity2.setId(target);
        if (new ApplicationController().superLike(personEntity1,personEntity2)){
            return "Success";
        }
        return "Error to superLike API";
    }
}
