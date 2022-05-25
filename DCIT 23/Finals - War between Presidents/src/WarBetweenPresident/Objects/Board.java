package WarBetweenPresident.Objects;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Board {
    private int start = 90;
    private int end = 100;

    private int president = 0;
    private int soldiers = 0;
    private int lightTanks = 0;
    private int mediumTanks = 0;
    private int heavyTanks = 0;

    private int unitPosition = 0;

    private String[] playerBoard = new String[100];
    private String[] recordPlayerBoard = new String[100];
    private String[] computerBoard = new String[100];
    private String[] recordComputerBoard = new String[100];

    private String[] xCoordinates = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String[] yCoordinates = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

    public Board() {
        for(int i = 0; i < playerBoard.length; i++) {
            playerBoard[i] = " ";
            recordPlayerBoard[i] = " ";
            computerBoard[i] = " ";
            recordComputerBoard[i] = " ";
        }

        playerBoard[0] = "M";
        playerBoard[1] = "M";
        playerBoard[10] = "M";
        playerBoard[11] = "M";

        playerBoard[99] = "M";
        playerBoard[98] = "M";
        playerBoard[89] = "M";
        playerBoard[88] = "M";

        playerBoard[47] = "L";
        playerBoard[37] = "L";

        playerBoard[27] = "X";
        playerBoard[14] = "X";
        playerBoard[53] = "X";
        playerBoard[97] = "X";
        playerBoard[32] = "X";
        playerBoard[75] = "X";
    }

    public void getBoard() {
        for (int rows = 0; rows <= 10; rows++) {
            if(rows == 0) {
                System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■     ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\u001B[0m");
                System.out.print("■\u001B[0m # ■ \u001B[0m");
                for(int x = 0; x < xCoordinates.length; x++) System.out.print("\u001B[33m" + xCoordinates[x] + "\u001B[0m ■ \u001B[0m");
                System.out.print("    ■\u001B[0m # ■ \u001B[0m");
                for(int x = 0; x < xCoordinates.length; x++) System.out.print("\u001B[33m" + xCoordinates[x] + "\u001B[0m ■ \u001B[0m");
                System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■     ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\u001B[0m");
            }

            if(rows != 10) {
                System.out.print("■ \u001B[0m\u001B[33m" + yCoordinates[9-rows] + "\u001B[0m ■ \u001B[0m");
                // Board for troops deployment.
                for(int cols = start; cols < end; cols++) {
                    if(cols != end-1) System.out.print("\u001B[31m" + playerBoard[cols] + "\u001B[0m" + " ■ \u001B[0m");
                    else System.out.print("\u001B[31m" + playerBoard[cols] + "\u001B[0m " + " ■ \u001B[0m");
                }

                // Board for battle marks (Missed / Hit).
                System.out.print("    ■ \u001B[0m\u001B[33m" + yCoordinates[9-rows] + "\u001B[0m ■ \u001B[0m");
                for(int cols = start; cols < end; cols++) {
                    if(cols != end-1) System.out.print("\u001B[31m" + recordPlayerBoard[cols] + "\u001B[0m" + " ■ \u001B[0m");
                    else System.out.print("\u001B[31m" + recordPlayerBoard[cols] + "\u001B[0m " + " ■ \u001B[0m");
                }

                start -= 10;
                end -= 10;
                System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■     ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\u001B[0m");
            }
        }
    }

    public void positionUnits() {
        queryLightTankPosition();
    }


    private void queryLightTankPosition() {
        boolean isValid = false;

        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Light tank size: 2x1");
            System.out.print("Enter light tank position (Ex: a1 b1): ");
            String setLightTankPosition = in.nextLine();
            String[] lightTankPosition = setLightTankPosition.split(" ");
        }
    }

    private boolean checkPosition(int position) {
        if(playerBoard[position].equals(" ")) return true;
        return false;
    }
}