package org.ingue.bowling;

import lombok.Getter;

@Getter
public class Frame {

    private int ballNumber;
    private int chance;
    private Score score;

    public Frame() {
        this.ballNumber = 10;
        this.chance = 2;
        score = new Score();
    }

    public Frame(int ballNumber) {
        this.ballNumber = ballNumber;
        this.chance = 2;
        score = new Score();
    }

    public int pitch(int fallenPinNumber) {
        checkStatus(fallenPinNumber);

        ballNumber -= fallenPinNumber;
        score.add(fallenPinNumber);
        chance--;

        if (hitSpare()) {
            score.setSpare(true);
        }

        if (hitStreak()) {
            score.setStreak(true);
        }

        return fallenPinNumber;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    private boolean hitStreak() {
        return chance == 1 && ballNumber == 0;
    }

    private boolean hitSpare() {
        return chance == 0 && ballNumber == 0;
    }

    private void checkStatus(int fallenPin) {
        if (notHaveChance()) {
            throw new NotHaveChanceException("no more chance");
        }

        if (isWrongNumber(fallenPin)) {
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
