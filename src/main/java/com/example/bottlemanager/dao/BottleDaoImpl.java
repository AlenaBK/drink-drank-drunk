package com.example.bottlemanager.dao;

import com.example.bottlemanager.model.Bottle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BottleDaoImpl implements BottleDao {
    private static final Logger logger = LoggerFactory.getLogger(BottleDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBottle(Bottle bottle) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bottle);
        logger.info("Bottle successfully saved. Bottle details: " + bottle);
    }

    public void updateBottle(Bottle bottle) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bottle);
        logger.info("Bottle successfully update. Bottle details: " + bottle);
    }

    public void removeBottle(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bottle bottle = (Bottle) session.load(Bottle.class, new Integer(id));

        if(bottle!=null){
            session.delete(bottle);
        }
        logger.info("Bottle successfully removed. Bottle details: " + bottle);
    }

    public Bottle getBottleById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Bottle bottle = (Bottle) session.load(Bottle.class, new Integer(id));
        logger.info("Bottle successfully loaded. Bottle details: " + bottle);

        return bottle;
    }

    @SuppressWarnings("unchecked")
    public List<Bottle> listBottles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bottle> bottleList = session.createQuery("from Bottle").list();

        for(Bottle bottle: bottleList){
            logger.info("Bottle list: " + bottle);
        }

        return bottleList;
    }
}
