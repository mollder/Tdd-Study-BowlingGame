package org.ingue.bowling;

import lombok.Getter;

@Getter
public class ScoreBoard {

    private int[][] scoreBoard;

    public ScoreBoard() {
        this.scoreBoard = new int[10][3];
    }

    public void save(int round, Frame frame) {
        int[] score = frame.getScore();

        scoreBoard[round-1][0] = score[0];
        scoreBoard[round-1][1] = score[1];
    }

    public int[] getRoundScore(int round) {
        return scoreBoard[round-1];
    }

}
