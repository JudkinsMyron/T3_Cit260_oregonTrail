/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Kevin's Account
 */
public abstract class View implements ViewInterface {

    protected String menu;

    public View() {

    }

    public View(String message) {
        this.menu = message;
    }

    @Override
    public void display() {
        boolean done = false;
        do {
            System.out.println(this.menu);
            String input = getMenuFeedback();
            if (input.toLowerCase().equals("q")) {
                return;
            }

            done = this.doAction(input);
        } while (!done);
    }

    public Integer getIntFromString() {
        Integer number = null;
        while (number == null) {
            String input = getPlayerFeedback();

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter a valid number");
                waitForEnterKey();
            }
        }

        return number;
    }

    public Double getDoubleFromString() {
        Double number = null;
        while (number == null) {
            String input = getPlayerFeedback();

            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter a valid number");
                waitForEnterKey();
            }
        }

        return number;
    }

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

    public static void waitForEnterKey() {
        System.out.println("\nPress the Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
