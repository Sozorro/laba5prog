package com;

import builders.LabWorkBuilder;
import managers.CollectionManager;

public class AddCom extends Command {
    public AddCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args){
        if(args == null) {
            LabWorkBuilder labWorkBuilder = new LabWorkBuilder();
            collectionManager.addLab(labWorkBuilder.makeLabWork());
        }
        
    }
    /*передача параметров через конструкторы? */
}
