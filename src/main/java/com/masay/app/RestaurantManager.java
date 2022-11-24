package com.masay.app;

import com.masay.dao.OperatorDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.Operator;
import com.masay.entity.Restaurant;
import com.masay.entity.User;
import com.masay.util.Validation;

import java.util.List;

public class RestaurantManager {

    private static OperatorDao operatorDao = new OperatorDao();
    private static RestaurantDao restaurantDao = new RestaurantDao();

    private static User user;

    public static  void restaurantsCrudManagement(User user){
        // Calling the setter Method to set the User Object under the user attribute to work with it along with all clas smethods
        setUser(user);
        int restaurantManagementChoice;

        do {
            System.out.println("RESTAURANT MANAGEMENT   ");
            System.out.println("------------------------");
            System.out.println("                        ");
            System.out.println("                        ");
            System.out.println("[1] - CREATE RESTAURANT ");
            System.out.println("[2] - GET ALL RESTAURANT");
            System.out.println("[0] - Back              ");
            System.out.println("                        ");
            System.out.println("                        ");


            restaurantManagementChoice = Validation.getChoosenUserInputNumber(0, 2, "your choice");

            switch (restaurantManagementChoice) {
                case 1:
                    addRestaurant();
                    break;
                case 2:
                    getAllRestaurant();
                    break;
            }
        } while (restaurantManagementChoice != 0);

    }

    public static void addRestaurant(){

        System.out.println("                ");
        System.out.println("                ");
        System.out.println("ADD RESTAURANT :");
        System.out.println("----------------");
        System.out.println("                ");
        System.out.println("                 ");

        System.out.print("Enter Restaurant name : ");
        String restaurantName = Validation.stringScannerMeth(0,false);

        Restaurant restaurant = new Restaurant(restaurantName);

        Operator operator = (Operator) operatorDao.getOperatorByEmail(user.getEmail());

        restaurant.setOperator(operator);

        restaurantDao.addRestaurant(restaurant);
        System.out.println("---------------------------------------");
        System.out.println("The restaurant was created successfully");

    }

    public static void getAllRestaurant(){

        List<Restaurant> restaurants = restaurantDao.getAllRestaurants();
        System.out.println("\n \n --------------------------------------------");
        System.out.println("Searching For all the restaurants available ....");

        for ( Restaurant resto : restaurants )
            System.out.println(resto);

        System.out.println("\n \n --------------------------------------------");
    }

    public static void setUser(User user) {
        RestaurantManager.user = user;
    }
}
