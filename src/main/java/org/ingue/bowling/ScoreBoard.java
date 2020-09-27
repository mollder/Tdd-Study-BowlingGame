package org.ingue.bowling;

import lombok.Getter;

import java.util.List;

@Getter
public class ScoreBoard {

    private int[][] scoreBoard;

    public ScoreBoard() {
        this.scoreBoard = new int[10][3];
    }

    public void save(int round, Frame frame) {
        List<Integer> score = frame.getScore();

        for(int i = 0; i < score.size(); i++) {
            scoreBoard[round-1][i] = score.get(i);
        }
    }

    public int[] getRoundScore(int round) {
        return scoreBoard[round-1];
    }

}
