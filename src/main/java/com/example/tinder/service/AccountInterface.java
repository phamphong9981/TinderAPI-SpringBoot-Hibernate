package com.example.tinder.service;

import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInterface {
    public void addAccount(AccountEntity accountEntity);
    public boolean checkAccount(AccountEntity accountEntity);
    public AccountEntity getAccount(String username);
    public boolean updatePassword(int id, String password);
    public boolean updateInfo(int id, PersonEntity personEntity);
}
