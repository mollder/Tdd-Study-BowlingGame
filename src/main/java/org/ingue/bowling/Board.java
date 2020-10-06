package org.ingue.bowling;

import lombok.Getter;

import java.util.List;

@Getter
public class Board {

    private int[][] board;

    public Board() {
        this.board = new int[10][3];
    }

    public void save(int round, Frame frame) {
        List<Integer> score = frame.getScore();

        for(int i = 0; i < score.size(); i++) {
            board[round-1][i] = score.get(i);
        }
    }

    public int[] getRoundScore(int round) {
        return board[round-1];
    }

}
