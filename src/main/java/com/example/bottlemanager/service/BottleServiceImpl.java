package com.example.bottlemanager.service;

import com.example.bottlemanager.dao.BottleDao;
import com.example.bottlemanager.model.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BottleServiceImpl implements BottleService {

    @Autowired
    private BottleDao bottleDao;

    public void setBottleDao(BottleDao bottleDao) {
        this.bottleDao = bottleDao;
    }

    @Transactional
    public void addBottle(Bottle bottle) {
        this.bottleDao.addBottle(bottle);
    }

    @Transactional
    public void updateBottle(Bottle bottle) {
        this.bottleDao.updateBottle(bottle);
    }

    @Transactional
    public void removeBottle(int id) {
        this.bottleDao.removeBottle(id);
    }

    @Transactional
    public Bottle getBottleById(int id) {
        return this.bottleDao.getBottleById(id);
    }

    @Transactional
    public List<Bottle> listBottles() {
        return this.bottleDao.listBottles();
    }
}
