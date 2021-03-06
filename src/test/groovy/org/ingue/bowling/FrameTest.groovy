package org.ingue.bowling

import spock.lang.Specification

class FrameTest extends Specification {

    def "첫 프레임 기회에서 볼링핀 4개를 쓰러뜨리면 남은핀의 개수는 6개, 기회는 1이다"() {
        given:
        def fallenPin = 4
        def frame = new Frame()

        when:
        frame.pitch(fallenPin)

        then:
        frame.ballNumber == 6
        frame.chance == 1
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
        def frame = new Frame()

        when:
        frame.pitch(wrongLowFallenPin)

        then:
        thrown(IllegalArgumentException.class)
    }

    def "기회가 없다면 NotHaveChanceException 발생"() {
        given:
        def chance = 0
        def frame = new Frame()
        frame.setChance(chance)

        when:
        frame.pitch(5)

        then:
        thrown(NotHaveChanceException.class)
    }

    def "두번의 기회를 거쳐서 10개의 핀을 쓰려뜨리면 해당 프레임은 스페어"() {
        given:
        def frame = new Frame()

        when:
        frame.pitch(5)
        frame.pitch(5)

        then:
        frame.getScore().scoreType == ScoreType.SPARE
    }

    def "한번만에 10개의 핀을 쓰러뜨리면 해당 프레임은 스트라이크"() {
        given:
        def frame = new Frame()

        when:
        frame.pitch(10)

        then:
        frame.getScore().scoreType == ScoreType.STREAK
    }
}
