package com.trieunt.Models;

public abstract class Service {
    private String id;
    private String serviceName;
    private double usedArea;
    private double costRent;
    private int maximumNumberPeople;
    private String typeRent;

    public Service() {
    }

    public Service(String id, String serviceName, double usedArea, double costRent, int maximumNumberPeople, String typeRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.usedArea = usedArea;
        this.costRent = costRent;
        this.maximumNumberPeople = maximumNumberPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(double usedArea) {
        this.usedArea = usedArea;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getMaximumNumberPeople() {
        return maximumNumberPeople;
    }

    public void setMaximumNumberPeople(int maximumNumberPeople) {
        this.maximumNumberPeople = maximumNumberPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public abstract void showInfo();
}
