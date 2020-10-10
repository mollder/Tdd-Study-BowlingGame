package org.ingue.bowling;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ScoreType {
    NORMAL("일반", "아쉽네요 좀 더 분발하셔야 할 것 같습니다"),
    SPARE("스페어", "축하합니다 ! 스페어 처리를 하셨네요!"),
    STREAK("스트라이크", "축하합니다 ! 스트라이크를 하셨네요!");

    private final String name;
    private final String message;

    ScoreType(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public static boolean isSpare(ScoreType input) {
        return input.equals(ScoreType.SPARE);
    }

    public static boolean isStreak(ScoreType input) {
        return input.equals(ScoreType.STREAK);
    }

    public static String getScoreTypeMessage(ScoreType input) {
        return Arrays.stream(ScoreType.values())
                .filter(scoreType -> scoreType.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력된 ScoreType이 잘못되었습니다. 입력된 ScoreType : " + input))
                .getMessage();
    }
}
