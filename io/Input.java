package io;

import java.util.Scanner;
import manager.ComParser;

public class Input {
    private ComParser comParser = new ComParser();
    public void start() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String s = scan.nextLine();
            String[] command = s.split(" ", 2);
            comParser.interpret(command[0], command[1]);
        }
    }
}
