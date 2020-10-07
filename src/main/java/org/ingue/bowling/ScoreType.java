package org.ingue.bowling;

import lombok.Getter;

@Getter
public enum ScoreType {
    NORMAL("일반"),
    SPARE("스페어"),
    STREAK("스트라이크");

    private final String name;

    ScoreType(String name) {
        this.name = name;
    }
}
