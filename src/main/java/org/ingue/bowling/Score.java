package org.ingue.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Score {

    private boolean isSpare;
    private boolean isStreak;
    private List<Integer> pointList;

    public Score() {
        this.isSpare = false;
        this.isStreak = false;
        this.pointList = new ArrayList<>();
    }

    public void add(int fallenPinNumber) {
        pointList.add(fallenPinNumber);
    }

    public void setSpare(boolean isSpare) {
        this.isSpare = isSpare;
    }

    public void setStreak(boolean isStreak) {
        this.isStreak = isStreak;
    }
}
