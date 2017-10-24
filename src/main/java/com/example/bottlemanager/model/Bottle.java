package com.example.bottlemanager.model;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "alcohol")
public class Bottle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "name")
    private String alcoholName;

    @Column(name = "strength")
    private Double alcoholStrength;

    @Column(name = "value")
    private Double alcoholValue;

    @Column(name = "quantity")
    private Integer alcoholQuantity;

    @Column(name = "approve", columnDefinition = "true")
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean approved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlcoholName() {
        return alcoholName;
    }

    public void setAlcoholName(String alcoholName) {
        this.alcoholName = alcoholName;
    }

    public Double getAlcoholStrength() {
        return alcoholStrength;
    }

    public void setAlcoholStrength(Double alcoholStrength) {
        this.alcoholStrength = alcoholStrength;
    }

    public Double getAlcoholValue() {
        return alcoholValue;
    }

    public void setAlcoholValue(Double alcoholValue) {
        this.alcoholValue = alcoholValue;
    }

    public Integer getAlcoholQuantity() {
        return alcoholQuantity;
    }

    public void setAlcoholQuantity(Integer alcoholQuantity) {
        this.alcoholQuantity = alcoholQuantity;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "alcoholName='" + alcoholName + '\'' +
                ", alcoholStrength=" + alcoholStrength +
                ", alcoholValue=" + alcoholValue +
                '}';
    }
}
