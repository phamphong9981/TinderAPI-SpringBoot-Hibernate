package com.example.tinder.api;

import com.example.tinder.controller.AdminController;
import com.example.tinder.model.PersonEntity;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminAPI {
    //checked
    @RequestMapping(value = "/{id}/getAllMatch",method = RequestMethod.GET)
    @ResponseBody
    public List<PersonEntity> personEntities(@PathVariable("id")int id){
        return new AdminController().getAllMatch(id);
    }
}
