package com.nextMagnus.backend.Controller;

import com.nextMagnus.backend.FenDTO;
import com.nextMagnus.backend.Model.Board;
import com.nextMagnus.backend.Model.MonteCarloTreeSearch;
import com.nextMagnus.backend.Model.MoveGenerator;
import com.nextMagnus.backend.Model.Node;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
    MoveGenerator mg = new MoveGenerator();


    public FenDTO get(FenDTO fenObject){
        Board board = new Board(fenObject.getFen());
        board.setKIPlaysWhite(false);

        //check if the game is over
        if(board.isGameOver()){
            if(board.isRemis()){
                fenObject.setMessage("Game Over - Remis");
                fenObject.setGameOver(true);
            } else {
                if(board.isWhiteWon()){
                    fenObject.setMessage("Game Over - White Won");
                    fenObject.setGameOver(true);
                } else {
                    fenObject.setMessage("Game Over - Black Won");
                    fenObject.setGameOver(true);
                }
            }
            return fenObject;
        }

        //if not over make a move
        long currentTime = System.currentTimeMillis();
        String validMoves = mg.validMoves(board);

        if (fenObject.getMode().equals("MonteCarloTreeSearch")){
            long timeLimit = MoveGenerator.standardDeviationTimeLimit(board.getNextMoveCount(), 300L);
            Node node = new Node (null, board);
            String move = MonteCarloTreeSearch.getBestMove(node, (int) timeLimit);
            fenObject.setMove(mg.convertInternalMoveToGameserverMove(move, board));
            MoveGenerator.makeMove(board, move);
        } else if (fenObject.getMode().equals("AlphaBeta")) {
            String move = mg.moveSelector(board, validMoves, fenObject.getUsedTime());
            fenObject.setMove(mg.convertInternalMoveToGameserverMove(move, board));
            mg.makeMove(board, move);
        }

        fenObject.setFen(board.bitboardsToFenParser());
        fenObject.setUsedTime(fenObject.getUsedTime() + (System.currentTimeMillis() - currentTime));


        //check if game is over
        if(board.isGameOver()){
            if(board.isRemis()){
                fenObject.setMessage("Game Over - Remis");
                fenObject.setGameOver(true);
            } else {
                if(board.isWhiteWon()){
                    fenObject.setMessage("Game Over - White Won");
                    fenObject.setGameOver(true);
                } else {
                    fenObject.setMessage("Game Over - Black Won");
                    fenObject.setGameOver(true);
                }
            }
        }
        return fenObject;
    }

}
