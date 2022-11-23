package com.masay;

import com.masay.classes.Authentication;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int choice;

    public static void main(String[] args) {

        do {

            System.out.println("                                                 ");
            System.out.println("                                                 ");
            System.out.println("    #=======================================#    ");
            System.out.println("    |                                       |    ");
            System.out.println("    |     WELCOME TO MASAY APPLICATION      |    ");
            System.out.println("    |                                       |    ");
            System.out.println("    #=======================================#    ");
            System.out.println("                                                 ");
            System.out.println("    #=======================================#    ");
            System.out.println("    |                                       |    ");
            System.out.println("    |    [1] - SIGNUP                       |    ");
            System.out.println("    |    [2] - LOGIN                        |    ");
            System.out.println("    |    [0] - EXIT                         |    ");
            System.out.println("    |                                       |    ");
            System.out.println("    #=======================================#    ");
            System.out.println("                                                 ");
            System.out.println("                                                 ");

            System.out.print("    Please enter your choice : ");

            choice = scanner.nextInt();

            switch(choice) {

                case 1:
                   Authentication.signup();
                    break;

                case 2:
                    Authentication.login();
                    break;

            }

        } while(choice != 0);

    }

}
