package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import managers.CollectionManager;
import managers.ComParser;

public class InputFile {
    private static ComParser comParser;
    public static Scanner scannerNow;
    public static boolean readFile = false;
    private static String str = "";
    private static String[] col;
    private static String[] command;

    public static void start(File myFile, CollectionManager collectionManager) {
        readFile = true;
        try (InputStreamReader file = new InputStreamReader(new FileInputStream(myFile))) {
            comParser = new ComParser(collectionManager);
            int c = file.read();
            while (c != '\n') {
                str += (char) c;
                c = file.read();
            }
            col = str.split(",");
            while (c != -1) {
                if ((c == '\n' || c == '\r') && str != "") {
                    command = str.split(",");
                    comParser.interpret(command[0]);
                    str = "";
                }
                else {
                    str += (char) c;
                }
                c = file.read();
            }
        } 
        catch (FileNotFoundException e) {
            //throw new WrongParam("Данный файл не найден");
        } catch (IOException e) {       
        } 
        readFile = false;
    }
    public static String getParams(String... s){
        if(s[0] == "Id") {
            return command[1];
        }
        else if(s[0] == "Person") {
            if(s[1] == "name") return command[10];
            else if(s[1] == "height") return command[11];
            else if(s[1] == "weight") return command[12];
            else if(s[1] == "passportID") return command[13];
            else if(s[1] == "hairColor") return command[14];
        }
        else if(s[0] == "LabWork") {
            if(s[1] == "date") return command[2];
            else if(s[1] == "name") return command[3];
            else if(s[1] == "coordinatesX") return command[4];
            else if(s[1] == "coordinatesY") return command[5];
            else if(s[1] == "minimalPoint") return command[6];
            else if(s[1] == "personalQualitiesMinimum") return command[7];
            else if(s[1] == "description") return command[8];
            else if(s[1] == "difficulty") return command[9];
            else if(s[1] == "person") return getParams("Person", s[2]);
        }
        return null;
    }
    /*
    Должно быть:
    При запуске приложения коллекция должна автоматически заполняться значениями из файла.
    Имя файла должно передаваться программе с помощью: аргумент командной строки.
    Данные должны храниться в файле в формате csv
    Чтение данных из файла необходимо реализовать с помощью класса java.io.InputStreamReader
    Запись данных в файл необходимо реализовать с помощью класса java.io.OutputStreamWriter
    Все классы в программе должны быть задокументированы в формате javadoc.
    Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
    
    Чтение данных из файла необходимо реализовать с помощью класса java.io.InputStreamReader
    Запись данных в файл необходимо реализовать с помощью класса java.io.OutputStreamWriter
    */
}
