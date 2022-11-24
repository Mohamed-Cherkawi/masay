package com.masay;

import com.masay.app.Authentication;
import com.masay.util.Validation;

import java.sql.SQLException;

public class Main {


    static int choice = 0;

    public static void main(String[] args) throws SQLException {

        do {

            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("    #=======================================#    ");
            System.out.println("    |                                       |    ");
            System.out.println("    |     WELCOME TO MASAY APPLICATION      |    ");
            System.out.println("    |                                       |    ");
            System.out.println("    #=======================================#    ");
            System.out.println("                                                 ");
            System.out.println("    #=======================================#    ");
            System.out.println("    |                                       |    ");
            System.out.println("    |    [1] - SIGNUP                       |    ");
            System.out.println("    |    [2] - LOGIN                        |    ");
            System.out.println("    |    [0] - EXIT                         |    ");
            System.out.println("    |                                       |    ");
            System.out.println("    #=======================================#    ");
            System.out.println("                                                 ");
            System.out.println("                                                 ");


            choice = Validation.getChoosenUserInputNumber(0,2,"your choice");

            switch(choice) {
                case 1:
                    Authentication.signup();
                    break;
                case 2:
                    Authentication.login();
                    break;
            }

        } while(choice != 0);

    }




    public static  void addCustomer(){ }

    public static  void addDeliverer(){ }




}
