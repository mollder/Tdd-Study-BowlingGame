package org.ingue.bowling

import spock.lang.Specification

class ScoreBoardTest extends Specification {

    def "차수와 전광판을 받아서 성공적으로 저장해야 한다."() {
        given:
        def frame = new Frame()
        frame.pitch(4)
        frame.pitch(5)

        def scoreBoard = new ScoreBoard()
        def round = 1

        when:
        scoreBoard.save(round, frame)
        def result = scoreBoard.getRoundScore(round)

        then:
        result[0] == 4
        result[1] == 5
    }
}
