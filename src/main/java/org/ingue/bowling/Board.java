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

}
