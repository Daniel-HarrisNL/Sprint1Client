package com.sprint.client;

import com.sprint.client.Menu.Navigation;

import java.io.IOException;
import java.util.Scanner;

public class GolfApplicationClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("*******************************");
            System.out.println("* Golf Country Club Main Menu *");
            System.out.println("*******************************");

            System.out.println("* View the options below:");
            System.out.println("* M - Members");
            System.out.println("* T - Tournaments");
            System.out.println("* E - Exit");


            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("M")) {
                Navigation.memberMenu();
                System.out.println("\nReturning to main menu...\n\n");
                continue;
            } else if(userInput.equalsIgnoreCase("T")) {
                Navigation.tournamentMenu();
                System.out.println("\nReturning to main menu...\n\n");
                continue;
            } else if(userInput.equalsIgnoreCase("E")) {
                break;
            } else {
                System.out.println("Error: Wrong Input. Please try again.");
                continue;
            }
        }
    }
}
