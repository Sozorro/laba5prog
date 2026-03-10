package com;

import exeptions.WrongParam;
import managers.CollectionManager;

public class FilterStartsWithDescriptionCom extends Command {
    public FilterStartsWithDescriptionCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args) {
        try {
            if (args == null) {
                throw new WrongParam();
            }
            for(var elem : collectionManager.findElems(args)) {
                System.out.println(elem);
            }
        } catch (WrongParam e) {

        }
    }
}
