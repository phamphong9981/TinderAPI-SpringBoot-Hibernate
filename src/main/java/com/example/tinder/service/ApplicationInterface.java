package com.example.tinder.service;

import com.example.tinder.model.PersonEntity;

public interface ApplicationInterface {
    public boolean like(PersonEntity personEntity1, PersonEntity personEntity2);
    public boolean superLike(PersonEntity personEntity1, PersonEntity personEntity2);
    public boolean isLiked(PersonEntity personEntity1,PersonEntity personEntity2);
    public PersonEntity getRandomPerson(int id);
}
