package com;

import java.io.File;

import exeptions.WrongParam;
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
        if(args.length != 1) throw new WrongParam("Неверное имя файла, проверьте корректность ввода и отсутствие пробелов в названии");
        File myFile = new File(args[0]);
        InputFile.start(myFile, collectionManager);
    }
}
