package com.masay.classes;

import com.masay.dao.*;
import com.masay.entity.*;

import java.util.Scanner;

public class Authentication {

    static UserDao userDao = new UserDao();
    static OperatorDao operatorDao = new OperatorDao();
    static CustomerDao customerDao = new CustomerDao();
    static DelivererDao delivererDao = new DelivererDao();
    static AddressDao addressDao = new AddressDao();

    static Scanner scanner = new Scanner(System.in);

    static int signupChoice;

    public static void signup(){

        do {

            System.out.println("                          ");
            System.out.println("                          ");
            System.out.println("SIGNUP                    ");
            System.out.println("--------------------------");
            System.out.println("                          ");
            System.out.println("[1] - OPERATOR            ");
            System.out.println("[2] - CUSTOMER            ");
            System.out.println("[3] - DELIVERER           ");
            System.out.println("[0] - GO BACK             ");
            System.out.println("                          ");

            System.out.print("Please enter your choice : ");

            signupChoice = scanner.nextInt();

            switch (signupChoice) {

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

        }while(signupChoice != 0);

    }

    public static  void addOperator(){

        System.out.println(" ADD OPERATOR : ");
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

        Operator operator = new Operator(name, email, phone, password,"operator");

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

    public static  void addCustomer(){

        System.out.println(" ADD CUSTOMER : ");
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

        Customer customer = new Customer(name, email, phone, password,"customer");

        Customer createdCustomer = customerDao.addCustomer(customer);

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

        address.setUser(createdCustomer);

        addressDao.addAddress(address);
    }

    public static  void addDeliverer(){


        System.out.println(" ADD DELIVERER : ");
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

        Deliverer deliverer = new Deliverer(name, email, phone, password,"deliverer");

        Deliverer createdDeliverer = delivererDao.addDeliverer(deliverer);

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

        address.setUser(createdDeliverer);

        addressDao.addAddress(address);


    }

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

            Dashboard.dashboard(user);

        }else{

            System.out.println("Invalid Credentials");

        }

    }

}
