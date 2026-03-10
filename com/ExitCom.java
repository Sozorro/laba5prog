package com;

import managers.CollectionManager;

public class ExitCom extends Command {
    public ExitCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args) {
        System.exit(0);
    }
    //scan.close();?
}
