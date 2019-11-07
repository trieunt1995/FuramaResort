package com.trieunt.Controller;

import com.trieunt.Models.Customer;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static int choose = 0;

    /**
     * Phương thức khởi tạo này sẽ được chạy đầu tiên trong phương thức main trong views.
     */
    public static void init() {
        runMainMenu();
    }

    /**
     * Phương thức gọi menu chính. Gọi lại 2 phương thức display và choose để thực hiện yêu cầu
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void runMainMenu() {
        while (true) {
            displayMainMenu();
            choose = scanner.nextInt();
            chooseMainMenu(choose);
        }
    }

    /**
     * Phương thức gọi menu service. Gọi lại 2 phương thức display và choose để thực hiện yêu cầu
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void runServiceMenu() {
        while (true) {
            displayServiceMenu();
            choose = scanner.nextInt();
            chooseServiceMenu(choose);
        }
    }

    /**
     * Phương thức gọi booking resort. Gọi lại 2 phương thức display và choose để thực hiện yêu cầu
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void runBookingResortMenu() {
        while (true) {
            displayShowBookingResortSubMenu();
            choose = scanner.nextInt();
            chooseBookingResortMenu(choose);
        }
    }



    /**
     * Phương thức gọi menu show service. Gọi lại 2 phương thức display và choose để thực hiện yêu cầu
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void runShowServiceMenu() {
        while (true) {
            displayShowServiceMenu();
            choose = scanner.nextInt();
            chooseShowServiceMenu(choose);
        }
    }


    /**
     * Phương thức hiển thị menu chính. Hiển thị khi lần đầu tiên chạy chương trình
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void displayMainMenu() {
        System.out.println("*--------------------* MAIN MENU FURAMA RESORT *--------------------*");
        System.out.println("* 1. Add new services                                               *");
        System.out.println("* 2. Show services                                                  *");
        System.out.println("* 3. Add new customer                                               *");
        System.out.println("* 4. Show infomation customer                                       *");
        System.out.println("* 5. Show booking resort                                            *");
        System.out.println("* 6. Show infomation employees                                      *");
        System.out.println("* 7. Exit                                                           *");
        System.out.println("*===================================================================*");
        System.out.print("Please choose a function [1-5]: ");
    }

    /**
     * Phương thức chọn chức năng menu chính. Khi người dùng chọn nó sẽ điều hướng đến
     * menu thêm service hoặc hiển thị service
     * @param int - nhận giá trị số nguyên tương ứng với chức năng người dùng chọn
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void chooseMainMenu(int choose) {
        switch (choose) {
            case 1:
                runServiceMenu();
                // Trỏ tới menu add new service
                break;
            case 2:
                runShowServiceMenu();
                // Trỏ tới menu show all service
                break;
            case 3:
                CustomerController.addNewCustomers();
                break;
            case 4:
                CustomerController.showAllCustomers();
                break;
            case 5:
                runBookingResortMenu();
                break;
            case 6:
                EmployeeController.showInfoEmployee();
            case 7:
                System.out.println("*---------------------------> Goodbye! <----------------------------*");
                System.exit(0);
            default:
                System.out.println("Error: Function doesn\'t exist. Please choose again!");
        }
    }

    /**
     * Phương thức hiển thị menu service. Hiển thị khi người dùng chọn chức năng add new service
     * từ menu chính
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void displayServiceMenu() {
        System.out.println("*---------------------* Add New Service Menu *----------------------*");
        System.out.println("* \t1. Add new Villa                                                *");
        System.out.println("* \t2. Add new House                                                *");
        System.out.println("* \t3. Add new Room                                                 *");
        System.out.println("* \t4. Back main menu                                               *");
        System.out.println("* \t5. Exit                                                         *");
        System.out.println("*===================================================================*");
        System.out.print("Please choose a function [1-5]: ");
    }

    /**
     * Phương thức chọn chức năng menu service. Khi người chọn chức năng nó sẽ điều hướng
     * đến phương thức thêm dịch vụ
     * @param int - nhận giá trị số nguyên tương ứng với chức năng người dùng chọn
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void chooseServiceMenu(int choose) {
        switch (choose) {
            case 1:
                ServiceController.addNewVilla();
                break;
            case 2:
                ServiceController.addNewHouse();
                break;
            case 3:
                ServiceController.addNewRoom();
                break;
            case 4:
                backMainMenu();
                break;
            case 5:
                System.out.println("*---------------------------> Goodbye! <----------------------------*");
                System.exit(0);
            default:
                System.out.println("Error: Function doesn\'t exist. Please choose again!");
        }
    }

    /**
     * Phương thức hiển thị menu show service. Khi người dùng chọn chức năng xem danh sách service
     */
    public static void displayShowServiceMenu() {
        System.out.println("*---------------------* Show Service Menu *-------------------------*");
        System.out.println("* \t1. Show all Villa                                               *");
        System.out.println("* \t2. Show all House                                               *");
        System.out.println("* \t3. Show all Room                                                *");
        System.out.println("* \t4. Show all Villa Not Duplicate                                 *");
        System.out.println("* \t5. Show all House Not Duplicate                                 *");
        System.out.println("* \t6. Show all Room Not Duplicate                                  *");
        System.out.println("* \t7. Back main menu                                               *");
        System.out.println("* \t8. Exit                                                         *");
        System.out.println("*===================================================================*");
        System.out.print("Please choose a function [1-5]: ");
    }

    public static void chooseShowServiceMenu(int choose) {
        switch (choose) {
            case 1:
                ServiceController.showAllVillas();
                break;
            case 2:
                ServiceController.showAllHouses();
                break;
            case 3:
                ServiceController.showAllRooms();
                break;
            case 4:
                ServiceController.showAllNameVillaNotDuplicate();
                break;
            case 5:
                ServiceController.showAllNameHouseNotDuplicate();
                break;
            case 6:
                ServiceController.showAllNameRoomNotDuplicate();
                break;
            case 7:
                backMainMenu();
                break;
            case 8:
                System.out.println("*---------------------------> Goodbye! <----------------------------*");
                System.exit(0);
            default:
                System.out.println("Error: Function doesn\'t exist. Please choose again!");
        }
    }

    /**
     * Phương thức hiển thị menu booking resort. Khi người dùng chọn chức năng booking resort trên main menu
     */

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



    public static void chooseBookingResortMenu(int choose) {
        switch (choose) {
            case 1:
                BookingResortController.showCustomerBookResort();
                break;
            case 2:
                backMainMenu();
                break;
            case 3:
                System.out.println("*---------------------------> Goodbye! <----------------------------*");
                System.exit(0);
            default:
                System.out.println("Error: Function doesn\'t exist. Please choose again!");
        }
    }


    /**
     * Phương thức quay lại menu chính
     * @author TrieuNT
     * @version 1.0
     * @since 2019-10-30
     */
    public static void backMainMenu() {
        System.out.print("Your back main menu (Y/N): ");
        String i = new Scanner(System.in).nextLine();
        if (i.equals("Y") || i.equals("y")) {
            runMainMenu();
        } else {
            return;
        }

    }

    public static void backMainMenuBooking() {
        System.out.print("Your back main menu (Y/N): ");
        String i = new Scanner(System.in).nextLine();
        if (i.equals("Y") || i.equals("y")) {
            runBookingResortMenu();
        } else {
            return;
        }

    }

}
