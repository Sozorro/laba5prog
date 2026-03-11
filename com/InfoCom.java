package com;

import managers.CollectionManager;

public class InfoCom extends Command {
    public InfoCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "info";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {

    }
    
}
