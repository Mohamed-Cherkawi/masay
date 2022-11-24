package com.masay.app;

import com.masay.entity.User;
import com.masay.util.Validation;

public class Dashboard {

    public static void dashboard(User user){

        System.out.println("                                                 ");
        System.out.println("                                                 ");
        System.out.println("Welcome To The Dashboard" + " : " + user.getName());
        System.out.println("---------------------------------                ");
        System.out.println("                                                 ");
        System.out.println("                                                 ");

        String dashboardChoice = user.getRole();

        switch(dashboardChoice) {
            case "operator":
                operatorDashboard(user);
                break;
            case "customer":
                customerDashboard();
                break;
            case "deliverer":
                delivererDashboard();
                break;
        }

    }
    private static void operatorDashboard(User user) {
        int operatorDashboardChoice;
        do {
            System.out.println("[1] - RESTAURANTS MANAGEMENT");
            System.out.println("[2] - MEALS  MANAGEMENT      ");
            System.out.println("[3] - ORDERS MANAGEMENT          ");
            System.out.println("[0] - Lougout                    ");
            System.out.println("                                 ");


            operatorDashboardChoice = Validation.getChoosenUserInputNumber(0,3,"your choice");

            switch (operatorDashboardChoice) {
                case 1:
                    RestaurantManager.restaurantsCrudManagement(user);
                    break;
                case 2:
                    MealManagement.mealsCrudManagement();
                    break;
                case 3:
                    OrderManagement.ordersManagement();
                    break;
            }
        }while (operatorDashboardChoice != 0);

    }

    private static void customerDashboard() {
        CustomerManager.showCustomerMenu();
    }

    private static void delivererDashboard() {  }

}
