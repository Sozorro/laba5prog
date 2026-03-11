package com;

import managers.CollectionManager;

public class HistoryCom extends Command {
    public HistoryCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "history";
        this.description = "добавить элемент LabWork";
    }
    @Override
    public void execute(String... args) {

    }
}
