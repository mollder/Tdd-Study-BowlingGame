package org.ingue.bowling

import spock.lang.Specification

class FrameTest extends Specification {

    def "볼링핀 5개를 쓰러뜨리면 점수 5점이 반환되어야 한다"() {
        given:
        def fallenPin = 5
        def frame = new Frame()

        when:
        def result = frame.pitch(fallenPin)

        then:
        result == 5
    }

    def "남은 볼링핀 개수보다 높은 숫자가 입력으로 들어오면 에러"() {
        given:
        def wrongHighFallenPin = 6
        def frame = new Frame(5)

        when:
        frame.pitch(wrongHighFallenPin)

        then:
        thrown(IllegalArgumentException.class)
    }

    def "음수가 입력으로 들어오면 에러"() {
        given:
        def wrongLowFallenPin = -1
        def frame = new Frame();

        when:
        frame.pitch(wrongLowFallenPin)

        then:
        thrown(IllegalArgumentException.class)
    }

    def "기회가 없다면 NotHaveChanceException 발생"() {
        given:
        def chance = 0
        def frame = new Frame();
        frame.setChance(chance)

        when:
        frame.pitch(5)

        then:
        thrown(NotHaveChanceException.class)
    }
}
