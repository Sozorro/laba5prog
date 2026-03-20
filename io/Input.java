package io;

import java.util.NoSuchElementException;
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
            try {
                System.out.println("----------------------");
                String s = readNextLine();
                if (s == null) continue;
                String[] command = s.split(" ", 2);
                if(!comParser.getCommands().containsKey(command[0])) continue;
                if(command.length == 1) comParser.interpret(command[0]);
                else comParser.interpret(command[0], command[1]);
            } catch (NoSuchElementException e) { //if end file(ctrl+D)
                scannerNow = new Scanner(System.in);
            }
        }
    }
    private static String readNextLine(){ 
        String s = scannerNow.nextLine().trim();
        while (s.equals("") || s == null) {
            s = scannerNow.nextLine().trim();
        }
        return s;
    }

    public static String getParams(String s, String... args){ 
        System.out.println(s);
        for(String arg : args) {
            System.out.println(arg);
        }
        String str = readNextLine().strip();
        return str;
    }
}
