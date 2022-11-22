package com.masay.classes;

import com.masay.dao.AddressDao;
import com.masay.dao.OperatorDao;
import com.masay.dao.UserDao;
import com.masay.entity.Address;
import com.masay.entity.Operator;
import com.masay.entity.User;

import java.util.Scanner;

public class Authentication {

    static UserDao userDao = new UserDao();
    static OperatorDao operatorDao = new OperatorDao();
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

            Dashboard.dashboard(user);

        }else{

            System.out.println("Invalid Credentials");

        }

    }

}
