package com.example.tinder.controller;

import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.MatchEntity;
import com.example.tinder.model.PersonEntity;
import com.example.tinder.service.AdminInterface;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminController implements AdminInterface {
    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
    //checked
    @Override
    public List<AccountEntity> getAccountFrom(int position, int size) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from AccountEntity ");

        query.setFirstResult(position);
        query.setMaxResults(size);
        List<AccountEntity> list=query.getResultList();
        session.close();
        return list;
    }
    private PersonEntity getPerson(int id){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from PersonEntity where id=:id");
        query.setParameter("id",id);
        PersonEntity personEntity=(PersonEntity) query.getSingleResult();
        session.close();
        return personEntity;
    }
    @Override
    public List<PersonEntity> getAllMatch(int id) {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from PersonEntity pe inner join pe.list where pe.id=:id");
        query.setParameter("id",id);
        List<?> list=query.getResultList();
        List<PersonEntity> personEntities=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            Object[] objects=(Object[])list.get(i);
            MatchEntity matchEntity= (MatchEntity) objects[1];
            personEntities.add(getPerson(matchEntity.getId2()));
        }
        session.close();
        return personEntities;
    }

    public static void main(String[] args) {
        System.out.println(new AdminController().getAllMatch(1).get(0).getId());
    }
}
