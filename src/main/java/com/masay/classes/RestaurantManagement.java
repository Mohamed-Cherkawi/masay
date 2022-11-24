package com.masay.classes;

import com.masay.dao.OperatorDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.Operator;
import com.masay.entity.Restaurant;
import com.masay.entity.User;

import java.util.List;
import java.util.Scanner;

public class RestaurantManagement {

    public static OperatorDao operatorDao = new OperatorDao();
    public static RestaurantDao restaurantDao = new RestaurantDao();

    static Scanner scanner = new Scanner(System.in);

    static int restaurantManagementChoice;

    public static  void restaurantsCrudManagement(User user){

        do {

            System.out.println("RESTAURANT MANAGEMENT   ");
            System.out.println("---------------------   ");
            System.out.println("                        ");
            System.out.println("                        ");
            System.out.println("[1] - CREATE RESTAURANT ");
            System.out.println("[2] - GET ALL RESTAURANT");
            System.out.println("[0] - GO BACK");
            System.out.println("                        ");
            System.out.println("                        ");

            System.out.print("Please enter your choice : ");

            restaurantManagementChoice = scanner.nextInt();

            switch (restaurantManagementChoice) {

                case 1:
                    addRestaurant(user);
                    break;

                case 2:
                    getAllRestaurant();
                    break;

            }
        }while(restaurantManagementChoice != 0);

    }

    public static void addRestaurant(User user){

        System.out.println("                ");
        System.out.println("                ");
        System.out.println("ADD RESTAURANT :");
        System.out.println("----------------");
        System.out.println("                ");
        System.out.println("                 ");

        System.out.print("Enter Restaurant name : ");

        String restaurantName = scanner.next();

        Restaurant restaurant = new Restaurant(restaurantName);

        Operator operator = (Operator) operatorDao.getOperatorByEmail(user.getEmail());

        restaurant.setOperator(operator);

        restaurantDao.addRestaurant(restaurant);

    }

    public static void getAllRestaurant(){

        List<Restaurant> restaurants = restaurantDao.getAllRestaurants();

        System.out.println("                                           ");
        System.out.println("                                           ");

        restaurants.forEach((restaurant) -> System.out.println("["+restaurant.getId()+"] - " + restaurant.getName()));

    }


}
