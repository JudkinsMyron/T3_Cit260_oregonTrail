/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Kevin's Account
 */
public class MenuTools {
    public static String getMenuFeedback() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean valid = false;

        while (!valid) {
            input = scanner.nextLine();
            input = input.trim();

            if (input.length() < 1) {
                System.out.println("\nInvalid input: input cannot be blank");
                continue;
            }
            if (input.length() > 1) {
                System.out.println("\nInvalid input: input cannot be more than 1 character");
                continue;
            }

            break;
        }

        return input.toLowerCase();
    }

    public static String getPlayerFeedback() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean valid = false;

        while (!valid) {
            input = scanner.nextLine();
            input = input.trim();

            if (input.length() < 1) {
                System.out.println("\nInvalid input: input cannot be blank");
                continue;
            }

            break;
        }

        return input;
    }
}
