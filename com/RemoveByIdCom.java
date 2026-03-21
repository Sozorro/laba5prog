package com;

import exceptions.WrongParam;
import managers.CollectionManager;

public class RemoveByIdCom extends Command {
    public RemoveByIdCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "remove";
        this.description = "добавить элемент LabWork";
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
