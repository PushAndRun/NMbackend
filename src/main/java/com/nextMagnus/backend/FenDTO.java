package com.nextMagnus.backend;

public class FenDTO {

    private String fen = "";

    private String possibleMoves;

    private long usedTime = 0;

    private String mode = "AlphaBeta";

    private boolean gameOver = false;

    private String message = "";

    public String getFen() {
        return fen;
    }

    public long getUsedTime() {
        return usedTime;
    }

    public String getMode() {
        return mode;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public void setPossibleMoves(String possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public void setUsedTime(long usedTime) {
        this.usedTime = usedTime;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
