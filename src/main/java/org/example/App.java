package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        ticTacToe game = new ticTacToe();
        game.fillGameBoardWithZeros();
        game.printGameBoard();
        System.out.println(game.checkIfGameBoardIsFull());
    }

}
