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
        def result = board.getRoundScore(round)

        then:
        result[0] == 4
        result[1] == 5
    }
}
