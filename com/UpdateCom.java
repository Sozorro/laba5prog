package com;

import managers.CollectionManager;

public class UpdateCom extends Command {
    public UpdateCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "update";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {

    }
}
