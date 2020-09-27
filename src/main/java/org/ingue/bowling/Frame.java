package org.ingue.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Frame {

    private int ballNumber;
    private int chance;
    private List<Integer> score;

    public Frame() {
        this.ballNumber = 10;
        this.chance = 2;
        this.score = new ArrayList<>();
    }

    public Frame(int ballNumber) {
        this.ballNumber = ballNumber;
        this.chance = 2;
    }

    public int pitch(int fallenPinNumber) {
        checkFallenPinNumber(fallenPinNumber);

        ballNumber -= fallenPinNumber;
        score.add(fallenPinNumber);
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
