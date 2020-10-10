package org.ingue.bowling;

public class Board {

    private Score[] board;

    public Board() {
        this.board = new Score[10];
    }

    public void save(int round, Frame frame) {
        board[round - 1] = frame.getScore();
    }

    public Score getRoundScore(int round) {
        return board[round - 1];
    }

    public int getTotalGamePoint() {
        int totalGamePoint = 0;

        for(int i = 0; i < board.length && board[i] != null; i++) {
            Score currentRoundScore = board[i];

            totalGamePoint += getTotalRoundPoint(currentRoundScore);
        }

        return totalGamePoint;
    }

    private int getTotalRoundPoint(Score currentScore) {
        int roundTotalPoint = 0;

        for(int point : currentScore.getPointList()) {
            roundTotalPoint += point;
        }

        return roundTotalPoint;
    }
}
