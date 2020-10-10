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

    public int getTotalPoint() {
        int totalPoint = 0;

        for(int i = 0; isRoundExist(i); i++) {
            totalPoint += getRoundPoint(i);
        }

        return totalPoint;
    }

    private int getRoundPoint(int round) {
        int roundPoint = 0;

        roundPoint += getNormalPoint(round);

        if(isSpare(round)) {
            roundPoint += getSparePoint(round);
        }

        return roundPoint;
    }

    private boolean isSpare(int round) {
        Score currentRoundScore = board[round];

        return ScoreType.isSpare(currentRoundScore.getScoreType());
    }

    private int getNormalPoint(int round) {
        int normalPoint = 0;

        Score currentRoundScore = board[round];

        for(int point : currentRoundScore.getPointList()) {
            normalPoint += point;
        }

        return normalPoint;
    }

    private int getSparePoint(int round) {
        if(isSpareBonusExist(round)) {
            return board[round + 1].getPointList().get(0);
        }

        return 0;
    }

    private boolean isRoundExist(int i) {
        return i < board.length && board[i] != null;
    }

    private boolean isSpareBonusExist(int round) {
        return round < 9 && board[round+1] != null;
    }
}
