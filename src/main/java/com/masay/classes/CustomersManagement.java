package com.masay.classes;

import com.masay.dao.CustomerDao;
import com.masay.dao.MealDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.*;

import java.util.List;
import java.util.Scanner;

public class CustomersManagement {

    public static RestaurantDao restaurantDao = new RestaurantDao();
    public static MealDao mealDao = new MealDao();
    public static CustomerDao customerDao = new CustomerDao();

    static Scanner scanner = new Scanner(System.in);

    public static void displayRestaurantsList(User user){

        List<Restaurant> restaurants = restaurantDao.getAllRestaurants();

        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("RESTAURANTS LIST :");
        System.out.println("------------------");
        System.out.println("                  ");

        restaurants.forEach( restaurant -> { System.out.println("[" + restaurant.getId() + "] - " + restaurant.getName()); });
        System.out.println("                  ");

        System.out.print("Please enter your choice :");
        int restaurantId = scanner.nextInt();

        List<Meal> meals = mealDao.getAllMealsByRestaurantId(restaurantId);

            System.out.println("                       ");
            System.out.println("                       ");
            System.out.println("RESTAURANT MEALS LIST :");
            System.out.println("-----------------------");
            System.out.println("                       ");

            meals.forEach(meal -> { System.out.println("[" + meal.getId() + "] - " + meal.getName() + " / " + "( Price : " + meal.getPrice() + " )"); });
            System.out.println("                       ");

            System.out.print("Please enter your choice or 0 to go back :");
            int mealId = scanner.nextInt();

        if(mealId != 0){

            Meal meal = mealDao.getMealById(mealId);

            Customer customer = customerDao.getCustomerByEmail(user.getEmail());

            customer.getMeals().add(meal);

            customerDao.updateCustomer(customer);

        }else{

            displayRestaurantsList(user);

        }


    }

}
