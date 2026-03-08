package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import manager.CollectionManager;
import manager.ComParser;

public class InputFile {
    private static ComParser comParser;
    public static void start(File myFile, CollectionManager collectionManager) {
        try {
            comParser = new ComParser(collectionManager);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            //throw new WrongParam("Данный файл не найден");
        }
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
