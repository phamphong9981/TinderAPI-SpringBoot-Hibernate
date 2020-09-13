package com.example.tinder;

import com.example.tinder.controller.AccountController;
import com.example.tinder.controller.ApplicationController;
import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {
        AccountEntity accountEntity=new AccountController().getAccount("phamphong");
        AccountEntity accountEntity1=new AccountController().getAccount("ngoctrang");
        new ApplicationController().like(accountEntity.getPersonEntity(),accountEntity1.getPersonEntity());
    }
}
