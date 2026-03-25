package com;

import java.io.File;
import java.io.FileNotFoundException;

import exceptions.WrongParam;
import io.Input;
import io.InputFile;
import managers.CollectionManager;

public class ExecuteScriptCom extends Command {
    public ExecuteScriptCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "execute";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {
        try {
            String[] str;
            if(args == null) str = Input.getParams("Какой файл вы хотите запустить?").split(" ");
            else str = args;
            if(args.length != 1) throw new WrongParam("Неверное имя файла, проверьте корректность ввода и отсутствие пробелов в названии");
            File myFile = new File(args[0]);
            InputFile.start(myFile, collectionManager);
        } catch (FileNotFoundException e) {
            System.out.println("Данный файл не найден");
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tИначе введите: \"no\" \n \t");
            if(prov != null && prov.equals("yes")) {
                execute();
            }
        } catch (WrongParam e) {
            System.out.println(e.getMessage());
            String prov = Input.getParams("\tЕсли хотите попробовать ещё раз введите: \"yes\" \n \tИначе введите: \"no\" \n \t");
            if(prov != null && prov.equals("yes")) {
                execute();
            }
        }
    }
}
