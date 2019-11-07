package com.trieunt.Models;

public class Villa extends Service {
    private String roomStandard;
    private String otherDescriptionUtility;
    private int numberFloors;
    private double poolArea;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usedArea, double costRent, int maximumNumberPeople, String typeRent, String roomStandard, String otherDescriptionUtility, int numberFloors, double poolArea) {
        super(id, serviceName, usedArea, costRent, maximumNumberPeople, typeRent);
        this.roomStandard = roomStandard;
        this.otherDescriptionUtility = otherDescriptionUtility;
        this.numberFloors = numberFloors;
        this.poolArea = poolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherDescriptionUtility() {
        return otherDescriptionUtility;
    }

    public void setOtherDescriptionUtility(String otherDescriptionUtility) {
        this.otherDescriptionUtility = otherDescriptionUtility;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-10s| %-15s| %-15.2f| %-15.2f| %-12d| %-12s| %-12s| %-12s| %-12d| %-12.2f%n", this.getId(), this.getServiceName(),
                this.getUsedArea(), this.getCostRent(), this.getMaximumNumberPeople(),
                this.getTypeRent(), this.roomStandard,
                this.otherDescriptionUtility, this.numberFloors, this.poolArea);
    }
}
