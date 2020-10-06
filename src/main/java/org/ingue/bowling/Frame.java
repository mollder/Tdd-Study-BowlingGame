package org.ingue.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Frame {

    private int ballNumber;
    private int chance;
    boolean isSpare;
    private List<Integer> score;

    public Frame() {
        this.ballNumber = 10;
        this.chance = 2;
        this.isSpare = false;
        this.score = new ArrayList<>();
    }

    public Frame(int ballNumber) {
        this.ballNumber = ballNumber;
        this.chance = 2;
        this.isSpare = false;
    }

    public int pitch(int fallenPinNumber) {
        checkStatus(fallenPinNumber);

        ballNumber -= fallenPinNumber;
        score.add(fallenPinNumber);
        chance--;

        if(hitSpare()) {
            isSpare = true;
        }

        return fallenPinNumber;
    }

    private boolean hitSpare() {
        return chance == 0 && ballNumber == 0;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    private void checkStatus(int fallenPin) {
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
