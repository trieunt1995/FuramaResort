package com.trieunt.Commons;

import java.util.Scanner;

public class Validation {


    public static boolean checkName(String content){
        return content.matches("^([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$");
    }

    public static double isDouble(String content, String errorMessage){
        while(true){
            try {
                System.out.print(content);
                return new Scanner(System.in).nextDouble();

            }catch (Exception e){
                System.out.println(errorMessage);
            }
        }
    }

    public static int isInteger(String content, String errorMessage){
        while(true){
            try {
                System.out.print(content);
                return new Scanner(System.in).nextInt();

            }catch (Exception e){
                System.out.println(errorMessage);
            }
        }
    }

    public static boolean checkDate(String content){
        return content.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
    }

    public static boolean checkIdCard(String str){
        return str.matches("^[0-9]{9}$");
    }

    public static boolean checkPhoneNumber(String str){
        return str.matches("^[0-9]{10}$");
    }

    public static String checkGender(String content) {
        if(content.matches("^(?:m|M|male|Male)$")) {
            return "Male";
        }
        if(content.matches("^(?:f|F|female|Female)$")) {
            return "Female";
        }
        return "Unknow";
    }

    public static boolean checkEmail(String content){
        return content.matches( "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
    }







}
