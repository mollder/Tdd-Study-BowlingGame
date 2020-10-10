package org.ingue.bowling;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Score {

    private ScoreType scoreType;
    private List<Integer> pointList;

    public Score() {
        this.scoreType = ScoreType.NORMAL;
        this.pointList = new ArrayList<>();
    }

    public void add(int fallenPinNumber) {
        pointList.add(fallenPinNumber);
    }

    public void setScoreType(int chance, int ballNumber) {
        if (hitSpare(chance, ballNumber)) {
            this.scoreType = ScoreType.SPARE;
        }

        if (hitStreak(chance, ballNumber)) {
            this.scoreType = ScoreType.STREAK;
        }
    }

    private boolean hitStreak(int chance, int ballNumber) {
        return chance == 1 && ballNumber == 0;
    }

    private boolean hitSpare(int chance, int ballNumber) {
        return chance == 0 && ballNumber == 0;
    }
}
