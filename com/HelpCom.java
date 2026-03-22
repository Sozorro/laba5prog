package com;

import managers.CollectionManager;
import managers.ComHistory;
import managers.ComParser;

public class HelpCom extends Command {
    public HelpCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "help";
        this.description = "Вывести справку по доступным командам";
    }
    @Override
    public void execute(String... args) {
        ComParser pars = new ComParser(collectionManager);
        ComHistory.addCom(name, null);
        System.out.println("Список доступных команд: ");
        for(Command com : pars.getCommands().values()) {
            System.out.printf("%s: %s %n", com.getName(), com.getDescription());
        }
    }
}
