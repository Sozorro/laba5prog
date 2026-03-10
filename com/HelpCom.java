package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import managers.CollectionManager;
import managers.ComParser;

public class HelpCom extends Command {
    public HelpCom(CollectionManager collectionManager) {
        super(collectionManager);
    }
    @Override
    public void execute(String... args) {
        ComParser pars = new ComParser(collectionManager);
        System.out.println("Список доступных команд: ");
        for(Command com : pars.getCommands().values()) {
            System.out.printf("%s: %s %n", com.getName(), com.getDescription());
        }
    }
}
