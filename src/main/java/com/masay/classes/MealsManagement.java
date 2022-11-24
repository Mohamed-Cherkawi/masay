package com.masay.classes;

import com.masay.dao.MealDao;
import com.masay.dao.OperatorDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.Meal;
import com.masay.entity.Operator;
import com.masay.entity.Restaurant;
import com.masay.entity.User;

import java.util.List;
import java.util.Scanner;

public class MealsManagement {

    static RestaurantDao restaurantDao = new RestaurantDao();
    static MealDao mealDao = new MealDao();

    static Scanner scanner = new Scanner(System.in);

    static int mealsManagementChoice;

    public static  void mealsCrudManagement(User user){

        do {

            System.out.println("MEALS MANAGEMENT   ");
            System.out.println("----------------   ");
            System.out.println("                   ");
            System.out.println("                   ");
            System.out.println("[1] - CREATE MEAL  ");
            System.out.println("[2] - GET ALL MEALS");
            System.out.println("[0] - GO BACK");
            System.out.println("                   ");
            System.out.println("                   ");

            System.out.print("Please enter your choice : ");

            mealsManagementChoice = scanner.nextInt();

            switch (mealsManagementChoice) {

                case 1:
                    addMeal(user);
                    break;

                case 2:
                    getAllMeals();
                    break;

            }
        }while(mealsManagementChoice != 0);

    }


    public static void addMeal(User user){

        System.out.println("                ");
        System.out.println("                ");
        System.out.println("ADD MEAL:       ");
        System.out.println("---------       ");
        System.out.println("                ");
        System.out.println("                 ");

        System.out.print("Enter Meal name : ");
        String name = scanner.next();

        System.out.print("Enter Meal price : ");
        int price = scanner.nextInt();

        Meal meal = new Meal(name, price);

        System.out.println("ADD MEAL TO RESTAURANT :");
        System.out.println("------------------------");

        List<Restaurant> restaurants = restaurantDao.getAllRestaurantsById(user.getId());

        System.out.println("Restaurants : ");
        System.out.println("--------------");

        restaurants.forEach(restaurant -> { System.out.println("[" + restaurant.getId() + "] - " + restaurant.getName()); });

        System.out.print("Enter Your Choice : ");
        Integer restaurant_id = scanner.nextInt();

        Restaurant restaurant = restaurantDao.getRestaurantById(restaurant_id);

        meal.setRestaurant(restaurant);

        mealDao.addMeal(meal);

    }

    private static void getAllMeals() { }

}
