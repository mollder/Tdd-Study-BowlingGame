package org.ingue.bowling;

import java.util.Scanner;

public abstract class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return scanner.nextInt();
    }
}
