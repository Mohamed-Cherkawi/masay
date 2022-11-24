package com.masay.app;

import com.masay.dao.MealDao;
import com.masay.dao.RestaurantDao;
import com.masay.entity.Meal;
import com.masay.entity.Restaurant;
import com.masay.util.Validation;

import java.util.List;

public class MealManagement {

    private final static RestaurantDao restaurantDao = new RestaurantDao();
    private final static MealDao mealDao = new MealDao();
    public static void mealsCrudManagement(){
        int mealManagementChoice;
        List<Meal> totalMeals = mealDao.getAllMeals();

        do {
            System.out.println("Meal MANAGEMENT   ");
            System.out.println("------------------------");
            System.out.println("                        ");
            System.out.println("                        ");
            System.out.println("[1] - CREATE Meal       ");
            System.out.println("[2] - GET ALL Meals     ");
            System.out.println("[0] - Back              ");
            System.out.println("                        ");
            System.out.println("                        ");


            mealManagementChoice = Validation.getChoosenUserInputNumber(0, 2, "your choice");
            if(  totalMeals.size() == 0){
                mealManagementChoice = 3;
            }
            switch (mealManagementChoice) {
                case 3 :
                    System.out.println("\nYou have to create meals first so you can do the operation");
                    break;
                case 1:
                    addMeal();
                    break;
                case 2:
                    getAllMeals();
            }
        } while (mealManagementChoice != 0);
    }

    public static Object addMeal(){
        int  restaurantId = 0;

        System.out.println("                ");
        System.out.println("                ");
        System.out.println("ADD MEAL :");
        System.out.println("----------------");
        System.out.println("                ");
        System.out.println("                 ");

        System.out.println("\t \t Restaurant List : \n");
        List<Restaurant> restaurantList = restaurantDao.getAllRestaurants();// Getting all the restaurants
        System.out.println("\n \n");
        // Looping through the List
        for( Restaurant resto : restaurantList )
            System.out.println(resto);

        System.out.print("\n \n");
        System.out.println("Please enter the id of the restaurant where you want to create the meal");
        restaurantId = Validation.validInteger();

        boolean isRestoIdExists = restaurantDao.checkIfRestoExistsById(restaurantId);
        if( !isRestoIdExists ) {
            System.out.println("There is no a restaurant with such an id  please create one to create a meal");
            return null;
        }

        System.out.println("Enter the meal name : ");
        String name = Validation.stringScannerMeth(0,false);
        System.out.println("Enter the meal type : ");
        String type = Validation.stringScannerMeth(0,true);
        System.out.println("Enter the meal price : ");
        float price = Validation.validFloat();
        System.out.println("Enter the meal description : ");
        String description = Validation.stringScannerMeth(0,false);
        Restaurant restaurant = restaurantDao.getRestaurantById(restaurantId);
        // Creating a new Meal Object
        Meal meal = new Meal(name,type,price,description,restaurant);
        mealDao.addMeal(meal); // Persisting the object in the database
        System.out.println("\n \n Meal was created successfully");
        return null;
    }
    public static void getAllMeals(){
        int chosenOperation = 0;
        do {
            List<Meal> mealArr = mealDao.getAllMeals();
            for (Meal meal : mealArr)
                System.out.println(meal);

            System.out.println("Meal MANAGEMENT   ");
            System.out.println("------------------------");
            System.out.println("                        ");
            System.out.println("                        ");
            System.out.println("[1] - Modify Meal       ");
            System.out.println("[2] - Delete Meal       ");
            System.out.println("[0] - Back              ");
            System.out.println("                        ");
            System.out.println("                        ");

            chosenOperation = Validation.getChoosenUserInputNumber(0,2,"the operation ");

            switch ( chosenOperation ){
                case 1 :
                    modifyMeal();
                    break;
                case 2 :
                    deleteMeal();
                    break;
            }
        } while (chosenOperation != 0);

    }
    public static void modifyMeal(){
        int chosenMealId = checkMealId("modify");
        if ( chosenMealId != 0 ) {
            System.out.println("\n \n");
            System.out.println("Enter the meal name : ");
            String name = Validation.stringScannerMeth(0, false);
            System.out.println("Enter the meal type : ");
            String type = Validation.stringScannerMeth(0, true);
            System.out.println("Enter the meal price : ");
            float price = Validation.validFloat();
            System.out.println("Enter the meal Description : ");
            String description = Validation.stringScannerMeth(0, false);
            boolean isUpdated = mealDao.updateMeal(chosenMealId, name, type, price, description);

            if (isUpdated) {
                System.out.println("\n Meal was modified successfully");
            } else {
                System.out.println("Something went wrong please try again");
            }
        }
    }
    public static void deleteMeal(){
        int chosenMealId = checkMealId("delete");
        if(chosenMealId != 0) {
            boolean isDeleted = mealDao.deleteMeal(chosenMealId);
            if (isDeleted) {
                System.out.println("Meal deleted successfully");
            } else {
                System.out.println("Something went wrong please try again");
            }
        }
    }
    public static int checkMealId(String operation){
        System.out.println("Enter the  id of the meal which you want to "+ operation);
        int chosenMealId = Validation.validInteger();
        boolean isMealIdExists = mealDao.isMealIdExists(chosenMealId);
        if(isMealIdExists)
         return chosenMealId;

        return 0;
    }

}
