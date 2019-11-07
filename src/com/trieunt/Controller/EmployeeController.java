package com.trieunt.Controller;

import com.trieunt.Models.Employee;

import java.util.*;

public class EmployeeController {
    public static Map dataStatic() {
        Map<String, Object> listEmployee = new HashMap<String, Object>();
        listEmployee.put("001", new Employee("Nguyen Tuan Trieu", 27, "Quang Ngai"));
        listEmployee.put("002", new Employee("Dinh Thanh Huong", 23, "Da Nang"));
        listEmployee.put("003", new Employee("Tran Van Quan", 26, "Da Nang"));
        listEmployee.put("004", new Employee("Luong Van Bang", 38, "Hue"));
        listEmployee.put("005", new Employee("Nguyen Huu Tai", 26, "Quang Nam"));
        listEmployee.put("006", new Employee("Phan Huynh Duc", 23, "Quang Binh"));
        listEmployee.put("007", new Employee("Le Thi Thu Nguyet", 24, "Da Nang"));
        listEmployee.put("008", new Employee("Pham Thi Tra Giang", 26, "Da Nang"));
        listEmployee.put("009", new Employee("Nguyen Thanh Hung", 42, "Quang Ngai"));
        listEmployee.put("010", new Employee("Tran Thi Thu", 28, "Da Nang"));
        return listEmployee;
    }
    public static void showInfoEmployee() {
        Map<String, Employee> map = dataStatic();

        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.print(map.get(key));
        }
    }
}
