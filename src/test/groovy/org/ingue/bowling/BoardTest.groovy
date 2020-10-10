package org.ingue.bowling

import spock.lang.Specification

class BoardTest extends Specification {

    def "차수와 전광판을 받아서 성공적으로 저장해야 한다."() {
        given:
        def frame = new Frame()
        frame.pitch(4)
        frame.pitch(5)

        def board = new Board()
        def round = 1

        when:
        board.save(round, frame)

        def score = board.getRoundScore(round)
        def pointList = score.getPointList()

        then:
        pointList.get(0) == 4
        pointList.get(1) == 5
    }

    def "1라운드에 9점, 2라운드에 8점을 획득하면 총 점수는 17점이어야 합니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(4)
        firstFrame.pitch(5)

        def secondFrame = new Frame()
        secondFrame.pitch(4)
        secondFrame.pitch(4)

        def board = new Board()

        board.save(1, firstFrame)
        board.save(2, secondFrame)

        when:
        def totalPoint = board.getTotalGamePoint()

        then:
        totalPoint == 17
    }
}
