package com.masay.app;

import com.masay.dao.UserDao;
import com.masay.entity.User;
import com.masay.util.Validation;

public class Authentication {

    private static UserDao userDao = new UserDao();
    public static void login() {

        System.out.println("                          ");
        System.out.println("                          ");
        System.out.println("LOGIN TO YOUR ACCOUNT     ");
        System.out.println("---------------------     ");
        System.out.println("                          ");

        System.out.print("Enter Your Email : ");
        String email = Validation.stringScannerMeth(0, true);

        System.out.print("Enter Your Password : ");
        String password = Validation.stringScannerMeth(0, false);

        User user = userDao.getUserByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {

                Dashboard.dashboard(user);
            } else {
                System.out.println("\n \nThe password is not valid");
            }
        }
    }

    public static void signup(){
        int signupChoice;
        do {
            System.out.println("                          ");
            System.out.println("                          ");
            System.out.println("SIGNUP                    ");
            System.out.println("--------------------------");
            System.out.println("                          ");

            System.out.println("[1] - OPERATOR            ");
            System.out.println("[2] - CUSTOMER            ");
            System.out.println("[3] - DELIVERER           ");
            System.out.println("[0] - BACK                ");
            System.out.println("                          ");

            signupChoice = Validation.getChoosenUserInputNumber(0, 3, "your choice");


            switch (signupChoice) {
                case 1:
                    OperatorManagement.addOperator();
                    break;
                case 2:
                   CustomerManager.addCustomer();
                    break;
                case 3:
                   // addDeliverer();
                    break;
            }
        } while (signupChoice != 0);
    }
}
