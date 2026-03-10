package io;

import java.util.Scanner;

import managers.CollectionManager;
import managers.ComParser;

public class Input {
    private static ComParser comParser;
    public static Scanner scannerNow;
    public static void start(CollectionManager collectionManager) {
        comParser = new ComParser(collectionManager);
        scannerNow = new Scanner(System.in);
        while (true) {
            String s = scannerNow.nextLine();
            String[] command = s.split(" ", 2);
            comParser.interpret(command[0], command[1]);
        }
    }
    public static String getParams(String s){ 
        System.out.println(s);
        String str = scannerNow.nextLine();
        return str;
    }
}
