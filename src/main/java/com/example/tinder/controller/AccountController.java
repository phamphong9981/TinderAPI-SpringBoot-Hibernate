package com.example.tinder.controller;

import com.example.tinder.model.AccountEntity;
import com.example.tinder.model.PersonEntity;
import com.example.tinder.service.AccountInterface;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AccountController implements AccountInterface {
    SessionFactory sessionFactory;
    public AccountController(){
        sessionFactory=new Configuration().configure().buildSessionFactory();
    }

    //Checked
    @Override
    public void addAccount(AccountEntity accountEntity) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.persist(accountEntity.getPersonEntity());
            session.persist(accountEntity);
            transaction.commit();
        }catch (Exception ex) {
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    //Checked
    @Override
    public boolean checkAccount(AccountEntity accountEntity) {
        Session session=sessionFactory.openSession();
        try {
            Query query=session.createQuery("from AccountEntity where username=:username and password=:password ");
            query.setParameter("username",accountEntity.getUsername());
            query.setParameter("password",accountEntity.getPassword());
            AccountEntity accountEntity1= (AccountEntity) query.getSingleResult();
        }catch (Exception ex){
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public AccountEntity getAccount(String username) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        AccountEntity accountEntity=null;
        try {
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<AccountEntity> criteriaQuery=criteriaBuilder.createQuery(AccountEntity.class);
            Root<AccountEntity> root=criteriaQuery.from(AccountEntity.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"),username));
            Query<AccountEntity> query=session.createQuery(criteriaQuery);
            accountEntity=query.getSingleResult();
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            session.close();
        }
        return accountEntity;
    }
    //checked
    @Override
    public boolean updatePassword(int id, String password) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            Query query=session.createQuery("update AccountEntity acc set acc.password=:password where acc.personEntity.id=:id");
            query.setParameter("password",password);
            query.setParameter("id",id);
            int result=query.executeUpdate();
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    //checked
    @Override
    public boolean updateInfo(int id, PersonEntity personEntity) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            Query query=session.createQuery("update PersonEntity set name=:name, age=:age, address=:address, describe=:describe where id=:id");
            query.setParameter("name",personEntity.getName());
            query.setParameter("age",personEntity.getAge());
            query.setParameter("address",personEntity.getAddress());
            query.setParameter("describe",personEntity.getDescribe());
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }


    public static void main(String[] args) {
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setUsername("nhatminh");
        accountEntity.setPassword("333333333333");
        System.out.println(new AccountController().checkAccount(accountEntity));
    }
}
