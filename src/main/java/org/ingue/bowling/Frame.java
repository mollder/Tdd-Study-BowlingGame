package org.ingue.bowling;

import lombok.Getter;

@Getter
public class Frame {

    private int ballNumber;
    private int chance;
    private int[] score;

    public Frame() {
        this.ballNumber = 10;
        this.chance = 2;
        this.score = new int[2];
    }

    public Frame(int ballNumber) {
        this.ballNumber = ballNumber;
        this.chance = 2;
    }

    public int pitch(int fallenPinNumber) {
        checkFallenPinNumber(fallenPinNumber);

        ballNumber -= fallenPinNumber;
        score[2-chance] = fallenPinNumber;
        chance--;

        return fallenPinNumber;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    private void checkFallenPinNumber(int fallenPin) {
        if(notHaveChance()) {
            throw new NotHaveChanceException("no more chance");
        }

        if(isWrongNumber(fallenPin)) {
            throw new IllegalArgumentException("Incorrect number of fallen pin");
        }
    }

    private boolean notHaveChance() {
        return chance <= 0;
    }

    private boolean isWrongNumber(int fallenPin) {
        return fallenPin < 0 || fallenPin > ballNumber;
    }
}
