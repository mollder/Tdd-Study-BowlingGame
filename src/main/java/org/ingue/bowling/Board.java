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

    public Integer getTotalPoint() {
        Integer totalPoint = 0;

        for (int i = 0; isRoundExist(i); i++) {
            totalPoint += getRoundPoint(i);
        }

        return totalPoint;
    }

    private Integer getRoundPoint(int round) {
        Integer roundPoint = 0;

        roundPoint += getNormalPoint(round);

        if (isSpare(round)) {
            roundPoint += getSparePoint(round);
        }

        if (isStreak(round)) {
            roundPoint += getStreakPoint(round);
        }

        return roundPoint;
    }

    private boolean isStreak(int round) {
        Score currentRoundScore = board[round];

        return ScoreType.isStreak(currentRoundScore.getScoreType());
    }

    private boolean isSpare(int round) {
        Score currentRoundScore = board[round];

        return ScoreType.isSpare(currentRoundScore.getScoreType());
    }

    private Integer getNormalPoint(int round) {
        Integer normalPoint = 0;

        Score currentRoundScore = board[round];

        for (Integer point : currentRoundScore.getPointList()) {
            normalPoint += point;
        }

        return normalPoint;
    }

    private Integer getSparePoint(int round) {
        if (!isBonusExist(round)) {
            return 0;
        }

        return board[round + 1].getPointList().get(0);
    }

    private Integer getStreakPoint(int round) {
        if (!isBonusExist(round)) {
            return 0;
        }

        if(!isStreak(round+1)) {
            Integer firstBonus = board[round + 1].getPointList().get(0);
            Integer secondBonus = board[round + 1].getPointList().get(1);

            return firstBonus + secondBonus;
        }

        Integer firstBonus = 10;
        Integer secondBonus = 0;

        if(isBonusExist(round+1)) {
            secondBonus = board[round + 2].getPointList().get(0);
        }

        return firstBonus + secondBonus;
    }

    private boolean isRoundExist(int i) {
        return i < board.length && board[i] != null;
    }

    private boolean isBonusExist(int round) {
        return round < 9 && board[round + 1] != null;
    }
}
