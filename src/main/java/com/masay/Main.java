package com.masay;

import com.masay.dao.AddressDao;
import com.masay.dao.OperatorDao;
import com.masay.dao.UserDao;
import com.masay.entity.Address;
import com.masay.entity.Operator;
import com.masay.entity.User;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

public class Main {

    static OperatorDao operatorDao = new OperatorDao();
    static AddressDao addressDao = new AddressDao();
    static UserDao userDao = new UserDao();


    static Scanner scanner = new Scanner(System.in);

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

            System.out.print("    Please enter your choice : ");

            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    signup();
                    break;
                case 2:
                    login();
                    break;
            }

        } while(choice != 0);

    }

    public static void signup(){

        System.out.println("                          ");
        System.out.println("                          ");
        System.out.println("SIGNUP                    ");
        System.out.println("--------------------------");
        System.out.println("                          ");

        System.out.println("[1] - OPERATOR            ");
        System.out.println("[2] - CUSTOMER            ");
        System.out.println("[3] - DELIVERER           ");
        System.out.println("                          ");

        System.out.print("Please enter your choice : ");

        int signupChoice = scanner.nextInt();


        switch(signupChoice) {
            case 1:
                addOperator();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                addDeliverer();
                break;
        }

    }

    public static  void addOperator(){

        System.out.println("                               ");
        System.out.println("                               ");
        System.out.println("Please enter your information :");
        System.out.println("-------------------------------");
        System.out.println("                               ");

        System.out.print("Enter your name : ");
        String name = scanner.next();

        System.out.print("Enter your email : ");
        String email = scanner.next();

        System.out.print("Enter your phone : ");
        String phone = scanner.next();

        System.out.print("Enter your password : ");
        String password = scanner.next();

        System.out.print("Enter your position : ");
        String position = scanner.next();

        Operator operator = new Operator(name, email, phone, password,"operator", position);

        Operator createdOperator =  operatorDao.addOperator(operator);
        System.out.println("                                       ");
        System.out.println("                                       ");

        System.out.println("Please enter your address :");
        System.out.println("----------------------------");
        System.out.println("                             ");

        System.out.print("Enter your country : ");
        String country = scanner.next();

        System.out.print("Enter your city : ");
        String city = scanner.next();

        System.out.print("Enter your street : ");
        String street = scanner.next();

        System.out.print("Enter your home number : ");
        int homeNumber = scanner.nextInt();

        Address address = new Address(country, city, street, homeNumber);

        address.setUser(createdOperator);

        addressDao.addAddress(address);

    }

    public static  void addCustomer(){ }

    public static  void addDeliverer(){ }

    public static void login(){

        System.out.println("                          ");
        System.out.println("                          ");
        System.out.println("LOGIN TO YOUR ACCOUNT     ");
        System.out.println("---------------------     ");
        System.out.println("                          ");

        System.out.print("Enter Your Email : ");
        String email = scanner.next();

        System.out.print("Enter Your Password : ");
        String password = scanner.next();

        User user = userDao.getUserByEmail(email);

        if(user.getPassword().equals(password)){

            dashboard(user);

        }else{

            System.out.println("Invalid Credentials");

        }

    }

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
                operatorDashboard();
                break;
            case "customer":
                customerDashboard();
                break;
            case "deliverer":
                delivererDashboard();
                break;
        }

    }

    private static void operatorDashboard() {

        System.out.println("[1] - RESTAURANTS CRUD MANAGEMENT");
        System.out.println("[2] - MEALS CRUD MANAGEMENT      ");
        System.out.println("[3] - ORDERS MANAGEMENT          ");
        System.out.println("                                 ");

        System.out.print("Please enter your choice : ");

        int operatorDashboardChoice = scanner.nextInt();

        switch(operatorDashboardChoice) {
            case 1:
                restaurantsCrudManagement();
                break;
            case 2:
                mealsCrudManagement();
                break;
            case 3:
                ordersManagement();
                break;
        }

    }

    public static  void restaurantsCrudManagement(){


        System.out.println("RESTAURANT MANAGEMENT   ");
        System.out.println("------------------------");
        System.out.println("                        ");
        System.out.println("                        ");
        System.out.println("[1] - CREATE RESTAURANT ");
        System.out.println("[2] - GET ALL RESTAURANT");
        System.out.println("                        ");
        System.out.println("                        ");

        System.out.print("Please enter your choice : ");

        int restaurantManagementChoice = scanner.nextInt();

        switch(restaurantManagementChoice) {
            case 1:
                addRestaurant();
                break;
            case 2:
                getAllRestaurant();
                break;
        }


    }

    public static void addRestaurant(){ System.out.println("Add Restaurant Method"); }

    public static void getAllRestaurant(){ System.out.println("Get All Restaurant Method"); }

    public static  void mealsCrudManagement(){ System.out.println("Meals CRUD Management Method"); }

    public static  void ordersManagement(){ System.out.println("Orders Management Method"); }


    private static void customerDashboard() { System.out.println("The Customer Dashboard"); }

    private static void delivererDashboard() { System.out.println("The Deliverer Dashboard"); }

}
