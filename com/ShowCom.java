package com;

import managers.CollectionManager;

public class ShowCom extends Command {
    public ShowCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "show";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {

    }
    
}