package io;

import java.util.Scanner;

import manager.CollectionManager;
import manager.ComParser;

public class Input {
    private static ComParser comParser;
    public static void start(CollectionManager collectionManager) {
        comParser = new ComParser(collectionManager);
        Scanner scan = new Scanner(System.in);
        while (true) {
            String s = scan.nextLine();
            String[] command = s.split(" ", 2);
            comParser.interpret(command[0], command[1]);
        }
    }
}
