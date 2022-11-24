package com.masay.classes;

import com.masay.entity.User;

import java.util.Scanner;

public class Dashboard {

    static Scanner scanner = new Scanner(System.in);

    static int operatorDashboardChoice;
    static int customerDashboardChoice;

    public static void dashboard(User user){

        String dashboardChoice = user.getRole();

        switch(dashboardChoice) {

            case "operator":
                operatorDashboard(user);
                break;

            case "customer":
                customerDashboard(user);
                break;

            case "deliverer":
                delivererDashboard();
                break;

        }

    }

    private static void operatorDashboard(User user) {

        do {

            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("Welcome To The Dashboard" + " : " + user.getName());
            System.out.println("---------------------------------                ");
            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("[1] - RESTAURANTS CRUD MANAGEMENT");
            System.out.println("[2] - MEALS CRUD MANAGEMENT      ");
            System.out.println("[3] - ORDERS MANAGEMENT          ");
            System.out.println("[0] - GO BACK          ");
            System.out.println("                                 ");

            System.out.print("Please enter your choice : ");

            operatorDashboardChoice = scanner.nextInt();

            switch (operatorDashboardChoice) {

                case 1:
                   RestaurantManagement.restaurantsCrudManagement(user);
                    break;

                case 2:
                    MealsManagement.mealsCrudManagement(user);
                    break;

                case 3:
                    ordersManagement();
                    break;
            }

        }while (operatorDashboardChoice != 0);

    }


    public static void customerDashboard(User user) {

        do {

            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("Welcome To The Dashboard" + " : " + user.getName());
            System.out.println("---------------------------------                ");
            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("[1] - RESTAURANTS ");
            System.out.println("[2] - ORDERS      ");
            System.out.println("[0] - GO BACK          ");
            System.out.println("                                 ");

            System.out.print("Please enter your choice : ");

            customerDashboardChoice = scanner.nextInt();

            switch (customerDashboardChoice) {

                case 1:
                    CustomersManagement.displayRestaurantsList(user);
                    break;

                case 2:
                    MealsManagement.mealsCrudManagement(user);
                    break;

                case 3:
                    ordersManagement();
                    break;
            }

        }while (operatorDashboardChoice != 0);

    }


    public static void delivererDashboard() { System.out.println("The Deliverer Dashboard"); }

    public static void ordersManagement(){ System.out.println("Orders Management Method"); }

}
