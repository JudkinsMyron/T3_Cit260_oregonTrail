/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import view.StartMenu;

/**
 *
 * @author Kevin's Account
 */
public class OregonTrail {

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            OregonTrail.inFile = new BufferedReader(new InputStreamReader(System.in));
            OregonTrail.outFile = new PrintWriter(System.out, true);
            String filePath = "log.txt";
            OregonTrail.logFile = new PrintWriter(filePath);
            StartMenu startMenu = new StartMenu();
            startMenu.startGame();
        } catch (Throwable te) {
            // This one wouldn't work with ErrorView.display(this.getClass().getName(), mj
            System.out.println(te.getMessage());
            te.printStackTrace();
            StartMenu startMenu = new StartMenu();
            startMenu.startGame();
        } finally {
            try {
                if (OregonTrail.inFile != null) {
                    OregonTrail.inFile.close();
                }
                if (OregonTrail.outFile != null) {
                    OregonTrail.outFile.close();
                }
                if (OregonTrail.logFile != null) {
                    OregonTrail.logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error Closing Files");
                return;
            }

        }

    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        OregonTrail.outFile = outFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        OregonTrail.logFile = logFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        OregonTrail.inFile = inFile;
    }
}
