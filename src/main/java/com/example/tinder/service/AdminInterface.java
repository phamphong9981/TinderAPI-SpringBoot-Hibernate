package com.example.tinder.service;

import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;

import java.util.List;

public interface AdminInterface {
    public List<AccountEntity> getAccountFrom(int position, int size);
    public List<PersonEntity> getAllMatch(int id);
}
