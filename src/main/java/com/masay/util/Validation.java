package com.masay.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class Validation {
    private static Scanner scanerObj = new Scanner(System.in);
    private static EntityManager em = PersistenceManager.getEntityManager();

    public static String stringScannerMeth(int length , boolean islower) {
        // Defining Variable :
        String Text;
        do {
            Text = islower ? scanerObj.nextLine().trim().toLowerCase() : scanerObj.nextLine().trim();

            if (Text.length() > length) {
                break;
            }
            System.out.print("Field Should Be Greater Than " + length);

        } while (true);

        return Text;

    }
    public static int getChoosenUserInputNumber(int start, int end, String text) {
        // Defining Variables :
        int choosenNum;
        System.out.print(" \n PLease Enter " + text + " Here : ");
        do {
            if (scanerObj.hasNextInt()) { // Checking what users typed before he submittes , to know what type of data he entered
                choosenNum = scanerObj.nextInt();
                if (choosenNum >= start && choosenNum <= end) {
                    break;
                }
            }
            System.out.print(" Please Type A Valid Number : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();

        } while (true);

        return choosenNum;
    }
    public static int validInteger(){
        int chosenNum;
        do{
            if(scanerObj.hasNextInt()){
                chosenNum = scanerObj.nextInt();
                break;
            }
            System.out.println("Please Type A Valid Number : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();
        }while (true);
        return chosenNum;
    }
    public static float validFloat(){
        float chosenNum;
        do{
            if(scanerObj.hasNextFloat()){
                chosenNum = scanerObj.nextFloat();
                break;
            }
            System.out.println("Please Type A Valid Number : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();
        }while (true);
        return chosenNum;
    }

    public static boolean isEmailAlreadyExists(String email, String table){
        try{
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT email FROM " + table + " WHERE email:email");
            query.setParameter(email,email);
            em.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

}