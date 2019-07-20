package com.iomis.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {


    public User findById(int id){
        return  HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }

 public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
     Transaction tx1 =  session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();

 }

    public void saveAuto(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(auto);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        ((Transaction) tx1).commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
