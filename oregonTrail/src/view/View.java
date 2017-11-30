/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;

/**
 *
 * @author Kevin's Account
 */
public abstract class View implements ViewInterface {

    protected String menu;
    protected final BufferedReader keyboard = OregonTrail.getInFile();
    protected final PrintWriter console = OregonTrail.getOutFile();

    public View() {

    }

    public View(String message) {
        this.menu = message;
    }

    @Override
    public void display() {
        boolean done = false;
        do {
            this.console.println(this.menu);
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
                this.console.println("You must enter a valid number");
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
                this.console.println("You must enter a valid number");
                waitForEnterKey();
            }
        }

        return number;
    }

    public String getMenuFeedback() {

        String input = "";
        boolean valid = false;

        while (!valid) {
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "ERROR READING INPUT " + ex.getMessage());
                return null;

            }
            input = input.trim();

            if (input.length() < 1) {
                this.console.println("\nInvalid input: input cannot be blank");
                continue;
            }
            if (input.length() > 1) {
                this.console.println("\nInvalid input: input cannot be more than 1 character");
                continue;
            }

            break;
        }

        return input.toLowerCase();
    }

    public String getPlayerFeedback() {
        
        String input = "";
        boolean valid = false;

        while (!valid) {
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(), "ERROR READING INPUT " + ex.getMessage());
                return null;
            }
            input = input.trim();

            if (input.length() < 1) {
                this.console.println("\nInvalid input: input cannot be blank");
                continue;
            }

            break;
        }

        return input;
    }

    public void waitForEnterKey() {
        this.console.println("\nPress the Enter key to continue...");
        try {
            // Just waiting for a key input to continue MJ
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
