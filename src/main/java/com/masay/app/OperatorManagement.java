package com.masay.app;

import com.masay.dao.AddressDao;
import com.masay.dao.OperatorDao;
import com.masay.entity.Address;
import com.masay.entity.Operator;
import com.masay.util.Validation;

public class OperatorManagement {
    private static AddressDao addressDao = new AddressDao();
    private static OperatorDao operatorDao = new OperatorDao();

    public static  Object addOperator(){
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
        boolean isEmailExists = Validation.isEmailAlreadyExists(email,"operators");

        if ( isEmailExists ){
            System.out.println("This email is already taken please try another one");
            return null;
        }

        System.out.print("Enter your phone : ");
        String phone =  Validation.stringScannerMeth(0,false);

        System.out.print("Enter your password : ");
        String password =  Validation.stringScannerMeth(0,false);

        System.out.print("Enter your position : ");
        String position =  Validation.stringScannerMeth(0,false);

        Operator operator = new Operator(name, email, phone, password, "operator", position);// Creating a new operator

        Operator persistedOperator = operatorDao.addOperator(operator);
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

        address.setUser(persistedOperator);

        addressDao.addAddress(address);

        System.out.println("The operator was created successfully");

        return null;
    }
}
