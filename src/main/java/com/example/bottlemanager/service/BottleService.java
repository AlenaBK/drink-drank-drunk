package com.example.bottlemanager.service;

import com.example.bottlemanager.model.Bottle;

import java.util.List;

public interface BottleService {
    public void addBottle(Bottle bottle);

    public void updateBottle(Bottle bottle);

    public void removeBottle(int id);

    public Bottle getBottleById(int id);

    public List<Bottle> listBottles();
}
