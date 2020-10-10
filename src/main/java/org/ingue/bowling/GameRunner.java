package org.ingue.bowling;

public class GameRunner {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.runGame();
    }

    public void runGame() {
        printStartMessage();

        Board resultBoard = new Board();

        for (int round = 1; round <= 10; round++) {
            Frame frame = new Frame();

            playRound(round, frame);
            resultBoard.save(round, frame);

            printCheeringMessage(frame);
        }

        printTotalPoint(resultBoard);

        printEndMessage();
    }

    private void printEndMessage() {
        System.out.println("게임 종료");
    }

    private void printTotalPoint(Board resultBoard) {
        System.out.println("총 점수 : " + resultBoard.getTotalPoint());
    }

    private void printStartMessage() {
        System.out.println("게임을 시작합니다.");
    }

    private void playRound(int round, Frame frame) {
        int chance = 1;

        while (!frame.isEnd()) {
            System.out.println("라운드 " + round + "의 " + chance + "번째 공을 던지세요 !");

            int fallenPinNum = InputUtils.nextInt();

            frame.pitch(fallenPinNum);

            chance++;
        }
    }

    private void printCheeringMessage(Frame frame) {
        String cheeringMessage = ScoreType.getScoreTypeMessage(frame.getScore().getScoreType());

        System.out.println(cheeringMessage);
    }
}
