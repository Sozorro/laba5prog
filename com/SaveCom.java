package com;

import managers.CollectionManager;

public class SaveCom extends Command {
    public SaveCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "save";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {

    }
    /*
    Для создания файла можно использовать метод File.createNewFile(). 
    Он создаст новый файл, если файл с таким названием еще не существует. 
    Если же такой файл уже есть, то метод createNewFile() выдаст исключение IOException.
     */
}
