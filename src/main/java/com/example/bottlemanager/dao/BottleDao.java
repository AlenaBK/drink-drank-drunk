package com.example.bottlemanager.dao;

import com.example.bottlemanager.model.Bottle;

import java.util.List;

public interface BottleDao {
    public void addBottle(Bottle bottle);

    public void updateBottle(Bottle bottle);

    public void removeBottle(int id);

    public Bottle getBottleById(int id);

    public List<Bottle> listBottles();
}
