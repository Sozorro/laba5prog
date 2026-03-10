package com;

import exeptions.WrongParam;
import managers.CollectionManager;

public class RemoveByIdCom extends Command {
    public RemoveByIdCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args) {
        try {
            if (args.length != 1) throw new WrongParam();
            collectionManager.delLab(Long.parseLong(args[0]));
        } catch (WrongParam|NumberFormatException e) {

        }
    }
}
