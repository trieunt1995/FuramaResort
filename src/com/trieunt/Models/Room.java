package com.trieunt.Models;

public class Room extends Service {
    private String serviceFree;

    public Room() {
    }

    public Room(String id, String serviceName, double usedArea, double costRent, int maximumNumberPeople, String typeRent, String serviceFree) {
        super(id, serviceName, usedArea, costRent, maximumNumberPeople, typeRent);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-10s| %-15s| %-15.2f| %-15.2f| %-12d| %-12s| %-12s%n", this.getId(), this.getServiceName(),
                this.getUsedArea(), this.getCostRent(), this.getMaximumNumberPeople(),
                this.getTypeRent(), this.serviceFree);
    }
}
