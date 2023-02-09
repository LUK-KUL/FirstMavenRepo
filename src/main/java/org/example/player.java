package org.example;


public class player {
    private String nickName;
    private String gamePawn;

    public player(String nickName, String gamePawn) {
        this.nickName = nickName;
        this.gamePawn = gamePawn;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGamePawn() {
        return gamePawn;
    }

    public void setGamePawn(String gamePawn) {
        this.gamePawn = gamePawn;
    }

}
