package com.trieunt.Controller;

import com.trieunt.Commons.NameSortComparator;
import com.trieunt.Commons.ReadWriteToFile;
import com.trieunt.Models.Customer;
import com.trieunt.Models.House;
import com.trieunt.Models.Room;
import com.trieunt.Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingResortController {
    private static Scanner scanner = new Scanner(System.in);
    private static int choose = 0;

    public static void displayShowBookingResortSubMenu() {
        System.out.println("*---------------------* Booking Menu *------------------------------*");
        System.out.println("* \t\t1. Add booking Villa                                        *");
        System.out.println("* \t\t2. Add booking House                                        *");
        System.out.println("* \t\t3. Add booking Room                                         *");
        System.out.println("* \t\t4. Back Main Menu                                           *");
        System.out.println("* \t\t5. Exit                                                     *");
        System.out.println("*===================================================================*");
        System.out.print("Please choose a function [1-5]: ");
    }


    public static void showCustomerBookResort() {
        ArrayList<Customer> oldListBooking = ReadWriteToFile.readDataVillasBookingsToFile();
        ArrayList<Customer> listCustomer = ReadWriteToFile.readDataCustomersToFile();

        listCustomer.sort(new NameSortComparator());
        int i = 1;
        for (Customer customer : listCustomer) {
            System.out.print("No: " + i + " - ");
            customer.showInfo();
            i++;
        }
        System.out.print("Choose customer booking service: ");
        Customer customer = listCustomer.get(new Scanner(System.in).nextInt() - 1);
        displayShowBookingResortSubMenu();

        choose = new Scanner(System.in).nextInt();

        switch (choose) {
            case 1:
                ArrayList<Villa> villas = ReadWriteToFile.readDataVillasToFile();
                i = 1;
                for (Villa villa : villas) {
                    System.out.print("No: " + i + " - ");
                    villa.showInfo();
                    i++;
                }
                System.out.print("Choose service Booking: ");
                Villa villa = villas.get(new Scanner(System.in).nextInt() - 1);
                customer.setService(villa);

                break;
            case 2:
                ArrayList<House> houses = ReadWriteToFile.readDataHousesToFile();
                i = 1;
                for (House house : houses) {
                    System.out.print("No: " + i + " - ");
                    house.showInfo();
                    i++;
                }
                System.out.print("Choose service Booking: ");
                House house = houses.get(new Scanner(System.in).nextInt() - 1);
                customer.setService(house);
                break;
            case 3:
                ArrayList<Room> rooms = ReadWriteToFile.readDataRoomsToFile();
                i = 1;
                for (Room room : rooms) {
                    System.out.print("No: " + i + " - ");
                    room.showInfo();
                    i++;
                }
                System.out.print("Choose service Booking: ");
                Room room = rooms.get(new Scanner(System.in).nextInt() - 1);
                customer.setService(room);
                break;
            case 4:
                MainController.backMainMenuBooking();
                break;
            case 5:
                System.out.println("*---------------------------> Goodbye! <----------------------------*");
                System.exit(0);
            default:
                System.out.println("Error: Function doesn\'t exist. Please choose again!");
        }

        oldListBooking.add(customer);
        ReadWriteToFile.writeDataBookingsToFile(oldListBooking);
        System.out.println("\nAdd Booking for: " + customer.getCustomerName() + " successfully!");

    }



}
