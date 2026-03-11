package com;

import managers.CollectionManager;

public class ClearCom extends Command {
    public ClearCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "clear";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {
        collectionManager.delLabs();
    }
}
