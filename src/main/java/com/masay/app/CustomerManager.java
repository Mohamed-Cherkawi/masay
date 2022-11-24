package com.masay.app;

import com.masay.dao.AddressDao;
import com.masay.dao.CustomerDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.Address;
import com.masay.entity.Customer;
import com.masay.entity.Restaurant;
import com.masay.util.Validation;

public class CustomerManager {
    private static AddressDao addressDao = new AddressDao();
    private static CustomerDao customerDao = new CustomerDao();
    private static RestaurantDao restaurantDao = new RestaurantDao();

    public static void showCustomerMenu(){
        int customerChoice ;
        do {
            System.out.println("[1] - INSPECT RESTAURANTS ");
            System.out.println("[2] - MY ORDERS ");
            System.out.println("[0] - BACK      ");
            System.out.println("                                 ");

            customerChoice = Validation.getChoosenUserInputNumber(0,1,"number");

            switch (customerChoice){
                case 1 :
                    showAllRestaurants();
                    break;
                case 2 :
                    showOrders();
            }

            System.out.println("");
        } while (customerChoice != 0);
    }

    public static  Object addCustomer(){
        System.out.println("                               ");
        System.out.println("                               ");
        System.out.println("Please enter your information :");
        System.out.println("-------------------------------");
        System.out.println("                               ");

        System.out.print("Enter your name : ");
        String name = Validation.stringScannerMeth(0,false) ;

        System.out.print("Enter your email : ");
        String email =  Validation.stringScannerMeth(0,true);

        // Checking The email existence in db
        boolean isEmailExists = Validation.isEmailAlreadyExists(email,"customers");

        if ( isEmailExists ){
            System.out.println("This email is already taken please try another one");
            return null;
        }

        System.out.print("Enter your phone : ");
        String phone =  Validation.stringScannerMeth(0,false);

        System.out.print("Enter your password : ");
        String password =  Validation.stringScannerMeth(0,false);


        Customer customer = new Customer(name, email, phone, password, "customer");// Creating a new operator

        Customer persistedCustomer = customerDao.addCustomer(customer);
        System.out.println("                                       ");
        System.out.println("                                       ");

        System.out.println("Please enter your address :");
        System.out.println("----------------------------");
        System.out.println("                             ");

        System.out.print("Enter your country : ");
        String country =  Validation.stringScannerMeth(0,true);

        System.out.print("Enter your city : ");
        String city =  Validation.stringScannerMeth(0,true);

        System.out.print("Enter your street : ");
        String street =  Validation.stringScannerMeth(0,false);

        System.out.print("Enter your home number : ");
        int homeNumber = Validation.validInteger();

        Address address = new Address(country, city, street, homeNumber);

        address.setUser(persistedCustomer);

        addressDao.addAddress(address);

        System.out.println("The customer was created successfully");

        return null;
    }
    public static void showOrders(){}
    public static void showAllRestaurants(){
        for (Restaurant restaurant : restaurantDao.getAllRestaurants())
            System.out.println(restaurant);

    }
}
