package org.ingue.bowling;

public class Frame {

    private int ballNumber;
    private int change;
    private int[] score;

    public Frame() {
        ballNumber = 10;
        change = 2;
        score = new int[3];
    }

    public Frame(int ballNumber) {
        this.ballNumber = ballNumber;
        change = 2;
        score = new int[3];
    }

    public int pitch(int fallenPin) {
        if(notHaveChance()) {
            throw new NotHaveChanceException("no more chance");
        }

        if(isWrongNumber(fallenPin)) {
            throw new IllegalArgumentException("Incorrect number of fallen pin");
        }

        return fallenPin;
    }

    public void setChance(int chance) {
        this.change = chance;
    }

    private boolean notHaveChance() {
        return change <= 0;
    }

    private boolean isWrongNumber(int fallenPin) {
        return fallenPin < 0 || fallenPin > ballNumber;
    }
}
