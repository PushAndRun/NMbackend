package com.nextMagnus.backend;

public class FenDTO {

    private String fen = "";

    private String move;

    private long usedTimeByAi = 0;

    private String mode = "AlphaBeta";

    private boolean gameOver = false;

    private String message = "";

    public String getFen() {
        return fen;
    }

    public long getUsedTime() {
        return usedTimeByAi;
    }

    public String getMode() {
        return mode;
    }

    public String getMove() {
        return move;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getMessage() {
        return message;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void setUsedTime(long usedTime) {
        this.usedTimeByAi = usedTime;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
