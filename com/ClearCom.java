package com;

import managers.CollectionManager;

public class ClearCom extends Command {
    public ClearCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args) {
        collectionManager.delLabs();
    }
}
