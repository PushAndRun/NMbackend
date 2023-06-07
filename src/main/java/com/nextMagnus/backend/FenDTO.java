package com.nextMagnus.backend;

public class FenDTO {

    private String fen;

    private String[] possibleMoves;

    public FenDTO(String fen, String[] possibleMoves) {
        this.fen = fen;
        this.possibleMoves = possibleMoves;
    }
}
