package io;

import java.util.Scanner;

import manager.ComParser;

public class InputFile {
    private ComParser comParser = new ComParser();
    public void start() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String s = scan.nextLine();
            String[] command = s.split(" ", 2);
            comParser.interpret(command[0], command[1]);
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
    
    */
}
