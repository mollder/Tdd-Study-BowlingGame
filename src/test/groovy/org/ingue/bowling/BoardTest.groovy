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
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 17
    }

    def "1라운드에 스페어, 2라운드에 8점을 획득하면 총 점수는 26점이어야 합니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(9)
        firstFrame.pitch(1)

        def secondFrame = new Frame()
        secondFrame.pitch(8)
        secondFrame.pitch(0)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 26
    }

    def "1라운드에 8점, 2라운드에 스페어이고, 3라운드는 진행되지 않았다면 총 점수는 18점이어야 합니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(8)
        firstFrame.pitch(0)

        def secondFrame = new Frame()
        secondFrame.pitch(9)
        secondFrame.pitch(1)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 18
    }

    def "1라운드에 8점, 2라운드에 스페어이고, 3라운드는 0점이라면 총 점수는 18점이어야 합니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(8)
        firstFrame.pitch(0)

        def secondFrame = new Frame()
        secondFrame.pitch(9)
        secondFrame.pitch(1)

        def thirdFrame = new Frame()
        thirdFrame.pitch(0)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)
        board.save(3, thirdFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 18
    }

    def "1라운드에 스트라이크, 2라운드에 8점을 얻었다면 총 점수는 26점이어야 합니다"() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(10)

        def secondFrame = new Frame()
        secondFrame.pitch(8)
        secondFrame.pitch(0)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 26
    }

    def "1라운드에 스트라이크, 2라운드에 스트라이크, 3라운드에 8점을 얻었다면 총 점수는 54점입니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(10)

        def secondFrame = new Frame()
        secondFrame.pitch(10)

        def thirdFrame = new Frame()
        thirdFrame.pitch(8)
        thirdFrame.pitch(0)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)
        board.save(3, thirdFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 54
    }

    def "1라운드에 스트라이크, 2라운드에 스트라이크, 3라운드에 스트라이크라면 총 점수는 60점입니다."() {
        given:
        def firstFrame = new Frame()
        firstFrame.pitch(10)

        def secondFrame = new Frame()
        secondFrame.pitch(10)

        def thirdFrame = new Frame()
        thirdFrame.pitch(10)

        def board = new Board()
        board.save(1, firstFrame)
        board.save(2, secondFrame)
        board.save(3, thirdFrame)

        when:
        def totalPoint = board.getTotalPoint()

        then:
        totalPoint == 60
    }
}
