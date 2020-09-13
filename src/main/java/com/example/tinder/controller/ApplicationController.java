package com.example.tinder.controller;

import com.example.tinder.model.MatchEntity;
import com.example.tinder.model.PersonEntity;
import com.example.tinder.service.ApplicationInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class ApplicationController implements ApplicationInterface {
    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

    //Checked
    @Override
    public boolean like(PersonEntity personEntity1, PersonEntity personEntity2) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            MatchEntity matchEntity=new MatchEntity();
            matchEntity.setId1(personEntity1.getId());
            matchEntity.setId2(personEntity2.getId());
            matchEntity.setType(1);
            session.persist(matchEntity);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    //Checked
    @Override
    public boolean superLike(PersonEntity personEntity1, PersonEntity personEntity2) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            MatchEntity matchEntity=new MatchEntity();
            matchEntity.setId1(personEntity1.getId());
            matchEntity.setId2(personEntity2.getId());
            matchEntity.setType(2);
            session.persist(matchEntity);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    //Checked
    @Override
    public boolean isLiked(PersonEntity personEntity1, PersonEntity personEntity2) {
        Session session=sessionFactory.openSession();
        try {
            Query query=session.createQuery("FROM MatchEntity WHERE id1="+personEntity1.getId()+" AND id2="+personEntity2.getId());
            query.getSingleResult();
        }catch (Exception ex){
            return false;
        }finally {
            session.close();
        }

        return true;
    }

    //Checked
    @Override
    public PersonEntity getRandomPerson(int id) {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("FROM PersonEntity pe where pe.id!=all (select id2 from MatchEntity where id1=:id) and pe.id!=:id");
        query.setParameter("id",id);
        List<PersonEntity> list=query.getResultList();
        session.close();
        Random random=new Random();
        return list.get(random.nextInt(list.size()));
    }


    public static void main(String[] args) {
        System.out.println(new ApplicationController().getRandomPerson(1).getId());
    }
}
