package org.example;

import java.util.Random;

public class player {
    private String nickName;
    private String gamePawn;
    private Random generator = new Random();

    public player(String nickName) {
        this.nickName = nickName;
        this.gamePawn = getRandomGamePawn();
    }

    private String getRandomGamePawn() {
        int rand = generator.nextInt(11);
        if (rand % 2 == 0) {
            return "X";
        } else return "Y";
    }

    public String getNickName() {
        return nickName;
    }

    public String getGamePawn() {
        return gamePawn;
    }
}
