package com.trieunt.Controller;

import com.trieunt.Commons.ReadWriteToFile;
import com.trieunt.Commons.Validation;
import com.trieunt.Models.House;
import com.trieunt.Models.Room;
import com.trieunt.Models.Service;
import com.trieunt.Models.Villa;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.UUID;

public class ServiceController {
    private static Scanner scanner;

    /**
     * Phương thức nhập các thông tin cho service
     * @param service
     * @return service
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static Service addNewService(Service service) {
        service.setId(UUID.randomUUID().toString().replace("-",""));

        System.out.print("Enter name service: ");
        service.setServiceName(new Scanner(System.in).nextLine());
        while (!Validation.checkName(service.getServiceName())) {
            System.out.println("Error: The service name is not valid. Please enter again!");
            System.out.print("Enter name service: ");
            service.setServiceName(new Scanner(System.in).nextLine());
        }

        String contentUsedArea = "Enter the area of use: ";
        String errorMessageUsedArea = "Error: The area used must be a real number and > 30. Please try again!";
        service.setUsedArea(Validation.isDouble(contentUsedArea, errorMessageUsedArea));
        while (service.getUsedArea() < 30) {
            System.out.println(errorMessageUsedArea);
            service.setUsedArea(Validation.isDouble(contentUsedArea, errorMessageUsedArea));
        }

        String contentCostRent = "Enter the rental cost: ";
        String errorMessageCostRent = "Error: The cost of rent must > 0. Please try again!";
        service.setCostRent(Validation.isDouble(contentCostRent, errorMessageCostRent));
        while (service.getCostRent() <= 0) {
            System.out.println(errorMessageCostRent);
            service.setCostRent(Validation.isDouble(contentCostRent, errorMessageCostRent));
        }

        String contentMaximumNumberPeople = "Enter the maximum number of people: ";
        String errorMessageMaximumNumberPeople = "Error: Maximum number of people must > 0 and < 20. Please try again!";
        service.setMaximumNumberPeople(Validation.isInteger(contentMaximumNumberPeople, errorMessageMaximumNumberPeople));
        while (service.getMaximumNumberPeople() < 0 || service.getMaximumNumberPeople() > 20) {
            System.out.println(errorMessageMaximumNumberPeople);
            service.setMaximumNumberPeople(Validation.isInteger(contentMaximumNumberPeople, errorMessageMaximumNumberPeople));
        }


        System.out.print("Enter the lease type: ");
        service.setTypeRent(new Scanner(System.in).nextLine());
        while (!Validation.checkName(service.getTypeRent())) {
            System.out.println("Error: The type rent is not valid. Please enter again!");
            System.out.print("Enter the lease type: ");
            service.setTypeRent(new Scanner(System.in).nextLine());
        }


        return service;
    }

    public static void addNewVilla() {
        ArrayList<Villa> listVillas = ReadWriteToFile.readDataVillasToFile();

        Service villa = new Villa();
        addNewService(villa);

        System.out.print("Enter the room standard: ");
        ((Villa)villa).setRoomStandard(new Scanner(System.in).nextLine());
        while (!Validation.checkName((((Villa)villa).getRoomStandard()))) {
            System.out.println("Error: The room standard is not valid. Please enter again!");
            System.out.print("Enter the room standard: ");
            ((Villa)villa).setRoomStandard(new Scanner(System.in).nextLine());
        }

        System.out.print("Enter description of utilities other: ");
        ((Villa)villa).setOtherDescriptionUtility(new Scanner(System.in).nextLine());
        while (!Validation.checkName((((Villa)villa).getOtherDescriptionUtility()))) {
            System.out.println("Error: The description of utilities is not valid. Please enter again!");
            System.out.print("Enter description of utilities other: ");
            ((Villa)villa).setOtherDescriptionUtility(new Scanner(System.in).nextLine());
        }

        String contentNumberFloors= "Enter the floor number: ";
        String errorNumberFloors = "Error: The floor number must > 0. Please try again!";
        ((Villa)villa).setNumberFloors(Validation.isInteger(contentNumberFloors, errorNumberFloors));
        while (((Villa)villa).getNumberFloors() < 0) {
            System.out.println(errorNumberFloors);
            ((Villa)villa).setNumberFloors(Validation.isInteger(contentNumberFloors, errorNumberFloors));
        }

        String contentPoolArea = "Enter the pool area: ";
        String errorMessagePoolArea = "Error: The pool area must > 0. Please try again!";
        ((Villa)villa).setPoolArea(Validation.isDouble(contentPoolArea, errorMessagePoolArea));
        while (((Villa)villa).getPoolArea() <= 0) {
            System.out.println(errorMessagePoolArea);
            ((Villa)villa).setPoolArea(Validation.isDouble(contentPoolArea, errorMessagePoolArea));
        }


        listVillas.add((Villa)villa);
        ReadWriteToFile.writeDataVillasToFile(listVillas);
    }

    public static void addNewHouse() {
        ArrayList<House> listHouses = ReadWriteToFile.readDataHousesToFile();

        Service house = new House();
        addNewService(house);

        System.out.print("Enter the room standard: ");
        ((House)house).setRoomStandard(new Scanner(System.in).nextLine());
        while (!Validation.checkName(((House)house).getRoomStandard())) {
            System.out.println("Error: The room standard is not valid. Please enter again!");
            System.out.print("Enter the room standard: ");
            ((House)house).setRoomStandard(new Scanner(System.in).nextLine());
        }

        System.out.print("Enter description of utilities other: ");
        ((House)house).setOtherDescriptionUtility(new Scanner(System.in).nextLine());
        while (!Validation.checkName(((House)house).getOtherDescriptionUtility())) {
            System.out.println("Error: The description of utilities is not valid. Please enter again!");
            System.out.print("Enter description of utilities other: ");
            ((House)house).setOtherDescriptionUtility(new Scanner(System.in).nextLine());
        }

        String contentNumberFloors= "Enter the floor number: ";
        String errorNumberFloors = "Error: The floor number must > 0. Please try again!";
        ((House)house).setNumberFloors(Validation.isInteger(contentNumberFloors, errorNumberFloors));
        while (((House)house).getNumberFloors() < 0) {
            System.out.println(errorNumberFloors);
            ((House)house).setNumberFloors(Validation.isInteger(contentNumberFloors, errorNumberFloors));
        }

        listHouses.add((House)house);
        ReadWriteToFile.writeDataHousesToFile(listHouses);
    }

    public static void addNewRoom() {
        ArrayList<Room> listRooms = ReadWriteToFile.readDataRoomsToFile();

        Service room = new Room();
        addNewService(room);

        System.out.print("Enter the free service included: ");
        ((Room)room).setServiceFree(new Scanner(System.in).nextLine());
        while (!Validation.checkName(((Room)room).getServiceFree())) {
            System.out.println("Error: The free service is not valid. Please enter again!");
            System.out.print("Enter the free service included: ");
            ((Room)room).setServiceFree(new Scanner(System.in).nextLine());
        }



        listRooms.add((Room) room);
        ReadWriteToFile.writeDataRoomsToFile(listRooms);
    }

    public static void showAllVillas() {
        ArrayList<Villa> listVillas = ReadWriteToFile.readDataVillasToFile();
        for (Villa villa : listVillas) {
            villa.showInfo();
        }
    }

    public static void showAllHouses() {
        ArrayList<House> listHouses = ReadWriteToFile.readDataHousesToFile();
        for (House house : listHouses) {
            house.showInfo();
        }
    }

    public static void showAllRooms() {
        ArrayList<Room> listRooms = ReadWriteToFile.readDataRoomsToFile();
        for (Room room : listRooms) {
            room.showInfo();
        }
    }

    public static void showAllNameVillaNotDuplicate() {
        String pathVilla = "src/com/trieunt/Data/Villa.csv";
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            System.out.println("File Villa does not exist");
        } else {
            TreeSet<String> listsVilla = ReadWriteToFile.readNameServicesToFile(pathVilla);
            System.out.println("\nList name service Villa not Duplicate:");
            for (String str : listsVilla
            ) {
                System.out.println(str);
            }
        }
    }

    public static void showAllNameHouseNotDuplicate() {
        String pathHouse= "src/com/trieunt/Data/House.csv";
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)) { 
            System.out.println("File House does not exist");
        } else {
            TreeSet<String> listsHouse = ReadWriteToFile.readNameServicesToFile(pathHouse);
            System.out.println("\nList name service House not Duplicate: ");
            for (String str : listsHouse
            ) {
                System.out.println(str);
            }
        }
    }

    public static void showAllNameRoomNotDuplicate() {
        String pathRoom = "src/com/trieunt/Data/Room.csv";
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)) {
            System.out.println("File Room does not exist");
        } else {
            TreeSet<String> listsRoom = ReadWriteToFile.readNameServicesToFile(pathRoom);
            System.out.println("\nList name service Room not Duplicate: ");
            for (String str : listsRoom
            ) {
                System.out.println(str);
            }
        }
    }

}
