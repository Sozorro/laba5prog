package com;

import managers.CollectionManager;
import managers.ComHistory;

public class HistoryCom extends Command {
    public HistoryCom(CollectionManager collectionManager) {
        super(collectionManager);
        this.name = "history";
        this.description = "Вывести 7 последних команд";
    }
    @Override
    public void execute(String... args) {
        if(ComHistory.getSize() <= 7) {
            ComHistory.printHistory();
        } else {
            for(int i = ComHistory.getSize() - 8; i < ComHistory.getSize();i++) {
                ComHistory.getCom(i);
            }
        }
        ComHistory.addCom(name, null);
    }
}
