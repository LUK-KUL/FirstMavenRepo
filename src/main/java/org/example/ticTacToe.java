package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    private String[][] gameBoard = new String[3][3];

    private player player1 = new player("Gracz 1", "X");
    private player player2 = new player("Gracz 2", "O");
    Scanner scanner = new Scanner(System.in);

    Random random = new Random();

    public void letsPlayTicTacToe() {
        String choice;
        do {
            player1.setNickName("Gracz 1");
            player2.setNickName("Gracz 2");
            System.out.println("Witajcie w grzej w kółko i krzyżyk!");
            fillGameBoardWithDashes();
            setPlayersNickNames();
            System.out.println("Zaczynajmy grę!");
            printGameBoard();
            int iteration = random.nextInt(101);
            do {
                if (iteration % 2 == 0) {
                    System.out.println("Kolej gracza: " + player2.getNickName() + " grającego: " + player2.getGamePawn());
                    fillGameBoard(player2.getGamePawn());
                    printGameBoard();
                } else {
                    System.out.println("Kolej gracza: " + player1.getNickName() + " grającego: " + player1.getGamePawn());
                    fillGameBoard(player1.getGamePawn());
                    printGameBoard();
                }
                iteration++;
            } while (!checkIfItIsAnyReasonToStop());

            if (checkWhoIsWinner().equals(player1.getNickName()) || checkWhoIsWinner().equals(player2.getNickName())) {
                System.out.println("Zwycięzcą jest: " + checkWhoIsWinner());
            } else System.out.println(checkWhoIsWinner());

            System.out.println("Jeśli chcesz zagrać jeszcze raz wpisz 'tak'");
            choice = scanner.nextLine();
        } while (choice.equals("tak"));

        System.out.println("Do zobaczenia!");
    }

    private void fillGameBoard(String gamePawn) {
        while (true) {
            try {
                getRowAndColumn(gamePawn);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Numery pól tablicy jako liczba całkowita w zakresie od 0 do 2! Podaj inne liczby.");
            } catch (IllegalArgumentException g) {
                System.out.println(g.getMessage());
            }
        }
    }

    private void getRowAndColumn(String gamePawn) throws IllegalArgumentException {
        int row = 0;
        int column = 0;
        System.out.println("podaj numer wiersza: ");
        row = getGameBoardIndex();
        scanner.nextLine();
        System.out.println("podaj numer kolumny: ");
        column = getGameBoardIndex();
        scanner.nextLine();
        if (gameBoard[row][column].equals("-")) {
            gameBoard[row][column] = gamePawn;
        } else {
            throw new IllegalArgumentException("Pole już wypełnione! Podaj inne liczby!");
        }
    }

    private int getGameBoardIndex() {
        int number = 0;
        while (true) {
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Musisz podać liczbę całkowitą! Spróbuj jeszcze raz!");
            }
        }
        return number;
    }


    private void fillGameBoardWithDashes() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = "-";
            }
        }
    }

    private void printGameBoard() {
        System.out.print("   ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print("|" + gameBoard[i][j]);
                if (j == gameBoard.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }

    private boolean checkIfGameBoardIsFull() {
        boolean check = true;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j].equals("-")) {
                    check = false;
                }
            }
        }
        return check;
    }

    private String checkWhoIsWinner() {
        String winnersGamePawn;
        String stringToReturn = "-";
        if ((gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2]))) {
            winnersGamePawn = gameBoard[0][0];
        } else if (gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2])) {
            winnersGamePawn = gameBoard[1][0];
        } else if (gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2])) {
            winnersGamePawn = gameBoard[2][0];
        } else if (gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[1][0].equals(gameBoard[2][0])) {
            winnersGamePawn = gameBoard[0][0];
        } else if (gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1])) {
            winnersGamePawn = gameBoard[0][1];
        } else if (gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[2][2])) {
            winnersGamePawn = gameBoard[0][2];
        } else if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            winnersGamePawn = gameBoard[0][0];
        } else if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
            winnersGamePawn = gameBoard[0][2];
        } else {
            winnersGamePawn = " ";
        }

        if (winnersGamePawn.equals(player1.getGamePawn())) {
            stringToReturn = player1.getNickName();
        } else if (winnersGamePawn.equals(" ")) {
            stringToReturn = "REMIS!";
        } else if (winnersGamePawn.equals(player2.getGamePawn())) {
            stringToReturn = player2.getNickName();
        }
        return stringToReturn;
    }


    public String[][] getGameBoard() {
        return gameBoard;
    }

    private void setPlayersNickNames() {
        System.out.println(player1.getNickName() + " gra przy użyciu " + player1.getGamePawn() + ", wpisz swój Nickname: ");
        player1.setNickName(scanner.nextLine());
        System.out.println("Cześć " + player1.getNickName() + "!");
        System.out.println(player2.getNickName() + " gra przy użyciu " + player2.getGamePawn() + ", wpisz swój Nickname: ");
        player2.setNickName(scanner.nextLine());
        System.out.println("Cześć " + player2.getNickName() + "!");
    }

    private boolean checkIfItIsAnyReasonToStop (){
        if (checkIfGameBoardIsFull()){
            return true;
        } else if (checkWhoIsWinner().equals(player1.getNickName()) || checkWhoIsWinner().equals(player2.getNickName())){
            return true;
        } else return false;
    }
}
