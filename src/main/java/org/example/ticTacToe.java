package org.example;

import java.util.Scanner;

public class ticTacToe {
    private String[][] gameBoard = new String[3][3];

    Scanner scanner = new Scanner(System.in);

    public void fillGameBoard (String gamePawn) {
            try {
                System.out.println("podaj numer wiersza: ");
                int row = scanner.nextInt();
                System.out.println("podaj numer kolumny: ");
                int column = scanner.nextInt();
                scanner.nextLine();
                gameBoard[row][column] = gamePawn;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Numery pól tablicy od 0 do 2!");
            }
    }
    void fillGameBoardWithZeros() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = String.valueOf(i + j);
            }
        }
        gameBoard [0][0] = null;
    }

    public void printGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print("|" + gameBoard[i][j]);
                if (j == gameBoard.length-1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }

    public boolean checkIfGameBoardIsFull () {
        boolean check = true;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == null) {
                    check = false;
                }
            }
        }
        return check;
    }

    public String[][] getGameBoard (){
        return gameBoard;
    }


}
